class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class DemoEx {
    public static void main(String[] args) {
        try {
            throw new CustomException("Custom error occured");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}
