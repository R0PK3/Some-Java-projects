package VendingMachine;

import java.math.BigDecimal;

public interface Expirable {

    void isExpired(BigDecimal expirationDate);

    BigDecimal getExpirationDate();
}

