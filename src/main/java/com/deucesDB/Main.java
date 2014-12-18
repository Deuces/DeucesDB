package com.deucesDB;

import com.facebook.api.FacebookJsonRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/index")
public class Main {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String func() {
        return "Hello, world!";
    }

   // FacebookJsonRestClient client = new FacebookJsonRestClient("apiKey", )
}
