import java.util.Scanner;

public class Iter {

    int sum;
    int len;

    public Iter(int len) {
       this.len = len; 
       runIter(len);
    }

    private void runIter(int l) {
        int sum = 0;
        for (int i = 1; i <= l; i++) {
            sum += i;
        }
        this.sum = sum;
    }

    public void setLen() {
        System.out.println("How many numbers do you want to sum?");
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        this.len = length;
        in.close();
        runIter(length);
    }

    @Override
    public String toString() {
        return "Sum of first " + this.len + " numbers is " + this.sum + ".";
    }


    public static void main(String[] args) {

        Iter iterace = new Iter(2);
        System.out.println(iterace);

        iterace.setLen();
        System.out.println(iterace);
        
    }
    
}
