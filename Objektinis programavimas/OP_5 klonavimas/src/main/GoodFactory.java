package main;
import VendingMachine.*;

import java.math.BigDecimal;

public class GoodFactory {

    public Good createGood(String goodType){

        if(goodType == null){
            return null;
        } else if(goodType.equals("Snack")){
            return new Snack("Snack's name",10, BigDecimal.valueOf(1.22), BigDecimal.valueOf(22.05),100, new VendingMachineShelf(1,"Lithuania"));
        } else if(goodType.equals("Drink")){
            return new Drink("Drink's name",10,BigDecimal.valueOf(1.22), BigDecimal.valueOf(22.05),15, new VendingMachineShelf(2, "USA"));
        }

        throw new IllegalArgumentException("Unknown good type " + goodType);
    }
}
