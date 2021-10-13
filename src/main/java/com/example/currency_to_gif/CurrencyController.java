/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.currency_to_gif;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author A.Kolesov
 */
public class CurrencyController {

    public CurrencyController() {
  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");       
  Date dt = new Date();
  Calendar c = Calendar.getInstance(); 
  c.setTime(dt);
  c.add(Calendar.DATE, -1);
  String olddd = format.format(c.getTime())+".json";
  
   Webservice api =   Feign.builder()
 .client(new OkHttpClient())
 .encoder(new GsonEncoder())
 .decoder(new GsonDecoder())
 .logLevel(Logger.Level.FULL)
 .target(Webservice.class, "https://openexchangerates.org");
         double currentdd = api.getCurrentDay().getAsJsonObject("rates").get("RUB").getAsDouble();
     double currentlddd =  api.getCurrentOld(olddd).getAsJsonObject("rates").get("RUB").getAsDouble();
      if((currentdd - currentlddd) > 0){
         new   GifController("rich"); 
      }
      else{
          new   GifController("broke");
      }
    
    }
    
}
