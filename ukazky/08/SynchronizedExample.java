/*
    Klíčové slovo synchronized v Javě je nástroj pro řešení problémů s konkurencí.
    Umožňuje zajištění, že v daném čase může danou část kódu vykonávat pouze jedno vlákno, 
    což je zvláště užitečné při práci s sdílenými zdroji nebo údaji.

    Hlavní použití synchronized je zajištění toho, že sdílený zdroj (např. sdílená proměnná, kolekce atd.) 
    je bezpečně přístupný z více vláken, což minimalizuje riziko nekonzistentních nebo neočekávaných výsledků 
    v důsledku konkurentního přístupu.


    SharedResource Třída:

    Je to třída reprezentující sdílený zdroj. Má vnitřní proměnnou count.
    Má dvě synchronized metody: increment() (zvyšuje hodnotu count o 1) a getCount() (vrací aktuální hodnotu count).
    Lambda Funkce:

    () -> { ... kód ... } je lambda výraz v Javě. Lambda výrazy umožňují definovat krátké bloky kódu bez nutnosti 
    definovat celou anonymní třídu. V tomto případě lambda výrazy definují, co by měla vlákna t1 a t2 provádět.
    Vlákna t1 a t2:

    Vytvoříme dvě vlákna (t1 a t2), přičemž každé z nich zvýší hodnotu count v SharedResource 10 000krát.
    Protože obě vlákna přistupují k stejnému sdílenému zdroji a upravují ho současně, existuje potenciální riziko "race condition" (soutěžící přístup).
    Metoda join():

    join() je metoda třídy Thread. Když na vláknu zavoláte join(), hlavní vlákno (v tomto případě hlavní metoda) čeká, až dané vlákno dokončí svou práci.
    Zde je join() použito, aby se hlavní vlákno postaralo o to, že vlákna t1 a t2 dokončí svoji práci dřív, než se vypíše konečná hodnota count.
    Synchronized metody:

    Použití synchronized znamená, že v daný moment může do synchronizované metody vstoupit jen jedno vlákno. Jinými slovy, 
    když jedno vlákno zvyšuje hodnotu count, druhé musí čekat.
    Pokud by metody nebyly synchronized, mohl by nastat problém "race condition", kdy obě vlákna přistupují a modifikují count současně. 
    Výsledná hodnota count by pak nebyla deterministická a mohl by se objevit výstup menší než 20 000.
    Výstup:

    Díky synchronizaci bude výstup vždy 20 000. Pokud by metody nebyly synchronizované, výstup by se mohl lišit s každým spuštěním programu 
    a pravděpodobně by byl menší než 20 000 kvůli "race condition".
 */

class SharedResource {
    private int count = 0;

    // Synchronizovaná metoda
    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

public class SynchronizedExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                resource.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                resource.increment();
            }
        });

        t1.start();
        t2.start();

        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        

        System.out.println(resource.getCount()); // Výstup bude vždy 20000
    }
}
