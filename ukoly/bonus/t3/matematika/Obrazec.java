import java.lang.Math;

public class Obrazec {

    protected double a;
    protected double b;

    protected double obsah;
    protected double obvod;

    public String typ;

    public String toString() {
        return "[" + this.typ + "] obsah = " + this.obsah + ", obvod = " + this.obvod;
    }

    public static void main(String[] args) {
        dvojrozmernyTvar ctv1 = new Ctverec(4.5);
        System.out.println(ctv1);

        dvojrozmernyTvar obd1 = new Obdelnik(4.5, 5.1);
        System.out.println(obd1);

        dvojrozmernyTvar troj1 = new Trojuhelnik(8.1, 3.6, 5.3);
        System.out.println(troj1);

        dvojrozmernyTvar kruh1 = new Kruh(2.91);
        System.out.println(kruh1);
    }

}

class Ctverec extends Obrazec implements dvojrozmernyTvar{

    public void obsah() {
        this.obsah = Math.pow(a, 2);
    }

    public void obvod() {
        this.obvod = 4*a;
    }

    public Ctverec(double a) {
        this.a = a;
        this.b = a;
        this.typ = "ctverec";

        this.obsah();
        this.obvod();
    }
}

class Obdelnik extends Obrazec implements dvojrozmernyTvar{
    public void obsah() {
        this.obsah = this.a * this.b;
    }

    public void obvod() {
        this.obvod = this.a * 2 + this.b * 2;
    }

    public Obdelnik(double a, double b) {
        this.a = a;
        this.b = b;
        this.typ = "obdelnik";

        this.obsah();
        this.obvod();
    }
}

class Trojuhelnik extends Obrazec implements dvojrozmernyTvar{

    private double c;

    public void obsah() {

        this.obsah = this.a * this.b / 2;

    }

    public void obvod() {

        this.obvod = this.a + this.b + this.c;

    }

    public Trojuhelnik(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.typ = "trojuhelnik";

        this.obsah();
        this.obvod();
    }
}

class Kruh extends Obrazec implements dvojrozmernyTvar{
    final static double PI = 3.14159;

    public void obsah() {
        this.obsah = PI * Math.pow(this.a, 2);
    }

    public void obvod() {
        this.obvod = 2 * PI * this.a;
    }

    public Kruh(double r) {
        this.a = r;
        this.typ = "kruh";

        this.obsah();
        this.obvod();
    }
}
