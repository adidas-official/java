public class Kruh {

    private double polomer;
    private final double PI = 3.14159;

    public void setPolomer(double polomer) {
        if (polomer > 0) {
            this.polomer = polomer;
        } else {
            System.err.println("Polomer musi byt nezaporne cislo");
        };
    }

    public double vypocet_obvodu() {
        return Math.round(2* this.PI * this.polomer * 100) / 100.0;
    }

    public double vypocet_obsahu() {
        return Math.round(this.PI * this.polomer * this.polomer * 100) / 100.0;
    } 

    public Kruh (double polomer) {
        this.setPolomer(polomer);
    }

    public String toString() {
        return "Kruh o polomeru " + this.polomer + " ma obvod " + this.vypocet_obvodu() + " jednotek a obsah " + this.vypocet_obsahu() + " jednotek.";
    }

    public static void main(String[] args) {

        Kruh k1 = new Kruh(19.8);
        System.out.println(k1);
        
    }
}