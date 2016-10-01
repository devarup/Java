/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.placement.servlet;

import com.placement.app.Student;
import com.placement.persisting.IPersistable;
import com.placement.persisting.PlacementPersist;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author arup
 */
public class RegistrationServlet extends HttpServlet {
   
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
        
        try {
        HttpSession hs = request.getSession();
            Student st = new Student();

            SimpleDateFormat fromUser = new SimpleDateFormat("dd-MM-yyyy");
            
        
            System.out.println("userid : "+request.getParameter("userid"));
            System.out.println("password : "+request.getParameter("password"));
            System.out.println("f_name : "+request.getParameter("f_name"));
            System.out.println("l_name : "+request.getParameter("l_name"));
            System.out.println("gender : "+request.getParameter("gender"));
            System.out.println("address : "+request.getParameter("address"));
            System.out.println("cont_1 : "+request.getParameter("cont_1"));
            System.out.println("cont_2 : "+request.getParameter("cont_2"));
            System.out.println("email_id : "+request.getParameter("email_id"));
            System.out.println("stream : "+request.getParameter("stream"));
            System.out.println("percentile : "+request.getParameter("percentile"));
            System.out.println("college : "+request.getParameter("college"));
            System.out.println("board : "+request.getParameter("board"));
            System.out.println("xii_marks : "+request.getParameter("xii_marks"));
            System.out.println("xii_marks : "+request.getParameter("xii_marks"));
            System.out.println("maths : "+request.getParameter("maths"));
            System.out.println("xii_school : "+request.getParameter("xii_school"));
            System.out.println("xii_board : "+request.getParameter("xii_board"));
            System.out.println("x_marks : "+request.getParameter("x_marks"));
            System.out.println("x_school : "+request.getParameter("xii_school"));
            System.out.println("x_board : "+request.getParameter("x_board"));
            System.out.println("dob : "+request.getParameter("dob"));
            

            st.setUserid(request.getParameter("userid"));
            st.setPassword(request.getParameter("password"));
            st.setF_name(request.getParameter("f_name"));
            st.setL_name(request.getParameter("l_name"));
            Date dt = fromUser.parse(request.getParameter("dob"));
            st.setDob(dt);
            
            st.setGender(request.getParameter("gender"));
            st.setAddress(request.getParameter("address"));
            st.setCont_1(request.getParameter("cont_1"));
            st.setCont_2(request.getParameter("cont_2"));
            st.setEmail_id(request.getParameter("email_id"));
            st.setIsShortlisted(Boolean.FALSE);

            st.setStream(request.getParameter("stream"));
            st.setPercentile(Double.valueOf(request.getParameter("percentile")));
            st.setCollege(request.getParameter("college"));
            st.setBoard(request.getParameter("board"));
            st.setXii_marks(Double.valueOf(request.getParameter("xii_marks")));
            if(request.getParameter("stream").equalsIgnoreCase("Btech"))
            st.setMaths(true);
            else
                st.setMaths(Boolean.valueOf(request.getParameter("maths")));
            
            st.setXii_school(request.getParameter("xii_school"));
            st.setXii_board(request.getParameter("xii_board"));

            st.setX_marks(Double.valueOf(request.getParameter("x_marks")));
            st.setX_school(request.getParameter("x_school"));
            st.setX_board(request.getParameter("x_board"));

            String stream = request.getParameter("stream");

            String spec = request.getParameter("spec");
            if(stream.equalsIgnoreCase("Bca"))
                spec = "NA";
            st.setSpec(spec);
            



            


            IPersistable ip = PlacementPersist.getInstance();
            boolean b = ip.saveStudent(st);

            if(b == true)
            {
                 hs.setAttribute("name", request.getParameter("f_name")+" "+request.getParameter("l_name"));
                 
                response.sendRedirect("welcome.jsp");
            
            }
            else
                response.sendRedirect("index.jsp");
        }
        catch(Exception e){
            e.printStackTrace();
        }



        finally {
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
