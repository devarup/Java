/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.placement.servlet;

import com.placement.app.Company;
import com.placement.app.Student;
import com.placement.persisting.IPersistable;
import com.placement.persisting.PlacementPersist;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author arup
 */
public class LoginServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher = null;
        try {
            HttpSession hs = request.getSession();
            if(hs.getAttribute("role")!= null  && ((String)hs.getAttribute("role")).equalsIgnoreCase("ADMIN")){
                 String page1 = "admin_main.jsp";
                IPersistable ips = PlacementPersist.getInstance();
                 List<Company> companies = ips.getCompany();
                request.setAttribute("companies", companies);
                dispatcher = request.getRequestDispatcher(page1);
                if (dispatcher != null){
                         dispatcher.forward(request, response);
                }



            }
            String user_id = request.getParameter("user_id");
            String pwd = request.getParameter("password");
            System.out.println("uid"+user_id);
            System.out.println("pwd"+pwd);

            IPersistable ip = PlacementPersist.getInstance();

            String role = ip.getUserRole(user_id, pwd);

            if(!role.equals(""))
            {
                String page ="";
                if(role.equalsIgnoreCase("Admin")){
                page = "admin_main.jsp";
                List<Company> companies = ip.getCompany();
                request.setAttribute("companies", companies);
                hs.setAttribute("uid", user_id);
                hs.setAttribute("pwd", pwd);
                hs.setAttribute("role", "ADMIN");

                }
                else if (role.equalsIgnoreCase("STUDENT")){
                 Student  stu = ip.getStudentDetail(user_id);
                 page = "student_main.jsp";
                 request.setAttribute("student", stu);
                 request.setAttribute("stu_id", user_id);

                }
                dispatcher = request.getRequestDispatcher(page);
                if (dispatcher != null){
                         dispatcher.forward(request, response);
                }
            }
            else{
                request.setAttribute("message","Wrong User id or password");
                dispatcher = request.getRequestDispatcher("index.jsp");
                    if (dispatcher != null){
                         dispatcher.forward(request, response);
                    }

            }


        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
