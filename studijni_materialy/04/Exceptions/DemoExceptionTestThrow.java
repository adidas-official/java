public class DemoExceptionTestThrow {

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

   public static void main(String[] args) {
 //     try {
         DemoExceptionTestThrow demo = new DemoExceptionTestThrow();
         int value = demo.parse(args);
         System.out.println("2nd argument: " + value);
   //   } catch (Exception e) {
     //    System.out.println("Error: " + e.getMessage());
    //  }
   }

}