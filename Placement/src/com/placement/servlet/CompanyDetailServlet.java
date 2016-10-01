/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.placement.servlet;

import com.placement.app.Company;
import com.placement.app.Job;
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

/**
 *
 * @author arup
 */
public class CompanyDetailServlet extends HttpServlet {
   
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
            
            String companyID = request.getParameter("com_id");
            String page ="company_detail.jsp";
            IPersistable ip = PlacementPersist.getInstance();
            Company cmp = (Company)ip.getCompany(companyID);
            String jobID = ip.getJobID();

            //List<Job> jobs = (List<Job>) ip.getJobs(companyID);

            System.out.print("servlet : " +cmp.getCmp_detail()+"\n");
            System.out.print("servlet : " +cmp.getCmp_name()+"\n");
            System.out.print("servlet : " +cmp.getCmp_url()+"\n");
            System.out.print("servlet : " +cmp.getCmp_id()+"\n");

           request.setAttribute("company", cmp);
           //request.setAttribute("jobID", jobID);
          //     request.setAttribute("job_post", jobs);


           dispatcher = request.getRequestDispatcher(page);
                if (dispatcher != null){
                       dispatcher.forward(request, response);
           }

                
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet StudentServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet StudentServlet at " + cmp.getStream() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
                


            
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
