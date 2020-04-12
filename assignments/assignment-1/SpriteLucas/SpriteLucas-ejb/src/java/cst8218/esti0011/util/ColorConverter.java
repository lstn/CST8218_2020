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
 * Custom converter for our JSF Color inputs.
 * Converts string hexadecimal color representations to and from {@link java.awt.Color} objects.
 * @author lucas.estienne
 * @version 1.0
 * @since 1.0
 * @see java.awt.Color
 */
@FacesConverter("cst8218.esti0011.util.ColorConverter")
public class ColorConverter implements Converter {
    /** Convert the specified string value into a Color object.
     * @param context FacesContext for the request being processed
     * @param component UIComponent with which this model object value is associated
     * @param value String value to be converted
     * @return an Object containing the result of the conversion
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return Color.decode("#"+value);
    }
    /** Convert the specified Color object into a String.
     * @param context FacesContext for the request being processed
     * @param component UIComponent with which this model object value is associated
     * @param value Model object value to be converted 
     * @return a String containing the result of the conversion
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Color color = (Color) value;
        return Integer.toHexString(color.getRGB()).substring(2);
    }
}
