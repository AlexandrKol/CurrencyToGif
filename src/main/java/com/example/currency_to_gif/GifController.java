/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.currency_to_gif;

/**
 *
 * @author A.Kolesov
 */

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import java.util.Random;
public class GifController {

    public GifController(String search) {
        
  Webservice api =   Feign.builder()
 .client(new OkHttpClient())
 .encoder(new GsonEncoder())
 .decoder(new GsonDecoder())
 .logLevel(Logger.Level.FULL)
 .target(Webservice.class, "https://api.giphy.com");
  
                 JsonObject ob;
              if(search.equalsIgnoreCase("broke"))
              ob= api.broke(new Random().nextInt(200));
              else  ob= api.rich(new Random().nextInt(200));
            JsonArray list = ob.getAsJsonArray("data");            
            JsonObject d = ((JsonObject)list.get(0)).getAsJsonObject("images").getAsJsonObject("original");
         System.out.println(d.get("url").getAsString());
    }
    
}
