import java.util.Queue;
import java.util.LinkedList;

class ProducerConsumerExample2 {
    private static final int CAPACITY = 5;
    private final Queue<String> bowl = new LinkedList<>();

    public void produce() throws InterruptedException {
        int count = 0; 
        while (true) {
            synchronized (this) {
                while (bowl.size() == CAPACITY) {
                    wait(); // čekání, pokud je miska plná
                }
                String fruit = "Ovoce" + (++count);
                bowl.add(fruit);
                System.out.println("Producent přidal: " + fruit);
                notify(); // probuzení spotřebitele
                Thread.sleep(500); // prodleva
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (bowl.isEmpty()) {
                    wait(); // čekání, pokud je miska prázdná
                }
                String fruit = bowl.poll();
                System.out.println("Spotřebitel vzal: " + fruit);
                notify(); // probuzení producenta
                Thread.sleep(500); // prodleva
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumerExample2 pc = new ProducerConsumerExample2();

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
