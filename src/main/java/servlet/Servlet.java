package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//anotacion-> es una llavce para conectarse de cualquier parte
//de mi programa al servlet
@WebServlet("/holaServlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //tipo de documento o de archivo que me va a devolver el servlet
       resp.setContentType("text/html");

       //creo objeto clase getparametros
        GetParametros getParametros = new GetParametros();
        getParametros.doGet(req, resp);

       //capturamos los valores o los parametros de la solicitud
        String saludo = req.getParameter("saludo");

        // captura el parametro nombre
        String nombre = req.getParameter( "nombre");

        // inicializamos el objeto printWriter para escribir en la pantalla
        // el printWriter es como un syso pero para la web, responde con el servidor y llamamos al metodo getWriter
       PrintWriter out = resp.getWriter();
       /*
       * Escribimos la respuesta del servidor
        */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet</title>");
        out.println("<link rel='stylesheet' href='css/styles.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Practica</h1>");
        out.println("<br>");
        out.println("<h2>Saludando: " + saludo+ " " + nombre + "</h2>");
        out.println("</body>");
        out.println("</html>");
    }
}
