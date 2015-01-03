package com.deucesDB;


import dao.FactoryDAO;
import dao.UserDAO;
import entities.Users;

import javax.ws.rs.*;
import java.sql.SQLException;

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
    @Path("/add")
    @GET
    public String addUser(){
        Users user = new Users();
        user.setUserId(10);
        user.setLogin("Sutula");
        user.setPass("1234");
        UserDAO userDAO = FactoryDAO.getInstance().getUserDAO();
        try {
            userDAO.addUser(user);
            return user.toString();
        } catch (SQLException e){
            return "Fuck you with your Exception!";
        }
    }
}