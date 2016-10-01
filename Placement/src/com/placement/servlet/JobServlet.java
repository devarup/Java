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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arup
 */
public class JobServlet extends HttpServlet {
   
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
            /* TODO output your page here*/

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            String[] streams = request.getParameterValues("stream");
                        Job job = new Job();
            String com_id  = request.getParameter("cmp_id");
            job.setComp_id(com_id);
            job.setJob_id(request.getParameter("job_id"));
            Date dt = dateFormat.parse(request.getParameter("interview"));
            job.setInterview(dt);
            job.setDescription(request.getParameter("description"));
            job.setProfile(request.getParameter("profile"));
            String stream = "None";
            if(streams.length == 2)
                stream = "Both";
            else if(streams.length == 1)
                stream =streams[0];
            job.setStream(stream);

           IPersistable ip = PlacementPersist.getInstance();
           Boolean flag = ip.saveJobs(job);

            if (flag){

             Company cmp = (Company)ip.getCompany(com_id);
            String jobID = ip.getJobID();

            System.out.print("servlet : " +cmp.getCmp_detail()+"\n");
            System.out.print("servlet : " +cmp.getCmp_name()+"\n");
            System.out.print("servlet : " +cmp.getCmp_url()+"\n");
            System.out.print("servlet : " +cmp.getCmp_id()+"\n");

           request.setAttribute("company", cmp);
           request.setAttribute("jobID", jobID);
           String page ="company_detail.jsp";
           dispatcher = request.getRequestDispatcher(page);
                if (dispatcher != null){
                        dispatcher.forward(request, response);
               }

            }


            
        }catch(Exception e){
            e.printStackTrace();
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
