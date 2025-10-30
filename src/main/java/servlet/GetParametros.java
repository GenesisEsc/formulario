package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parametros")
public class GetParametros extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        //capturamos los valores o los parametros de la solicitud
        Integer id = Integer.parseInt(req.getParameter("id"));

        // inicializamos el objeto printWriter para escribir en la pantalla
        // el printWriter es como un syso pero para la web, responde con el servidor y llamamos al metodo getWriter
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Id</title>");
        out.println("<link rel='stylesheet' href='css/styles.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<br>");
        out.println("<h2>Id: " + id+ "</h2>");
        out.println("</body>");
        out.println("</html>");

    }
}