package VendingMachine;
import java.math.BigDecimal;
import java.util.Objects;

public abstract class Good implements ExpirationDateChangeable{

    private final String name;
    private int quantity;

    BigDecimal cost;
    BigDecimal expirationDate;
    static BigDecimal profit = BigDecimal.valueOf(0);


    //constructor with arguments
    public Good(String name, int quantity, BigDecimal cost, BigDecimal expirationDate){
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
        this.expirationDate = expirationDate;
    }

    //constructor without arguments
    public Good(){ this("Vytautas",6,BigDecimal.valueOf(1.23), BigDecimal.valueOf(22.06));}

    //setters
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public void setExpirationDate(BigDecimal expirationDate) {this.expirationDate = expirationDate;}

    //getters
    public String getName() {return name;}
    public int getQuantity() {return quantity;}
    public BigDecimal getPrice() {return cost;}
    public BigDecimal getProfit() {return profit;}
    public BigDecimal getExpirationDate() {return expirationDate;}

    //overloaded methods
    public final void buyGood(){
        if(quantity != 0)
        {
            this.setQuantity(quantity - 1);
            profit = profit.add(cost);

        }
    }

    public final void buyGood(int buyQuantity){
        if(quantity != 0)
        {
             this.setQuantity(quantity - buyQuantity);

             profit = profit.add(cost.multiply(BigDecimal.valueOf(buyQuantity)));

        }
    }

    public void refund (RefundYesNo choice)
    {
        if(choice == RefundYesNo.YES)
        {
            profit = profit.subtract(cost);
        }
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
