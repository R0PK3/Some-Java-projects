package VendingMachine;
import java.math.BigDecimal;

public class Drink extends Good{

    private int temperature; //additional field


    public Drink(String name, int quantity, BigDecimal cost, BigDecimal expirationDate, int temperature, VendingMachineShelf shelf){

        super(name,quantity,cost,expirationDate,shelf); //super() constructor
        this.temperature = temperature;
    }

    //additional method
    public void setTemperature(int temperature) {this.temperature = temperature;}

    //additional method
    public int getTemperature() {return temperature;}

    //additional method

    public void changeTemperature(IncreaseDecrease choice, int difference){

        if(choice == IncreaseDecrease.INCREASE)
        {
            this.temperature = temperature + difference;
        }
        if(choice == IncreaseDecrease.DECREASE)
        {
            this.temperature = temperature - difference;
        }
    }


    @Override
    public void refund (RefundYesNo choice)
    {
        if(choice == RefundYesNo.YES)
        {
            profit = profit.subtract(cost.multiply(BigDecimal.valueOf(0.5)));
        }
    }

    @Override
    public String toString() {return super.toString() + "\nGood's temperature: " + temperature;}


    public void isExpired(BigDecimal expirationDate) {
        if(expirationDate.compareTo(BigDecimal.valueOf(22.05)) < 0){
            System.out.println("The good is expired!");
            setQuantity(0);
        }
    }


}
