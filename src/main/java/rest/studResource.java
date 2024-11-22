/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.StudSessionBeanLocal;
import entity.StudentMaster;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Henil
 */
@Path("Stud")
@RequestScoped
public class studResource {

    @EJB
    StudSessionBeanLocal sbl;
    
    

    public studResource() {
    }

    @GET
    @Path("getStudentBySubject/{subid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Collection<StudentMaster> getAllStudentBySubject(@PathParam("subid") int subid) {
        return sbl.getAllStudentBySubject(subid);
    }

    @GET
    @Path("getAllStudent")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<StudentMaster> getAllStudent() {
        return sbl.getAllStudent();
    }

}
