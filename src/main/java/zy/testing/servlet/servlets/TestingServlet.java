package zy.testing.servlet.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestingServlet extends HttpServlet {

    private static final long serialVersionUID = 7574892849216936837L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/SecondServlet");
        dispatcher.include(request, response);

        /*
         * PrintWriter out = response.getWriter(); out.println("<html><head>"); // System.out.println("++++++ " +
         * getServletContext().getContextPath()); // RequestDispatcher rd1 =
         * getServletContext().getRequestDispatcher("/WEB-INF/javascript/simpleJS.js"); // rd1.include(request,
         * response); // RequestDispatcher dispatcher = request.getRequestDispatcher("/SecondServlet"); //
         * dispatcher.include(request, response);
         * out.println("<script type=\"text/javascript\" src=\"javascript/simpleJS.js\">"); //
         * out.println("function myFunction() {"); //
         * out.println("document.getElementById(\"demo\").innerHTML = \"Paragraph changed.\";"); // out.println("}");
         * out.println("</script>"); out.println("<title>Hello World!</title></head>"); out.println("<body>");
         * RequestDispatcher dispatcher = request.getRequestDispatcher("/SecondServlet"); dispatcher.include(request,
         * response); out.println("<h1>Hello World ffff!</h1> "); out.println("<p id=\"demo\">A paragraph");
         * out.println("<button type=\"button\" onclick=\"myFunction()\">Try it</button>");
         * out.println("</body></html>"); out.flush(); out.close();
         */
    }
}

