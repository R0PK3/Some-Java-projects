package VendingMachine;
import java.math.BigDecimal;

public abstract class Good implements ExpirationDateChangeable, Cloneable{

    private final String name;
    private int quantity;

    BigDecimal cost;
    BigDecimal expirationDate;
    static BigDecimal profit = BigDecimal.valueOf(0);

    private VendingMachineShelf shelf;


    //constructor with arguments
    public Good(String name, int quantity, BigDecimal cost, BigDecimal expirationDate, VendingMachineShelf shelf){
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
        this.expirationDate = expirationDate;
        this.shelf = shelf;
    }

    //constructor without arguments
    public Good(){ this("Vytautas",6,BigDecimal.valueOf(1.23), BigDecimal.valueOf(22.06), new VendingMachineShelf(1,"Origin"));}

    //setters
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public void setExpirationDate(BigDecimal expirationDate) {this.expirationDate = expirationDate;}
    public void setShelf(VendingMachineShelf shelf) {this.shelf = shelf;}
    //getters
    public String getName() {return name;}
    public int getQuantity() {return quantity;}
    public BigDecimal getPrice() {return cost;}
    public BigDecimal getProfit() {return profit;}
    public BigDecimal getExpirationDate() {return expirationDate;}
    public VendingMachineShelf getShelf() {return shelf;}

    /*overloaded methods
    public void buyGood(){
        if(quantity != 0)
        {
            this.setQuantity(quantity - 1);
            profit = profit.add(cost);

        }
    }
    */

    public void buyGood(String buyQuantity) throws InvalidQuantityException{

        boolean isNumeric = testNumeric(buyQuantity);

        if(!isNumeric){

            throw new InvalidQuantityException("Input is not an integer.", 0);
        }

        int buyingQuantity = Integer.parseInt(buyQuantity);

        if(quantity - buyingQuantity < 0){
            throw new ExceedQuantityException("Not enough Goods in stock! You can't buy more than: ",quantity);
        } else {
            this.setQuantity(quantity - buyingQuantity);
            profit = profit.add(cost.multiply(BigDecimal.valueOf(buyingQuantity)));
        }
    }

    public boolean testNumeric(String buyQuantity){

        try {
            int i = Integer.parseInt(buyQuantity);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public void refund (RefundYesNo choice)
    {
        if(choice == RefundYesNo.YES)
        {
            profit = profit.subtract(cost);
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException{

        Good cloned = (Good) super.clone();

        if(this.shelf != null)
        {
            //cloned.setShelf((VendingMachineShelf) cloned.getShelf().clone());
        }

        return cloned;
    }



    /*
        //println method
        public void println(String name, int quantity, BigDecimal cost, boolean isAvailable){
            System.out.println("Good's name:" + name + "\nGood's quantity: " + quantity + "\nGood's price: " + cost + "€\nGood's availability: " + isAvailable);
        }
    */




    @Override
    public String toString(){
        return "\nGood's name:" + name + "\nGoods quantity: " + quantity + "\nGood's price: " + cost + " Eur\nGood's expiration date: " + expirationDate;
    }

}
