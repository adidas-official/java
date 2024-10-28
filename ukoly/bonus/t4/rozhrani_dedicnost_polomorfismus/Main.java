public class Main {
    
    public static void main(String[] args) {

        // Instance tridy OsobniAutomobil typu DopravniProstredek
        DopravniProstredek Audi = new OsobniAutomobil("Tomas", "Audi");

        // Instance pomoci rozhrani pohyb
        Pohyb BMW = new Automobil("Martina", 4, "BMW");
        Pohyb Cesna = new Letadlo();
        Pohyb Titanic = new Lod();
        System.out.println("Toto je " + BMW.getNazev());

        // Instance tridy Automobil
        Automobil Tatra = new NakladniAutomobil("Lorenc", 22, "Tatra");
        Automobil MAN = new NakladniAutomobil("Dan", 25, "MAN");

        System.out.println(Cesna);
        System.out.println(Titanic);
        System.out.println(Audi);
        System.out.println(BMW);
        System.out.println(Tatra);
        System.out.println(MAN);

        if (Titanic.letet()) {
            System.out.println("Titanic dokaze letat");
        } else {
            System.out.println("Titanik nedokaze letat");
        }

    }

}