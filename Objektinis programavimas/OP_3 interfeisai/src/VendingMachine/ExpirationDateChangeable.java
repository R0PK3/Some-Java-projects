package VendingMachine;


import java.math.BigDecimal;

public interface ExpirationDateChangeable extends Expirable{

    void setExpirationDate(BigDecimal expirationDate);

    BigDecimal getExpirationDate();
}
