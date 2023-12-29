public class InvalidAmountException extends RuntimeException {
    //Exception for values under or equals to 0 cuz most of the values will be entered will probably be greater than 0 like price quantity etc ...
    //also i used it for other exception not only for amounts purpose
    public InvalidAmountException(String message) {
        super(message);
    }
}