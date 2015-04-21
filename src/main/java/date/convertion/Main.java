/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date.convertion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Leandro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Gson
        Gson gson;
        GsonBuilder bu = new GsonBuilder()
                .setDateFormat("MMM dd, yyyy HH:mm:SS")
                .registerTypeAdapter(Date.class, new JsonDateDeserializer());
        gson = bu.create();
     
        // Serialize and Deserialize object
        Something thing = new Something();
        String json = gson.toJson(thing);
        System.out.println(json);
        Something otherThing = gson.fromJson(json, Something.class);
        System.out.println("ID: " + otherThing.getId() + ", Date: " + otherThing.getDate().toString());
        // Other examples
        // List of objects to json String
        List<Something> list = new ArrayList<>();
        list.add(new Something());
        list.add(new Something());
        String jsonList = gson.toJson(list);
        System.out.println(jsonList);
        // Json String to list of objects
        java.lang.reflect.Type listType = new TypeToken<ArrayList<Something>>() {}.getType();
        List<Something> anotherList = gson.fromJson(jsonList, listType);
        for(Something whatever : anotherList) {
            System.out.println("ID: " + whatever.getId() + ", Date: " + whatever.getDate().toString());
        }
    }    
}
