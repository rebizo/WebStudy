package Imp;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import services.AllRequestsServlet;
import services.Servlet2;

public class Main {

    public static void main(String[] args) throws Exception {

        AllRequestsServlet allRequestsServlet = new AllRequestsServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(allRequestsServlet), "/*"/*"/authform"*/);

        Server server = new Server(8080);
        server.setHandler(context);

//      System.out.println("Server started");
//      server.start();
//      server.join();

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
    }
}