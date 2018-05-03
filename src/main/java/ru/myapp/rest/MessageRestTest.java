package ru.myapp.rest;

import ru.myapp.app.MessageProducer;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/")
@Produces({"application/json"})
public class MessageRestTest {

    @EJB
    private MessageProducer messageProducer;

    @GET
    @Path("/test")
    public Response test() {
        String result = messageProducer.sendMessage("sdfsdfsdf");
        return Response.status(200).entity(result).build();
    }

}
