/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.asignacion18_00000233047;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.Arrays;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author David Alejandro tirado Luna 00000233047
 */
public class Asignacion18_00000233047 {

    public static void main(String[] args) {
        
         
        MongoClient cliente = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = cliente.getDatabase("restaurantesDB");
        MongoCollection<Document> col = db.getCollection("restaurantes");
        
       
        // 1.-
        Document document = new Document();
        document.append("name", "Cafe de la plaza");
        document.append("stars", 4.3);
        document.append("categories", Arrays.asList(new String[]{"Cafe", "Postres", "Desayunos"}));        
        col.insertOne(document);
           
         // 2.-
        ArrayList<Document> lista = new ArrayList<>();
       
         lista.add(new Document ("name", "Espresso Express")
                .append("stars", 4.8)
                .append("categories", 
                 Arrays.asList(new String[]{"Cafe", "Rápido", "Takeaway"})));
        
         lista.add(new Document ("name", "The Tea House")
                .append("stars", 3.9)
                .append("categories", 
                 Arrays.asList(new String[]{"Te", "Infusiones", "Postres"})));        
    
         lista.add(new Document ("name", "Morning Brew")
                .append("stars", 4.0)
                .append("categories", 
                 Arrays.asList(new String[]{"Cafe", "Desayuno", "Bakery"})));     
          col.insertMany(lista);
        
      
         // 3.-
         
        System.out.println("Restaurantes con 4.5 o mas Estrellas");   
               for (Document d : col.find(Filters.gte("stars", 4.5))) {
            System.out.println(d.toJson());            
        }
 
        System.out.println("Restaurantes que en su nombre contienen 'Cafe'");
        for (Document d : col.find(Filters.regex("name", "Cafe"))) {
            System.out.println(d.toJson());
        }
        
                System.out.println("Restaurantes que en sus categories contienen 'Postres'");
        for (Document d : col.find(Filters.eq("categories", "Postres"))) {
            System.out.println(d.toJson());
        }
        
        System.out.println("Restaurantes que tienen entre 3 Y 4.3 Estrellas");

        Bson filtro = Filters.and(Filters.gte("stars", 3), Filters.lte("stars", 4.5));
        for (Document d : col.find(filtro)) {
            System.out.println(d.toJson());
        }
        
                System.out.println("Restaurantes que su nombre inicia con la letra T");
        for (Document d: col.find(Filters.regex("name", "^T"))) {
             System.out.println(d.toJson());
        }
        
        
        // 4.-
        
        col.updateOne( Filters.eq("name", "Morning Brew"),Updates.set("stars", 4.5));

        col.updateMany(
                Filters.or(Filters.eq("categories", "Bakery"), Filters.eq("categories", "Desayuno")),
                Updates.inc("stars", 0.2)
        );
        
        
        col.updateOne(
                Filters.eq("name", "Cafe de la plaza"),
                Updates.combine(
                        Updates.set("phone", "5551112222"),
                        Updates.set("open", true)
                )
        );

        
        // 5.-
        
        col.deleteOne(Filters.eq("name", "Espresso Express"));
         
        col.deleteOne(Filters.lt("stars", 4));
        col.deleteMany(
                Filters.or(Filters.eq("categories", "Takeaway"), Filters.eq("categories", "Infusiones"))           
        );
        
        
         





    }
}
