package org.huluo.embedTomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws LifecycleException, IOException {
        Tomcat tomcat = new Tomcat();
        tomcat.setHostname("localhost");
        tomcat.setPort(80);
        tomcat.setBaseDir("E:/embedTomcat");
        String contextPath = "";

        StandardContext context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());
        tomcat.getHost().addChild(context);

        tomcat.addServlet(contextPath, "hello", new EmbedTomcatServlet());
        context.addServletMappingDecoded("/hello", "hello");

        tomcat.start();

        tomcat.getServer().await();
    }
}
