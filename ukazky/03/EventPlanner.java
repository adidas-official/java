/*
    Hlavní Body:
        Práce s Datem a Časem: Jak zpracovávat datum pomocí třídy LocalDate a formátovat datum pomocí DateTimeFormatter.
        Vstup a Výstup: Zpracování uživatelského vstupu a výstupu konzole s System.out.println a Scanner.
        Ošetření Výjimek: Použití try/catch k ošetření možných problémů při parsování dat z řetězce.
    Analýza Kódu:
        Čtení Vstupu: Uživatel je požádán o zadání názvu a data události.
        Parsování Data: Vstupní řetězec je převeden na objekt LocalDate použitím DateTimeFormatter.
        Kontrola Data: Zkontroluje se, zda je zadané datum události v budoucnosti ve srovnání se současným datem.
        Výstup: Vypíše se potvrzení o plánování události nebo se zobrazí chybová zpráva, pokud je datum neplatné nebo v minulosti.
    Mini Cvičení:
        Přidání Času: Umožněte uživateli zadávat čas události (hh:mm) a zobrazte jej v potvrzovací zprávě.
        Časová Kontrola: Přidejte kontrolu, která zajistí, že uživatel nemůže naplánovat událost na minulý čas v aktuální den.
        Opakování Události: Přidejte možnost nastavit opakování události (např. každý týden) a vypište data příštích n událostí.
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EventPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Výzva uživateli k zadání jména události
        System.out.println("Enter the name of the event:");
        String eventName = scanner.nextLine();

        // Výzva uživateli k zadání data události
        System.out.println("Enter the date of the event (yyyy-MM-dd):");
        String eventDateInput = scanner.nextLine();
        
        LocalDate eventDate;
        try {
            // Převedení řetězce na objekt LocalDate
            eventDate = LocalDate.parse(eventDateInput, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (Exception e) {
            // Ošetření možné výjimky při parsování data
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return;
        }
        
        // Získání současného data
        LocalDate currentDate = LocalDate.now();

        // Kontrola, zda je datum události v budoucnosti
        if (!eventDate.isAfter(currentDate)) {
            System.out.println("The event date must be in the future.");
            return;
        }

        // Výpis potvrzení o vytvoření události
        System.out.println("Event '" + eventName + "' scheduled for: " + eventDate);
    }
}
