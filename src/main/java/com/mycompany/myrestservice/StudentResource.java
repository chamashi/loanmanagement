/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myrestservice;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author hnd
 */
@Path("student")
@RequestScoped
public class StudentResource {
    DBUtils utils = new DBUtils();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StudentResource
     */
    public StudentResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.rest.service.StudentResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getStudents() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(utils.getStudents());
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStudent(@PathParam("id") String id) {
        Student st = utils.getStudent(id);
        Gson gson = new GsonBuilder().create();
        return gson.toJson(st);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStudent(String content) {
        Gson gson = new GsonBuilder().create();
        Student st = gson.fromJson(content, Student.class);
        
        if (st.getId() == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        
       
        utils.addStudent(st);
        
        return Response.status(Response.Status.CREATED).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStudent(String content)  {
        Gson gson = new GsonBuilder().create();
        Student st = gson.fromJson(content, Student.class);
        
        if (st.getId() == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        utils.updateStudent(st);
        return Response.status(Response.Status.OK).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteStudent(@PathParam("id") String id)  {
        utils.deleteStudent(id);
        return Response.status(Response.Status.OK).build();
    }
}
