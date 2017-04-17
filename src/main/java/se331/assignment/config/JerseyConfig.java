package se331.assignment.config;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import se331.assignment.controller.ProductController;

/**
 * Created by iammiind on 4/16/2017 AD.
 */
@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        // regeister the class as a jersey
        register(ProductController.class);
        register(MultiPartFeature.class);
    }
}
