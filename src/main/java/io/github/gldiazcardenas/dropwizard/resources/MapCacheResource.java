package io.github.gldiazcardenas.dropwizard.resources;

import com.codahale.metrics.annotation.Timed;
import io.github.gldiazcardenas.dropwizard.services.MapCacheService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/map-cache")
@Produces(MediaType.APPLICATION_JSON)
public class MapCacheResource {

    private final MapCacheService service;

    @Inject
    public MapCacheResource(MapCacheService service) {
        this.service = service;
    }

    @GET
    @Path("/get/{key}")
    @Timed
    public String get(@PathParam("key") String key) {
        return service.get(key);
    }

    @GET
    @Path("/put/{key}/{value}")
    @Timed
    public String put(@PathParam("key") String key, @PathParam("value") String value) {
        return service.put(key, value);
    }

}
