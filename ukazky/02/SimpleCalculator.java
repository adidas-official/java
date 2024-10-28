/*
    Tato aplikace demonstuje použití:
        Datových typů: double, char.
        Vstupu a výstupu dat: Použití Scanner pro čtení vstupu od uživatele a System.out.println pro výstup.
        Operátorů: +, -, *, / v případech v switch statement.
        Podmínek: switch a if ke kontrole operátoru a dělení nulou.
        Cyklu: I když tato vzorová aplikace přímo nepoužívá cyklus, můžete přidat while loop, 
        aby se uživatel mohl rozhodnout opakovat výpočty bez opětovného spuštění programu.

    Hlavní body, které je třeba zdůraznit:
        Čtení vstupu od uživatele: scanner.nextDouble() a scanner.next().charAt(0).
        Chybové podmínky: Kontrola dělení nulou a neplatného operátoru.
        Výpočetní logika: Použití matematických operátorů k provedení požadované operace.
        Výstup na konzoli: System.out.println k vypsání výsledků a jiných zpráv uživateli.
 */

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Výzva uživateli k zadání prvního čísla
        System.out.println("Enter first number:");
        double num1 = scanner.nextDouble();

        // Výzva uživateli k zadání druhého čísla
        System.out.println("Enter second number:");
        double num2 = scanner.nextDouble();

        // Výzva uživateli k zadání operátoru
        System.out.println("Enter operator (+, -, *, /):");
        char operator = scanner.next().charAt(0);

        scanner.close();
        // Výpočet výsledku
        double result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Cannot divide by zero.");
                    return; // ukončíme metodu main
                }
                break;
            default:
                System.out.println("Invalid operator.");
                return; // ukončíme metodu main
        }

        // Výpis výsledku
        System.out.println("Result: " + result);
    }
}
