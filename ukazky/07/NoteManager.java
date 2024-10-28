/*
    Hlavní Body:
        Serializable Interface: K čemu slouží a jak umožňuje objekty zapsat do souboru.
        Object Streams: ObjectOutputStream a ObjectInputStream a jakým způsobem mohou zapisovat/cist objekty do/ze souborů.
        Try-with-Resources: Vysvětlení, jak try-with-resources zjednodušuje práci se zdroji (v tomto případě se soubory).

    Analýza Kódu:
        Třída Note: Definuje poznámku a je označena jako Serializable, takže její instance mohou být serializovány.
        Ukládání Poznámek: Metoda saveNotes() ukládá seznam poznámek do souboru pomocí ObjectOutputStream.
        Načítání Poznámek: Metoda loadNotes() načítá seznam poznámek ze souboru pomocí ObjectInputStream.
        
    Mini Cvičení:
        Editace Poznámek: Umožněte uživateli upravit existující poznámky.
        Vyhledávání Poznámek: Implementujte funkci, která umožní uživateli vyhledávat poznámky podle klíčových slov v obsahu.
        Uživatelské Rozhraní: Vytvořte jednoduché GUI pro aplikaci s použitím JavaFX nebo Swing.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Note implements Serializable {
    String title;
    String content;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nContent: " + content;
    }
}

public class NoteManager {

    public static void saveNotes(List<Note> notes, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(notes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Note> loadNotes(String filename) {
        List<Note> notes = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            notes = (List<Note>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return notes;
    }

    public static void main(String[] args) {
        List<Note> notes = new ArrayList<>();
        notes.add(new Note("Grocery List", "Milk, Eggs, Bread"));
        notes.add(new Note("To-Do", "Homework, Laundry"));

        // Save notes to file
        saveNotes(notes, "notes.dat");

        // Load notes from file
        List<Note> loadedNotes = loadNotes("notes.dat");

        // Display loaded notes
        for (Note note : loadedNotes) {
            System.out.println(note);
            System.out.println("-----");
        }
    }
}
