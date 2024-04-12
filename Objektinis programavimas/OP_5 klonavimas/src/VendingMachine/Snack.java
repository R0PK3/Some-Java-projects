package VendingMachine;

import java.math.BigDecimal;

public class Snack extends Good{

    private double calories;

    public Snack(String name, int quantity, BigDecimal cost, BigDecimal expirationDate, double calories,VendingMachineShelf shelf){
        super(name, quantity, cost, expirationDate, shelf);
        this.calories = calories;
    }

    //additional method
    public void setCalories(double calories) {this.calories = calories;}

    //additional method
    public double getCalories() {return calories;}

    @Override
    public void refund (RefundYesNo choice)
    {
        if(choice == RefundYesNo.YES)
        {
            profit = profit.subtract(cost.multiply(BigDecimal.valueOf(0.25)));
        }
    }

    @Override
    public String toString() {
        return  super.toString() + "\nCalories: " + calories + "Kcal";
    }

    public void isExpired(BigDecimal expirationDate) {
        if(expirationDate.compareTo(BigDecimal.valueOf(22.05)) < 0){
            System.out.println("The good is expired!");
            setQuantity(0);
        }
    }

}
