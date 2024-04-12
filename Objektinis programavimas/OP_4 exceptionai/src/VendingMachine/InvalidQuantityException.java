package VendingMachine;
public class InvalidQuantityException extends Exception{

    private int value;

    public InvalidQuantityException(String errorMessage, int value)
    {
        super(errorMessage);

        this.value = value;
    }

    public int getValue() {return value;}
}
