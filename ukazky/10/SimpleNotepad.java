/*
    Tato aplikace bude jednoduchý textový editor, který umožní uživatelům psát text, ukládat a otevírat soubory.

    Hlavní Body k Probrání:
        UI Elementy: TextArea, MenuBar, Menu, a MenuItem pro interakci.
        Layouts: BorderPane uspořádává prvky.
        Event Handling: setOnAction pro ovládání událostí menu.
        FileChooser: Pro práci se souborovým systémem.

    Analýza Kódu:
        start: Metoda je vstupním bodem pro JavaFX aplikaci, kde je vytvořeno GUI.
        openItem.setOnAction: Čtení textového souboru a jeho zobrazení v TextArea.
        saveItem.setOnAction: Uložení obsahu TextArea do souboru.
 
    Mini Cvičení:
        Úpravy Textu: Přidejte možnosti formátování textu (tučné, kurzíva, velikost písma).
        Další Funkce: Přidejte funkce jako "Undo", "Redo", a "Find".
        Další Menu: Přidejte menu pro editaci a formátování textu.



    Pokud používáte Java 11 nebo novější, JavaFX byl odstraněn z oficiální distribuce JDK a je třeba jej doinstalovat a správně nastavit. 
    Postupujte podle těchto kroků, abyste problém vyřešili:

    Stažení a instalace JavaFX:
        Stáhněte si JavaFX SDK z oficiálních stránek - https://openjfx.io/
        Rozbalte stažený archiv na vhodné místo na disku.
    
    Nastavení projektu:
        Pokud používáte nějaké IDE (např. IntelliJ IDEA nebo Eclipse), přidejte JavaFX knihovny (jars) do vašeho projektu. 
        Tyto jar soubory můžete najít v lib složce JavaFX SDK, který jste právě stáhli.
        VSCode:
            upravit .vscode/setting.json
            "java.project.referencedLibraries": [
                "cesta_k_javafx_lib/*.jar"
            ]
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SimpleNotepad extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        
        // Create MenuBar and Menus
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        fileMenu.getItems().addAll(openItem, saveItem);
        menuBar.getMenus().add(fileMenu);
        
        // Open functionality
        openItem.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                try {
                    String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
                    textArea.setText(content);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        
        // Save functionality
        saveItem.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(primaryStage);
            if (file != null) {
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(textArea.getText());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        
        // Layout setup
        BorderPane layout = new BorderPane();
        layout.setTop(menuBar);
        layout.setCenter(textArea);
        
        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple Notepad");
        primaryStage.show();
    }
}
