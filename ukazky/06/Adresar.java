/*
    Hlavní Body :
        Co je to HashMap a k čemu slouží?
        Způsob, jakým můžete vytvářet a inicializovat HashMap.
        Metody, které HashMap nabízí – put, get, remove a další.
        Způsob, jakým HashMap zpracovává klíče a hodnoty.
        Vytváření a používání vlastní třídy (Kontakt) jako hodnoty v HashMap.
        Iterace přes hodnoty HashMap pomocí values() metody.

    Analýza Kódu:
        Třída Kontakt: Definuje jednoduchou třídu Kontakt, která obsahuje jméno, telefonní číslo a adresu.
        Konstruktor Kontaktu: Umožňuje vytvářet nové objekty Kontakt s definovanými hodnotami.
        HashMap 'adresar': Představuje adresář, kde klíčem je jméno kontaktu a hodnotou je objekt Kontakt.
        Přidání Kontaktů: Ukazuje, jak přidat nové kontakty do HashMap pomocí metody put.
        Procházení HashMapy: Demonstruje, jak projít všechny hodnoty v HashMap pomocí for-each smyčky a values() metody.
        Hledání a Odebírání Kontaktu: Použití metod get a remove k nalezení konkrétního kontaktu podle klíče a jeho následnému odstranění.

    Mini Cvičení:
        Rozšíření Kontaktu: Přidejte do třídy Kontakt nový atribut, například email, a upravte kód tak, aby s tímto novým atributem pracoval.
        Vyhledávání Podle Čísla: Upravte kód tak, aby mohli uživatelé vyhledávat kontakty podle telefonního čísla místo jména.
        Seřazení Kontaktů: Implementujte funkci, která seřadí a vypíše kontakty v adresáři podle jména (nebo jiného kritéria).
        Kontrola Duplicit: Před přidáním nového kontaktu do adresáře implementujte kontrolu, zda kontakt s daným jménem nebo telefonním číslem již v adresáři existuje. Pokud ano, upozorněte uživatele.
        Upravení Kontaktu: Vytvořte metodu, která umožní upravit existující kontakt v adresáři.
 */

import java.util.HashMap;

class Kontakt {
    private String jmeno;
    private String telefonniCislo;
    private String adresa;

    public Kontakt(String jmeno, String telefonniCislo, String adresa) {
        this.jmeno = jmeno;
        this.telefonniCislo = telefonniCislo;
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return jmeno + " | Telefon: " + telefonniCislo + " | Adresa: " + adresa;
    }
}

public class Adresar {
    public static void main(String[] args) {
        HashMap<String, Kontakt> adresar = new HashMap<>();

        // Přidání kontaktů
        adresar.put("Jan Novák", new Kontakt("Jan Novák", "123-456-789", "Nová ulice 5, Praha"));
        adresar.put("Anna Svobodová", new Kontakt("Anna Svobodová", "987-654-321", "Stará ulice 10, Brno"));

        // Zobrazení všech kontaktů
        System.out.println("Kontakty:");
        for (Kontakt kontakt : adresar.values()) {
            System.out.println(kontakt);
        }

        // Hledání kontaktu
        System.out.println("\nKontakt 'Jan Novák':");
        System.out.println(adresar.get("Jan Novák"));

        // Odstranění kontaktu
        adresar.remove("Anna Svobodová");
        System.out.println("\nKontakty po odstranění 'Anna Svobodová':");
        for (Kontakt kontakt : adresar.values()) {
            System.out.println(kontakt);
        }
    }
}
