package com.deucesDB;


import dao.FactoryDAO;
import dao.UserDAO;
import entities.Users;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/user")
public class Main {
    @GET
    @Path("/{id}")
    @Produces("text/html")
    public String getUser(@PathParam(value = "id") Integer id) {
        UserDAO userDAO = FactoryDAO.getInstance().getUserDAO();
        try {
            Users user = userDAO.getUserByID(id);
            return user.toString();
        } catch (Exception e) {
           return "No such user!";
        }
    }
}
