/*
    Hlavní Body:
        Třídy a Objekty: Definice a vytvoření třídy a jak vytvářet objekty z třídy.
        Atributy: Použití atributů pro uložení stavu objektu.
        Metody: Vytvoření a použití metod pro manipulaci s objektem.
        Encapsulation: Užití privátních atributů a veřejných metod k ochraně dat.
    
    Analýza Kódu:
        Definice Třídy: BankAccount třída obsahuje atributy a metody pro manipulaci s účtem.
        Konstruktor: Inicializuje objekt na základě vstupních parametrů.
        Metody: deposit a withdraw umožňují manipulaci s atributem balance a poskytují jednoduché ovládání a validaci.
        Vytvoření Objektu: myAccount je vytvořen a metody jsou použity k demonstraci práce s objektem.
    
    Mini Cvičení:
        Přidání Dalších Atributů: Přidejte jméno vlastníka účtu jako atribut a upravte konstruktor a výstupové zprávy.
        Přidání Dalších Metod: Přidejte metodu transfer, která umožní převod peněz mezi dvěma účty.
        Přidání Úrokové Sazby: Vytvořte metodu, která aktualizuje zůstatek účtu na základě úrokové sazby.
 */
class BankAccount {
    // Atributy
    private String accountNumber;
    private double balance;

    // Konstruktor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Metody
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ", Remaining balance: " + balance);
        } else {
            System.out.println("Invalid withdraw amount.");
        }
    }

    // Getter pro balance
    public double getBalance() {
        return balance;
    }

    // Getter pro accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }
}

public class BankApp {
    public static void main(String[] args) {
        // Vytvoření objektu
        BankAccount myAccount = new BankAccount("12345", 1000.00);

        // Použití metod objektu
        myAccount.deposit(500);
        myAccount.withdraw(200);
        System.out.println("Final balance of account " + myAccount.getAccountNumber() + ": " + myAccount.getBalance());
    }
}
