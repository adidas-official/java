/*
 * Kompilace: javac GreetUser.java
 * Spuštění s argumentem: java GreetUser [YourName] 
 */
public class GreetUser {
    public static void main(String[] args) {
        // Zkontrolujeme, zda byl poskytnut alespoň jeden argument
    
        if (args.length > 0) {
            System.out.println("Hello, " + args[0] + "!");
        } 
        else {
            System.out.println("Usage: java GreetUser [name]");
        }
    }
}

