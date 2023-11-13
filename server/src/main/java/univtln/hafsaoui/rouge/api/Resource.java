package univtln.hafsaoui.rouge.api;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import univtln.hafsaoui.rouge.daos.Dto;

import java.util.List;

public interface Resource {

    /**
     * Take an entity and return a response from it
     * @param entity
     * @return
     */
    public default Response responseFrom(List<Dto> entity) {
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(entity.toString())
                .build();
    }

    public Response getAll(@Context HttpHeaders headers, @QueryParam("page") Integer page);
    public Response get(@PathParam("name") String name) ;
    public Response help() ;
    public Response delete(String name);
    public Response add(String name);
}
