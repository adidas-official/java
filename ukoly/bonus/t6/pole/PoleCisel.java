public class PoleCisel {


    public static void main(String[] args) {

        int[] poleCisel = {5, 2, 3, 4, 5, 9, 11, 2, 0, 6};

        int max = 0;
        int min = 99;
        for (int i = 0; i < poleCisel.length; i++) {
            if (poleCisel[i] > max) {max = poleCisel[i]; }
            if (poleCisel[i] < min) {min = poleCisel[i]; }
        } 

        System.out.println("Min: " + min + " Max: " + max);
    }
    
}
