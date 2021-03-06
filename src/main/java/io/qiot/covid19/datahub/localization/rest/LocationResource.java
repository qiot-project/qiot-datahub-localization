package io.qiot.covid19.datahub.localization.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;

import io.qiot.covid19.datahub.localization.domain.dto.Location;
import io.qiot.covid19.datahub.localization.service.LocationService;

/**
 * Validation through hibernate validator:
 * https://quarkus.io/guides/validation#rest-end-point-validation
 * 
 * @author andreabattaglia
 *
 */
@Path("/location")
public class LocationResource {

    @Inject
    Logger LOGGER;

    @Inject
    LocationService service;

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Location getById(@QueryParam("longitude") double longitude,
            @QueryParam("latitude") double latitude) throws Exception {
        return service.translateCoordinates(longitude, latitude);
    }

}