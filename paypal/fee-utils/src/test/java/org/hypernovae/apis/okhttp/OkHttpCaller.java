package org.hypernovae.apis.okhttp;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpCaller {
	OkHttpClient client = new OkHttpClient(); 
    
    public String run(String url) throws IOException { 
            Request request = new Request.Builder() 
            .url(url) 
            .build(); 
            Response response = client.newCall(request).execute(); 
            return response.body().toString(); 
    } 
    public static void main(String[] args) throws IOException { 
            OkHttpCaller caller = new OkHttpCaller(); 
            
            String response = caller.run("https://github.com/alainlompo/raml-2-the-core/blob/master/claims_management.raml"); 
            System.out.println("The Http call response is:....."); 
            System.out.println(response); 
    }

}
