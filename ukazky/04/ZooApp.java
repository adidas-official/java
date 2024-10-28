/*
    Hlavní Body:
        Rozhraní: Použití rozhraní (SoundMaker) pro definování metody, kterou musí implementovat všechny třídy, které implementují toto rozhraní.
        Dědičnost: Lion a Parrot dědí od Animal a rozšiřují jeho funkčnost.
        Polymorfismus: Umožňuje objektům být ošetřovány jako jejich supertyp.

    Analýza Kódu:
        Rozhraní SoundMaker: Definuje metodu makeSound, kterou musí implementovat všechny třídy, které implementují toto rozhraní.
        Třída Animal: Základní třída, která má jméno a může být rozšířena dalšími třídami.
        Třídy Lion a Parrot: Jsou potomky třídy Animal a implementují rozhraní SoundMaker.
        Polymorfická Metoda makeAnimalSound: Přijímá objekt, který implementuje SoundMaker a volá jeho metodu makeSound.

    Mini Cvičení:
        Přidání Nových Tříd Zvířat: Vytvořte nové třídy zvířat, které dědí od Animal a implementují SoundMaker (např. Dog, Cat).
        Přidání Nových Metod: Přidejte novou metodu do rozhraní (např. move) a implementujte ji ve všech třídách zvířat.
        Vytvoření Listu Zvířat: Vytvořte seznam SoundMaker objektů a použijte smyčku k vyvolání makeSound pro každý objekt v seznamu.
 */
interface SoundMaker {
    void makeSound();
}

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Animal: " + name;
    }
    

}

class Lion extends Animal implements SoundMaker {
    public Lion(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " roars!");
    }
}

class Parrot extends Animal implements SoundMaker {
    public Parrot(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " squawks!");
    }
}

public class ZooApp {
    public static void main(String[] args) {
        SoundMaker lion = new Lion("Leo");
        SoundMaker parrot = new Parrot("Polly");

        makeAnimalSound(lion);
        makeAnimalSound(parrot);
    }

    private static void makeAnimalSound(SoundMaker animal) {
        animal.makeSound();
    }
}
