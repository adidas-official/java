/*
    Hlavní Body:
        ArrayList: Vytváření a používání kolekcí k uchovávání objektů (knih).
        Sortování Kolekcí: Používání Collections.sort a lambdy k řazení knih podle různých atributů.
        Hledání v Kolekcích: Lineární prohledávání kolekce k nalezení knihy.
        Práce s Řetězci: Porovnávání řetězců pomocí equalsIgnoreCase a konverze objektů na řetězce.

    Analýza Kódu:
        Třída Book: Vlastnosti, konstruktor a přepsaná metoda toString pro snadný výpis.
        ArrayList books: Kolekce uchovávající objekty Book.
        Sortování: Používání metody sort z třídy Collections k řazení kolekcí knih podle názvu.
        Vyhledávání Knihy: Prohledávání knih podle názvu pomocí for-each cyklu
        
    Mini Cvičení:
        Další Atributy: Přidejte další atributy (např. hodnocení) do třídy Book a umožněte uživateli řadit seznam podle těchto atributů.
        Odstranění Knihy: Implementujte funkcionalitu, která umožní uživateli odstranit knihu z kolekce podle názvu.
        Vstup od Uživatele: Umožněte uživateli přidávat, vyhledávat a odstraňovat knihy pomocí konzolového vstupu.
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Book {
    String title;
    String author;
    int yearPublished;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + yearPublished + ")";
    }
}

public class BookManager {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        books.add(new Book("1984", "George Orwell", 1949));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        books.add(new Book("Brave New World", "Aldous Huxley", 1932));
        books.add(new Book("Animal Farm", "George Orwell", 1945));
        
        // Sorting books by title
        Collections.sort(books, Comparator.comparing(book -> book.title));
        System.out.println("Books sorted by title: " + books);
        
        // Searching for a book by title
        String searchTitle = "1984";
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(searchTitle)) {
                System.out.println("Found: " + book);
                break;
            }
        }
    }
}
