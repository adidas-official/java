/*
  Jedním ze způsobů, jak se vyhnout deadlocku, je vždy požadovat zámky ve stejném pořadí.
 */

public class AvoidDeadlockExample {
    public static void main(String[] args) {
        Lock lock1 = new Lock();
        Lock lock2 = new Lock();

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock1...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (lock2) {
                    System.out.println("Thread 1: Acquired lock2!");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 2: Holding lock1...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (lock2) {
                    System.out.println("Thread 2: Acquired lock2!");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
