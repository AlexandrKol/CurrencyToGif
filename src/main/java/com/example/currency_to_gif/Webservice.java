/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.currency_to_gif;

import com.google.gson.JsonObject;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 *
 * @author A.Kolesov
 */
interface Webservice {
    
    // https://api.giphy.com
    String  Gif_api_key ="fZ55Teqzm9ydbO7HzUqwu1WFlR9uQ34m";
    
    // https://openexchangerates.org
    String  OpenExchangeRates_api_key ="e5c0d8d370794826bface29b26a67634";
    
    
    @RequestLine("GET /v1/gifs/search?api_key="+Gif_api_key+"&q=rich&limit=1&offset={offset}")
@Headers("Content-Type: application/json")
 JsonObject      rich (@Param("offset") int offset);
   
 @RequestLine("GET /v1/gifs/search?api_key="+Gif_api_key+"&q=broke&limit=1&offset={offset}")
@Headers("Content-Type: application/json")
 JsonObject      broke (@Param("offset") int offset);   
 
  @RequestLine("GET /api/latest.json?app_id="+ OpenExchangeRates_api_key)
@Headers("Content-Type: application/json")
 JsonObject     getCurrentDay ();  
 
   @RequestLine("GET /api/historical/{day}?app_id=" + OpenExchangeRates_api_key)
@Headers("Content-Type: application/json")
 JsonObject     getCurrentOld (@Param("day") String day);
}}
