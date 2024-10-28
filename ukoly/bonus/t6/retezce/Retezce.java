public class Retezce {


    public static String reverseString(String s) {
        String revS = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            revS = ch + revS;
        }

        return revS;
    }

    public static void main(String[] args) {
        String s = "jelenovi pivo nelej";
        System.out.println(Retezce.reverseString(s));
    }
    
}
