/*
 * CST8218 Assignment 2
 * Author: Lucas Estienne <esti0011@algonquinlive.com>
 * 2020W Term
 */
package cst8218.esti0011.util;

import java.util.HashMap;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 * Utility class for password hashing
 * @author lucas.estienne
 * @version 1.0
 * @since 1.0
 */
public class PasswordUtil {
    
    public static String hashPassword(String plaintext) {
        Instance<? extends PasswordHash> instance = CDI.current().select(Pbkdf2PasswordHash.class);
        PasswordHash passwordHash = instance.get();
        passwordHash.initialize(new HashMap<String,String>()); 
        
        return passwordHash.generate(plaintext.toCharArray());
    }
    
    
}
