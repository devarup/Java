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
public class UpdateServlet extends HttpServlet {
   
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

            String action = request.getParameter("action");

            if(action.equalsIgnoreCase("update")){
            updateDisplay(request, response);
            }

            else if(action.equalsIgnoreCase("save")){
                updateSave(request, response);
            }
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally { 
            out.close();
        }
    }

    public void updateDisplay(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

                String user_id = request.getParameter("user_id");
                String page = "";
                RequestDispatcher dispatcher = null;
                try{
                 IPersistable ip = PlacementPersist.getInstance();
                 Student  stu = ip.getStudentDetail(user_id);

                 page = "student_update.jsp";
                 request.setAttribute("student", stu);
                 request.setAttribute("stu_id", user_id);
                 
                dispatcher = request.getRequestDispatcher(page);
                    if (dispatcher != null){
                             dispatcher.forward(request, response);
                    }
                  }
            catch(Exception e){
                e.printStackTrace();

                }
   }

    public void updateSave(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
                Student st = new Student();

            SimpleDateFormat fromUser = new SimpleDateFormat("dd-MM-yyyy");
            RequestDispatcher dispatcher = null;
            try{
                st.setUserid(request.getParameter("userid"));
            st.setF_name(request.getParameter("f_name"));
            st.setL_name(request.getParameter("l_name"));
            Date dt = fromUser.parse(request.getParameter("dob"));
            st.setDob(dt);

            st.setGender(request.getParameter("gender"));
            st.setAddress(request.getParameter("address"));
            st.setCont_1(request.getParameter("cont_1"));
            st.setCont_2(request.getParameter("cont_2"));
            st.setEmail_id(request.getParameter("email_id"));
            

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

            IPersistable ip = PlacementPersist.getInstance();
            ip.updateStudent(st);

             String page = "";
             String user_id = request.getParameter("userid");
             Student  stu = ip.getStudentDetail(user_id);
                 page = "student_main.jsp";
                 request.setAttribute("student", stu);
                 request.setAttribute("stu_id", user_id);

                
                dispatcher = request.getRequestDispatcher(page);
                if (dispatcher != null){
                         dispatcher.forward(request, response);
                }
            

            }
            catch(Exception e){
            e.printStackTrace();


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
