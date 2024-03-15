package org.apache.camel.learn;

import javax.naming.Context;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.Main;
import org.apache.camel.support.DefaultRegistry;

/**
 * A Camel Application
 */
public class MainAppCamelPipele {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
       DefaultRegistry registry = new DefaultRegistry();
       registry.bind("myProcessor", new MyProcessor());
       CamelContext context = new DefaultCamelContext(registry);
       context.addRoutes(new MyRouteArchive());
         context.start();
            Thread.sleep(10000);
            context.stop();
    }

}

