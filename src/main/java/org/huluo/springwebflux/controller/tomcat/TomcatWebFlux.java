package org.huluo.springwebflux.controller.tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.huluo.springwebflux.controller.tomcat.repository.PersonRepository;
import org.huluo.springwebflux.controller.tomcat.repository.PersonRepositoryImp;
import org.huluo.springwebflux.controller.tomcat.util.PersonHandler;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ServletHttpHandlerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;
import static org.springframework.web.reactive.function.server.RequestPredicates.method;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

@Component
public class TomcatWebFlux  implements InitializingBean{

    private static final String HOST = "localhost";
    private static final int PORT = 8080;

    public RouterFunction<ServerResponse> routingFunction() {
        PersonRepository repository = new PersonRepositoryImp();
        PersonHandler handler = new PersonHandler(repository);

        return nest(path("/person"),
                nest(accept(APPLICATION_JSON),
                        route(GET("/{id}"), handler::getPerson)
                                .andRoute(method(HttpMethod.GET), handler::listPeople)
                ).andRoute(POST("/").and(contentType(APPLICATION_JSON)), handler::createPerson));
    }
    public void startTomcatServer() throws LifecycleException {
        RouterFunction<?> route = routingFunction();

        HttpHandler httpHandler = toHttpHandler(route);

        Tomcat tomcatServer = new Tomcat();

        tomcatServer.setHostname(HOST);
        tomcatServer.setPort(PORT);

        Context rootContext = tomcatServer.addContext("", System.getProperty("java.io.tmpdir"));
        ServletHttpHandlerAdapter servlet = new ServletHttpHandlerAdapter(httpHandler);
        Tomcat.addServlet(rootContext, "httpHandlerServlet", servlet);
        rootContext.addServletMapping("/", "httpHandlerServlet");
        tomcatServer.start();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        startTomcatServer();
    }

    public static void main(String[] args) throws LifecycleException, IOException {
        new TomcatWebFlux().startTomcatServer();
        System.out.println("");
        System.in.read();
    }
}
