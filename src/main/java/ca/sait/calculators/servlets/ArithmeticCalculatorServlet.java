package ca.sait.calculators.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 *
 * @author 744941
 */
@WebServlet(name = "ArithmeticCalculatorServlet", urlPatterns = {"/arithmetic"})
public class ArithmeticCalculatorServlet extends HttpServlet {
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
        String result = "---";
        request.setAttribute("result", result);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }

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
                String firstInput= request.getParameter("first");
                String secondInput= request.getParameter("second");
                String result = "---";

                 if(firstInput != null && secondInput != null){

            try {

                int first= Integer.parseInt(firstInput);
                int second= Integer.parseInt(secondInput);
                
                if(request.getParameter("add") != null) {
                result = Integer.toString(first + second);
                }

                else if(request.getParameter("subtract") != null) {
                result = Integer.toString(first - second);
                }

                else if(request.getParameter("multiply") != null) {
                result = Integer.toString(first * second);
                }

                else if(request.getParameter("divide") != null) {
                result = Integer.toString(first / second);
                }

                } catch(Exception ex){
                result = "invalid";
                }
            } else{
                result = "invalid";
                }

                request.setAttribute("result", result);

                getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }


}
