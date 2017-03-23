package org.kanutan93.shop.cors;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CORS implements ContainerResponseFilter{

    public void filter(final ContainerRequestContext requestContext,
                       final ContainerResponseContext cors) throws IOException {
        cors.getHeaders().add("Access-Control-Allow-Origin", "*");
        cors.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept");
        cors.getHeaders().add("Access-Control-Allow-Credentials", "true");
        cors.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        cors.getHeaders().add("Access-Control-Max-Age", "1209600");
    }
}