package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Liam
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/RegistrationServlet"})
public class RegistrationServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (isInputCorrect(request.getParameter("username"), request.getParameter("password"))) {
            request.getRequestDispatcher("login.html").forward(request, response);
        } else {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registration Error</title>");
                out.println("<link href=\"css/style.css\" rel=\"stylesheet\">");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1 id=\"error\">Error</h1>");
                out.println(
                    "<p>Username needs to be at least " +
                    "<span class=\"how-long\">2 characters long</span>" +
                    " and password needs to be at least " +
                    "<span class=\"how-long\">6 characters long</span>.</p>"
                );
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
    
    private boolean isInputCorrect(String username, String password) {
        return username.length() >= 2 && password.length() >= 6;
    }
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
