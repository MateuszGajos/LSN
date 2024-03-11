public class InvalidInputException extends RuntimeException{
    public InvalidInputException() {
        super("InvalidInputException");
    }
    public InvalidInputException(String message) {
        super(message);
    }
}
