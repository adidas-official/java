import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Jmeno {

    private String fname;
    private String lname;

    @Override
    public String toString() {
        return this.fname + " " + this.lname;
    } 

    public Jmeno(String name) {

        this.fname = name.split(" ")[0];
        this.lname = name.split(" ")[1];
    }

}

class Lidi {

    private List<Jmeno> seznamLidi = new ArrayList<>();

    public void addPerson(Jmeno clovek) {
        this.seznamLidi.add(clovek);
    }

    public void removePerson(int idx) {
        this.seznamLidi.remove(idx);
    }

    public void printPeople() {
        for (Jmeno clovek: this.seznamLidi) {
            System.out.println(clovek);
        } 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Zadejte jmeno a prijmeni osoby");
        Jmeno person1 = new Jmeno(scanner.nextLine());
        System.out.println("Zadejte jmeno a prijmeni osoby");
        Jmeno person2 = new Jmeno(scanner.nextLine());

        // Inicializace, jen 2 lidi
        Lidi adresar = new Lidi();
        adresar.addPerson(person1);
        adresar.addPerson(person2);
        adresar.printPeople();

        adresar.removePerson(1);
        System.out.println("V adresari jsou tyto kontakty");
        adresar.printPeople(); 

        System.out.println("Zadejte jmeno a prijmeni osoby");
        Jmeno person3 = new Jmeno(scanner.nextLine());
        adresar.addPerson(person3);

        System.out.println("V adresari jsou tyto kontakty");
        adresar.printPeople();

        scanner.close();

    }

}


