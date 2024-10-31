
public class BlockFinally {
    
    class MyException extends Exception {
        MyException(String str) {
            super(str);
        }
    }

    void causeRuntimeException() {
        throw new RuntimeException("RuntimeException");
    }

    void causeException() throws MyException {
        throw new MyException("Exception");
    }

    void start(int v) {
        try {
            if (v == 0) {
                System.out.println("v:0 call runtime");
                causeRuntimeException();
            } else if (v == 1) {
                System.out.println("v:1 call exception");
                causeException();
            } else if (v == 2) {
                System.out.println("v:2 call return");
                return;
            }
        } catch (MyException e) {
            System.out.println("start handle Exception");
        } finally {
            System.out.println("Leave start!");
        }

    }

    public static void main(String[] args) {
        BlockFinally demo = new BlockFinally();
        demo.start(args.length > 0 ? Integer.parseInt(args[0]) : 1);
    }

}
