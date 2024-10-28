/*
    Kód vytvoří deadlock, protože t1 drží lock1 a čeká na lock2, zatímco t2 drží lock2 a čeká na lock1
 */

class Lock {
}

public class DeadlockExample {
    public static void main(String[] args) {
        Lock lock1 = new Lock();
        Lock lock2 = new Lock();

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock1...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                System.out.println("Thread 1: Waiting for lock2...");
                synchronized (lock2) {
                    System.out.println("Thread 1: Acquired lock2!");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock2...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                System.out.println("Thread 2: Waiting for lock1...");
                synchronized (lock1) {
                    System.out.println("Thread 2: Acquired lock1!");
                }
            }
        });

        t1.start();
        t2.start();
    }
}

