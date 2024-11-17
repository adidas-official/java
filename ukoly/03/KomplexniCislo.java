class KomplexniCislo {

    private double real;
    private double imaginary;

    public KomplexniCislo(double re, double im) {
        if (re == 0 && im == 0) {
            throw new IllegalArgumentException("Alespon jedna slozka komplexniho cisla musi byt nenulova");
        }
        this.real = re;
        this.imaginary = im;
    }

    public KomplexniCislo sumComplex(KomplexniCislo c) {
        KomplexniCislo c_out = new KomplexniCislo(this.real + c.real, this.imaginary + c.imaginary);
        return c_out;
    }

    public KomplexniCislo subtractComplex(KomplexniCislo c) {
        KomplexniCislo c_out = new KomplexniCislo(this.real - c.real, this.imaginary - c.imaginary);
        return c_out;
    }

    public KomplexniCislo addNumToComplex(double n) {
        KomplexniCislo c_out = new KomplexniCislo(this.real + n, this.imaginary);
        return c_out;
    }

    public KomplexniCislo subtractNumFromComplex(double n) {
        KomplexniCislo c_out = new KomplexniCislo(this.real - n, this.imaginary);
        return c_out;
    }

    public KomplexniCislo addImaginaryToComplex(double n) {
        KomplexniCislo c_out = new KomplexniCislo(this.real, this.imaginary + n);
        return c_out;
    }

    public KomplexniCislo subtractImaginaryFromComplex(double n) {
        KomplexniCislo c_out = new KomplexniCislo(this.real, this.imaginary - n);
        return c_out;
    }

    public KomplexniCislo multiplyComplexByN(double n) {
        KomplexniCislo c_out = new KomplexniCislo(this.real * n, this.imaginary * n);
        return c_out;
    }

    public KomplexniCislo divideComplexByN(double n) {
        try {
            if (n != 0) {
                this.real = this.real / n;
                this.imaginary = this.imaginary / n;
                KomplexniCislo c_out = new KomplexniCislo(this.real / n, this.imaginary / n);
                return c_out;
            } else {
                throw new IllegalArgumentException("Nelze delit nulou");
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } 
        return null;
    }

    public KomplexniCislo multiplyComplexNums(KomplexniCislo c) {
        double re = (this.real * c.real) - (this.imaginary * c.imaginary);
        double im = (this.real * c.imaginary) + (this.imaginary * c.real);
        KomplexniCislo c_out = new KomplexniCislo(re, im);
        return c_out;
    }

    public KomplexniCislo divideComplexNums(KomplexniCislo c) {

        double c_im_rev = c.imaginary * -1;

        double upper_dec_re = (this.real * c.real) - (this.imaginary * c_im_rev); 
        double upper_dec_im = (this.real * c_im_rev) + (this.imaginary * c.real); 
        double lower_deck = (c.real * c.real) - (c.imaginary * c_im_rev);

        KomplexniCislo c_out = new KomplexniCislo(upper_dec_re / lower_deck, upper_dec_im / lower_deck);
        return c_out;
    }

    public String toString() {
        if (this.imaginary < 0) {
            return this.real + " - " + (this.imaginary * -1) + "i";
        } else if (this.imaginary == 0) {
            return Double.toString(this.real);
        } else {
            return this.real + " + " + this.imaginary + "i";
        }
    }

    public static void main(String[] args) {

        // make 4 complex numbers with random values, positive and negative and test the methods
        KomplexniCislo c1 = new KomplexniCislo(3.5, -2.1);
        KomplexniCislo c2 = new KomplexniCislo(-1.2, 4.8);
        KomplexniCislo c3 = new KomplexniCislo(7.3, -5.4);
        KomplexniCislo c4 = new KomplexniCislo(-6.1, 3.9);

        // make 4 more complex numbers with random float values, positive and negative and test the methods
        KomplexniCislo c5 = new KomplexniCislo(2.7, -1.8);
        KomplexniCislo c6 = new KomplexniCislo(-4.5, 6.2);
        KomplexniCislo c7 = new KomplexniCislo(5.9, -3.3);
        KomplexniCislo c8 = new KomplexniCislo(-7.4, 2.6);

        // print all numbers
        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);
        System.out.println("c3: " + c3);
        System.out.println("c4: " + c4);
        System.out.println("c5: " + c5);
        System.out.println("c6: " + c6);
        System.out.println("c7: " + c7);
        System.out.println("c8: " + c8);

        // test the methods
        // define new complex numbers as the result of the methods
        KomplexniCislo c9 = c1.sumComplex(c2);
        KomplexniCislo c10 = c3.subtractComplex(c4);
        KomplexniCislo c11 = c5.addNumToComplex(3.4);
        KomplexniCislo c12 = c6.subtractNumFromComplex(2.1);
        KomplexniCislo c13 = c7.addImaginaryToComplex(1.2);
        KomplexniCislo c14 = c8.subtractImaginaryFromComplex(3.3);
        KomplexniCislo c15 = c9.multiplyComplexByN(2.3);
        KomplexniCislo c16 = c10.divideComplexByN(1.2);
        KomplexniCislo c17 = c11.multiplyComplexNums(c12);
        KomplexniCislo c18 = c13.divideComplexNums(c14);

        // print the results
        System.out.println("c1 + c2: " + c9);
        System.out.println("c3 - c4: " + c10);
        System.out.println("c5 + 3.4: " + c11);
        System.out.println("c6 - 2.1: " + c12);
        System.out.println("c7 + 1.2i: " + c13);
        System.out.println("c8 - 3.3i: " + c14);
        System.out.println("c1 * 2.3: " + c15);
        System.out.println("c3 / 1.2: " + c16);
        System.out.println("c5 * c6: " + c17);
        System.out.println("c7 / c8: " + c18);

    }

}