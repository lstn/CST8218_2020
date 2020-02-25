/*
 * CST8218 Assignment 1
 * Author: Lucas Estienne <esti0011@algonquinlive.com>
 * 2020W Term
 */
package cst8218.esti0011.util;


import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Custom validator for our JSF Color inputs.
 * Validates that input strings match the regex for HEX color codes, minus the pound sign (#).
 * @author lucas.estienne
 * @version 1.0
 * @since 1.0
 * @see java.awt.Color
 */
@FacesValidator("cst8218.esti0011.util.ColorValidator")
public class ColorValidator implements Validator {
    
    private static final String HEX_COLORCODE_PATTERN = "^[A-Fa-f0-9]{6}|[A-Fa-f0-9]{3}$";
    
    private Pattern pattern;
    private Matcher matcher;
    
    public ColorValidator(){
        pattern = Pattern.compile(HEX_COLORCODE_PATTERN);
    }
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Color color = (Color) value;
        String hs = Integer.toHexString(color.getRGB()).substring(2);
        matcher = pattern.matcher(hs);
        if(!matcher.matches()){
            FacesMessage msg = new FacesMessage("Color validation failed.", "Must be a valid Hex color code (pound sign ommitted, i.e. 'FFFFFF').");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }
}
