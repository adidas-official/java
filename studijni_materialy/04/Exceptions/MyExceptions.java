
public class MyExceptions {

    class MyRuntimeException extends RuntimeException {

        public MyRuntimeException(String str) {
            super(str);
        }
    }

    class MyException extends Exception {

        public MyException(String str) {
            super(str);
        }
    }

    void demo1() {
        throw new MyRuntimeException("Demo MyRuntimeException");
    }

    void demo2() throws MyException {
        throw new MyException("Demo MyException");

    }

    public static void main(String[] args) {

        MyExceptions demo = new MyExceptions();
        try {
            if (args.length > 0) {
                demo.demo1();
            } else {
                demo.demo2();
            }
        } catch (MyRuntimeException e) {
            System.out.println("MyRuntimeException:" + e.getMessage());
        } catch (MyException e) {
            System.out.println("MyException:" + e.getMessage());
        }
    }
}
