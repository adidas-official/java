/* 
    Představte si, že máme misku s ovocem. Producent přidává ovoce do misky, zatímco spotřebitel je odebírá a jí. 
    Miska má omezenou kapacitu. Pokud je miska plná, producent musí čekat, dokud spotřebitel nějaké ovoce neodebere. 
    Pokud je miska prázdná, spotřebitel musí čekat, dokud producent nějaké ovoce nepřidá.

    Máme omezenou kapacitu misky (CAPACITY).
    Producent přidává ovoce do misky a pokud je miska plná, čeká, dokud nějaké ovoce někdo neodebere (wait()).
    Spotřebitel odebírá ovoce z misky a pokud je miska prázdná, čeká, dokud někdo nějaké ovoce nepřidá (wait()).
    Když producent přidá nebo spotřebitel odebere ovoce, probudí druhé vlákno pomocí notify().


*/
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {

    /*
        CAPACITY: Konstantní hodnota určující maximální počet položek, které mohou být v mísce (bowl).
        bowl: Fronta reprezentující misku s ovocem. Používáme Queue (frontu) implementovanou pomocí LinkedList k uložení ovoce.
     */
    private static final int CAPACITY = 5;
    private final Queue<String> bowl = new LinkedList<>();
    

    /*
        synchronized (this): Zajišťuje, že v daném čase může do synchronizovaného bloku vstoupit pouze jedno vlákno.
        while (true): Neustále spouští cyklus produkce, dokud se aplikace neukončí.
        while (bowl.size() == CAPACITY) { wait(); }: Pokud je miska plná, producent čeká (čekání zahrnuje uvolnění zámku synchronizace, takže jiné vlákno může vstoupit).
        bowl.add(fruit): Přidání ovoce do misky.
        notify(): Probudí jedno z čekajících vláken (v našem případě spotřebitele, pokud čeká).
        Thread.sleep(500): Pauzuje vlákno po dobu 500 ms. Toto zpomaluje produkci ovoce, takže můžete sledovat interakci.
     */
    public void produce() throws InterruptedException {
        synchronized (this) {
            while (true) {
                if (bowl.size() < CAPACITY) {
                    String fruit = "Ovoce" + (bowl.size() + 1);
                    bowl.add(fruit);
                    System.out.println("Producent přidal: " + fruit);
                    notify(); // informuje spotřebitele, že může začít konzumovat
                } else {
                    wait();
                }
                Thread.sleep(500); // simulace prodlevy v produkci
            }
        }
    }

    /*
        while (bowl.isEmpty()) { wait(); }: Pokud je miska prázdná, spotřebitel čeká, dokud někdo nepřidá ovoce.
        bowl.poll(): Odebere ovoce z misky.
        Thread.sleep(1000): Pauzuje vlákno po dobu 1000 ms, což zpomaluje spotřebu ovoce.
     */
    public void consume() throws InterruptedException {
        synchronized (this) {
            while (true) {
                if (!bowl.isEmpty()) {
                    String fruit = bowl.poll();
                    System.out.println("Spotřebitel vzal: " + fruit);
                    notify(); // informuje producenta, že může začít produkovat
                } else {
                    wait();
                }
                Thread.sleep(1000); // simulace prodlevy ve spotřebě
            }
        }
    }
    
    public static void main(String[] args) {
        ProducerConsumerExample pc = new ProducerConsumerExample();

        Thread producerThread = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
