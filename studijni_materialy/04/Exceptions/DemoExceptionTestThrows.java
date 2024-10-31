public class DemoExceptionTestThrows {

   public int parse(String[] args) {
      try {
	 if (args != null && args.length > 1) {
	    return Integer.parseInt(args[1]);
	 } else {
	    throw new RuntimeException("Input argument not set");
	 }
      } catch (NumberFormatException e) {
	 throw new NumberFormatException("2nd input argument must be integer");
      }
   }

   public static void main(String[] args) {
      DemoExceptionTestThrows demo = new DemoExceptionTestThrows();
      int value = demo.parse(args);
      System.out.println("2nd argument: " + value);
   }

}
