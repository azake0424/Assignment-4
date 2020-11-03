package controllers;

import com.google.gson.Gson;
import interfaces.IBasketRepository;
import interfaces.IUserRepository;
import models.Users;
import repository.BasketRepository;
import repository.UserRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("basket")
public class Rest {

    private final IBasketRepository basketRepository = new BasketRepository();
    private final IUserRepository userRepository = new UserRepository();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String Hello(){
        List<Users> userList = userRepository.getAllUsers();
        Gson gson=new Gson();
        return gson.toJson(userList);

    }

    @DELETE
    @Path("/{id}/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeBook(@PathParam("id") int id, @PathParam("username") String username) {
        try {
            basketRepository.moveBackTheBook(id, username);
        } catch (ServerErrorException ex) {
            return Response.serverError().build();
        } catch (BadRequestException ex) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("The book is not given").build();
        }
        return Response.status(Response.Status.OK).entity("The book is given").build();
    }
}
