/*
 * CST8218 Assignment 1
 * Author: Lucas Estienne <esti0011@algonquinlive.com>
 * 2020W Term
 */
package cst8218.esti0011.util;

import java.awt.Color;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author lucas.estienne
 */
@FacesConverter("cst8218.esti0011.util.ColorConverter")
public class ColorConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return Color.decode("#"+value);
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Color color = (Color) value;
        return Integer.toHexString(color.getRGB()).substring(2);
    }
}
