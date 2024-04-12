package VendingMachine;
public class ExceedQuantityException extends InvalidQuantityException{

    public ExceedQuantityException(String errorMessage, int value) {super(errorMessage, value);}

    @Override
    public String toString() {return ("\nYou can't buy more goods than are in stock!");}
}
