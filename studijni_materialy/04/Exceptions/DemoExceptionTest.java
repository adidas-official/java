public class DemoExceptionTest {

   public int parse(String[] args) {
      if (args != null && args.length > 1) {
	 return Integer.parseInt(args[1]);
      } else {
	 throw new RuntimeException("Input argument not set");
      }
   }

   public static void main(String[] args) {
      try {
	 DemoExceptionTest demo = new DemoExceptionTest();
	 int value = demo.parse(args);
	 System.out.println("2nd argument: " + value);
      } catch (Exception e) {
	 System.out.println("Error: " + e.getMessage());
      }
   }

}
