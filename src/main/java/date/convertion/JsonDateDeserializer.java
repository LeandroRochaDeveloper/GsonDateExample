/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date.convertion;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Leandro
 */
public class JsonDateDeserializer implements JsonDeserializer<Date>, JsonSerializer<Date> {

    @Override
    public Date deserialize(JsonElement je, java.lang.reflect.Type type,
            JsonDeserializationContext jdc) throws JsonParseException {
        // TODO Auto-generated method stub
        SimpleDateFormat forte = new SimpleDateFormat(
                "MMM dd, yyyy HH:mm:SS", Locale.ENGLISH);
        // O 'Locale.ENGLISH' evita que dê problemas na conversão em outros computadores.        
        try {
            Date icone = forte.parse(je.getAsString());
            return icone;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            return null;
        }
    }

    @Override
    public JsonElement serialize(java.util.Date src, java.lang.reflect.Type typeOfSrc,
            JsonSerializationContext context) {
        // TODO Auto-generated method stub
        SimpleDateFormat forte = new SimpleDateFormat(
                "MMM dd, yyyy HH:mm:SS", Locale.ENGLISH);

        System.out.println(forte.format(src));
        return src == null ? null : new JsonPrimitive(""
                + forte.format(src) + "");
    }
}
