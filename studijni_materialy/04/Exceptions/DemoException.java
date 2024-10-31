public class DemoException {

    public int parse(String[] args) {
        return Integer.parseInt(args[1]);
    }
    
    public static void main(String[] args) {
        DemoException demo = new DemoException();
        int value = demo.parse(args.length == 0 ? null : args);
	System.out.println("2nd argument: " + value);
    }

}
