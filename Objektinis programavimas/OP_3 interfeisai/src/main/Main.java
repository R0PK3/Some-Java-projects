package main;
import VendingMachine.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String [] args){

        //TESTING INTERFACE
        //Good good; //bazinio tipo nuoroda

        ExpirationDateChangeable good = new Drink("Birute",4,BigDecimal.valueOf(0.79),BigDecimal.valueOf(22.06),16);
        good.getExpirationDate();
        System.out.print("Good's type: " + good.getClass().getName() + good);








        /*TESTING POLYMORPHISM




        good = new Drink("Rasa",6, BigDecimal.valueOf(2.09),BigDecimal.valueOf(23.03),16);
        good.refund(RefundYesNo.YES); //uzklotu metodu iskvietimas
        System.out.println("Good's type: " + good.getClass().getName() + good);
        good.buyGood();
        System.out.println("Would you like to increase or decrease your drink temperature?");
        ((Drink) good).changeTemperature(IncreaseDecrease.INCREASE,5);
        System.out.println("Good! Now your drink's temperature is: " + ((Drink) good).getTemperature());
        System.out.println("-------------------------------------------");


        good = new Snack("Snickers",4,BigDecimal.valueOf(1.29),BigDecimal.valueOf(22.11),485.00);
        good.refund(RefundYesNo.NO);
        System.out.println("Good's type:" + good.getClass().getName() + good);
        good.buyGood();
        System.out.println("-------------------------------------------");

        System.out.println("Overall profit is: " + good.getProfit());

        */
    }
}
