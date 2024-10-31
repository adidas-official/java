public class DemoExceptionTestThrowMain {

   public int parse(String[] args) throws Exception {
      try {
         if (args != null && args.length > 1) {
            return Integer.parseInt(args[1]);
         } else {
            throw new Exception("Input argument not set");
         }
      } catch (NumberFormatException e) {
         throw new Exception("2nd input argument must be integer");
      }
   }

   public static void main(String[] args) throws Exception {
         DemoExceptionTestThrowMain demo = new DemoExceptionTestThrowMain();
         int value = demo.parse(args);
         System.out.println("2nd argument: " + value);
   }

}
