package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@WebServlet("/formulario")
public class Edad extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String cedula = request.getParameter("cedula");
        String fecha = request.getParameter("fecha");

        // Convertir a LocalDate
        LocalDate fechaNacimiento = LocalDate.parse(fecha);
        LocalDate hoy = LocalDate.now();

        // Calcular el período entre las dos fechas
        Period periodo = Period.between(fechaNacimiento, hoy);

        // Extraer años, meses y días
        int anos = periodo.getYears();
        int meses = periodo.getMonths();
        int dias = periodo.getDays();

        // Enviar los datos a la página JSP
        request.setAttribute("años", anos);
        request.setAttribute("meses", meses);
        request.setAttribute("dias", dias);
        request.setAttribute("fechaNacimiento", fecha);

        String respuesta = anos + " años, " + meses + " meses y " + dias + " días";

        PrintWriter out = response.getWriter();


        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>form</title>");
        out.println("<link rel='stylesheet' href='css/styles.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<br>");
        out.println("<h2>Nombre: " + nombre + "</h2>");
        out.println("<h2>Apellido: " + apellido + "</h2>");
        out.println("<h2>Direccion: " + direccion + "</h2>");
        out.println("<h2>Cedula: " + cedula + "</h2>");
        out.println("<h2>Edad de la persona: " + respuesta + "</h2>");


        out.println("</body>");
        out.println("</html>");



    }
}
