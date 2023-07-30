package com.icin.Config;

import java.io.Serializable;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import com.icin.Entity.User;

public class CustomAccountNumberGenerator extends IdentityGenerator {

    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        // Assuming obj is of type User and has the accountNo property
        User user = (User) obj;
        String prefix = "9395";

        // Generate the next account number (numeric part)
        Long lastNumericPart = getLastNumericPart(session);
        Long nextNumericPart = lastNumericPart + 1;

        // Combine the prefix and numeric part to form the final account number
        String accountNumber = prefix + nextNumericPart;
        
        return accountNumber;
    }

    private Long getLastNumericPart(SharedSessionContractImplementor session) {
        // Query the database to get the last account number
        Long lastNumericPart = (Long) session.createQuery("SELECT MAX(CAST(SUBSTRING(u.accountNo, 5) AS long)) FROM User u")
                                            .uniqueResult();
        return lastNumericPart != null ? lastNumericPart : 0;
    }
}
