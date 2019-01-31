package com.luxoft.userstore.webserver;

import com.luxoft.userstore.servlets.delete.DeleteServlet;
import com.luxoft.userstore.servlets.edit.EditFormServlet;
import com.luxoft.userstore.servlets.edit.EditServlet;
import com.luxoft.userstore.servlets.save.SaveFormServlet;
import com.luxoft.userstore.servlets.save.SaveServlet;
import com.luxoft.userstore.servlets.view.ViewServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by OBondar on 31.01.2019.
 */
public class WebServer {
    public static void main(String[] args) throws Exception {
        ViewServlet viewServlet = new ViewServlet();
        DeleteServlet deleteServlet = new DeleteServlet();
        EditFormServlet editFormServlet =new EditFormServlet();
        EditServlet editServlet =new EditServlet();
        SaveFormServlet saveFormServlet =new SaveFormServlet();
        SaveServlet saveServlet = new SaveServlet();
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(viewServlet), "/*");
        context.addServlet(new ServletHolder(deleteServlet),"/DeleteServlet");
        context.addServlet(new ServletHolder(editFormServlet),"/EditFormServlet");
        context.addServlet(new ServletHolder(editServlet),"/EditServlet");
        context.addServlet(new ServletHolder(saveFormServlet),"/SaveFormServlet");
        context.addServlet(new ServletHolder(saveServlet),"/SaveServlet");
        Server server = new Server(3000);
        server.setHandler(context);

        server.start();
    }
}
