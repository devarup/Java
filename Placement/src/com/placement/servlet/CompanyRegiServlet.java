/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.placement.servlet;

import com.placement.app.Company;
import com.placement.persisting.IPersistable;
import com.placement.persisting.PlacementPersist;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class CompanyRegiServlet extends HttpServlet {
   
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
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println("cmp_id : "+request.getParameter("cmp_id"));
            System.out.println("cmp_name : "+request.getParameter("cmp_name"));
            System.out.println("cmp_url : "+request.getParameter("cmp_url"));
            System.out.println("cmp_detail : "+request.getParameter("cmp_detail"));

            String cmp_id = request.getParameter("cmp_id");
            String cmp_name = request.getParameter("cmp_name");
            String cmp_url = request.getParameter("cmp_url");
            String cmp_detail = request.getParameter("cmp_detail");
            Double xii_marks = Double.valueOf(request.getParameter("xii_marks") );
            Double x_marks = Double.valueOf(request.getParameter("x_marks") );
            String stream = request.getParameter("stream") ;
            Date interview = dateFormat.parse(request.getParameter("interview"));
            String profile = request.getParameter("profile");
            Company cmp = new Company();

            cmp.setCmp_id(cmp_id);
            cmp.setCmp_name(cmp_name);
            cmp.setCmp_url(cmp_url);
            cmp.setCmp_detail(cmp_detail);
            cmp.setInterview(interview);
            cmp.setXii_marks(xii_marks);
            cmp.setX_marks(x_marks);
            cmp.setStream(stream);
            cmp.setJobProfile(profile);
            if(stream.equalsIgnoreCase("Bca"))
            cmp.setSpec("NA");
            else
            cmp.setSpec(request.getParameter("spec"));



            IPersistable ip = PlacementPersist.getInstance();
            Boolean flag = ip.saveCompany(cmp);

            if(flag){
            List<Company> companies = ip.getCompany();
            
                request.setAttribute("companies", companies);
                 dispatcher = request.getRequestDispatcher("admin_main.jsp");
                if (dispatcher != null){
                         dispatcher.forward(request, response);
                }

            }
            else{


            }
            
            
        }
        catch(Exception e){
        e.printStackTrace();
        }finally {
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
