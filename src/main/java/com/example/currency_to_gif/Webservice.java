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
    @RequestLine("GET /v1/gifs/search?api_key=fZ55Teqzm9ydbO7HzUqwu1WFlR9uQ34m&q=rich&limit=1&offset={offset}")
@Headers("Content-Type: application/json")
 JsonObject      rich (@Param("offset") int offset);
   
 @RequestLine("GET /v1/gifs/search?api_key=fZ55Teqzm9ydbO7HzUqwu1WFlR9uQ34m&q=broke&limit=1&offset={offset}")
@Headers("Content-Type: application/json")
 JsonObject      broke (@Param("offset") int offset);   
 
  @RequestLine("GET /api/latest.json?app_id=e5c0d8d370794826bface29b26a67634")
@Headers("Content-Type: application/json")
 JsonObject     getCurrentDay ();  
 
   @RequestLine("GET /api/historical/{day}?app_id=e5c0d8d370794826bface29b26a67634")
@Headers("Content-Type: application/json")
 JsonObject     getCurrentOld (@Param("day") String day);
}
