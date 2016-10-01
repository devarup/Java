/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.placement.persisting;

import com.placement.app.Company;
import com.placement.app.Job;
import com.placement.app.JobSeeker;
import com.placement.app.Student;
import com.placement.types.UserType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.ParameterMetaData;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.jasper.tagplugins.jstl.core.Catch;
import sun.awt.image.ImageWatched.Link;

/**
 *
 * @author arup
 */
public class PlacementPersist implements IPersistable {

    private static String conURL = "jdbc:mysql://localhost:3306/placement";
    private static String dbID = "root";
    private static String dbPwd = "";
    private static Connection conn = null;
    private static IPersistable placementPersist = null;


    


    private PlacementPersist(){
    try{
    Class.forName("com.mysql.jdbc.Driver");
    }
    catch(Exception e){
    e.printStackTrace();
    }

    }

    public static IPersistable getInstance(){

        if(placementPersist == null)
         placementPersist = new PlacementPersist();
        getConnection();
        return placementPersist;


    }

    public static Connection getConnection(){

        try{
        if(conn == null)
        conn = DriverManager.getConnection(conURL,dbID,dbPwd);
        }
        catch(Exception e)
            {
                 e.printStackTrace();
           }

        return  conn;

    }

    public Boolean saveStudent(Student jb) {

        boolean flg = false;
        try{
            if(conn == null)
              conn = getConnection();
            
            String role = UserType.STUDENT.toString();

            String sql = "Insert into login (user_id,user_pwd,role) values(?,?,?)";
            PreparedStatement pstmt = null;

            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, jb.getUserid());
            pstmt.setString(2, jb.getPassword());
            pstmt.setString(3, role);

            int i = pstmt.executeUpdate();
        
            if(i==1)
            flg = true;
            else
            return false;
           

            sql = "Insert into user_personal_detail values(?,?,?,?,?,?,?,?,?,?)";
            java.sql.Date.valueOf ("2008-07-31");
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, jb.getUserid());
            pstmt.setString(2, jb.getF_name());
            pstmt.setString(3, jb.getL_name());
            pstmt.setTimestamp(4, new Timestamp(jb.getDob().getTime()));
            pstmt.setString(5,jb.getGender());
            pstmt.setString(6,jb.getEmail_id());
            pstmt.setString(7,jb.getAddress());
            pstmt.setString(8,jb.getCont_1());
            pstmt.setString(9,jb.getCont_2());
            pstmt.setBoolean(10,jb.getIsShortlisted());
            
             i = pstmt.executeUpdate();

             if(i==1)
             flg = true;
             else
                 return false;
             
              sql = "Insert into user_education values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
              pstmt = conn.prepareStatement(sql);
              pstmt.setString(1, jb.getUserid());
              pstmt.setString(2, jb.getStream());
              pstmt.setDouble(3, jb.getPercentile());
              pstmt.setString(4, jb.getCollege());
              pstmt.setString(5, jb.getBoard());
              pstmt.setDouble(6, jb.getXii_marks());
              pstmt.setBoolean(7, jb.getMaths());
              pstmt.setString(8, jb.getXii_school());
              pstmt.setString(9, jb.getXii_board());
              pstmt.setDouble(10, jb.getX_marks());
              pstmt.setString(11, jb.getX_school());
              pstmt.setString(12, jb.getX_board());
              pstmt.setString(13, jb.getSpec());
              i = pstmt.executeUpdate();


             if(i==1){
                     conn.commit();
                 flg = true;}
                 else
                   return false;




    }
    catch(Exception e )
    {
        e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(PlacementPersist.class.getName()).log(Level.SEVERE, null, ex);
            }
    return false;
    }
        return flg;
  }

    public String getUserRole(String user_id, String password) {
        String role = "";
        try{
            if(conn == null)
              conn = getConnection();
        String sql = "Select role from login where user_id='"+user_id+"' and user_pwd='"+password+"'";
         System.out.println("sql "+sql);
         Statement st = conn.createStatement();
          ResultSet rs = st.executeQuery(sql);
                
                while(rs.next())
                  {
                   role = rs.getString("role") ;
                   System.out.println("role "+role);
                }

        }
        catch(Exception e){

        }

        return role;
    }

    public Boolean saveCompany(Company company) {

        String sql = "Insert into cmp_detail (cmp_id,cmp_name,cmp_url,cmp_detail,xii_marks,x_marks,interview,stream,profile,spec) values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = null;
        System.out.print("id : " +company.getCmp_id());
        System.out.print("name : " +company.getCmp_name());
        System.out.print("url : " +company.getCmp_url());
        System.out.print("detail : " +company.getCmp_detail());



            try{
                if(conn == null)
              conn = getConnection();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, company.getCmp_id());
            pstmt.setString(2, company.getCmp_name());
            pstmt.setString(3, company.getCmp_url());
            pstmt.setString(4, company.getCmp_detail());
            pstmt.setDouble(5, company.getXii_marks());
            pstmt.setDouble(6, company.getX_marks());
            pstmt.setTimestamp(7, new Timestamp(company.getInterview().getTime()));
            pstmt.setString(8, company.getStream());
            pstmt.setString(9, company.getJobProfile());
            pstmt.setString(10, company.getSpec());
            

            int i = pstmt.executeUpdate();
               conn.commit();
            
            }
            catch(Exception e){
                try {
            e.printStackTrace();
                conn.rollback();
                return false;
            } catch (SQLException ex) {
                Logger.getLogger(PlacementPersist.class.getName()).log(Level.SEVERE, null, ex);

            }
                 return  false;
            }
            return true;
    }

    public List<Company> getCompany() {

        String sql = "";
        Statement st = null;
        ResultSet rs = null;
        List<Company> companies = new LinkedList<Company>();
        try{
            if(conn == null)
              conn = getConnection();
         sql = "Select * from cmp_detail";
         st = conn.createStatement();
         rs = st.executeQuery(sql);

                while(rs.next())
                {
                    Company cmp = new Company();
                    cmp.setCmp_id(rs.getString(2));
                    cmp.setCmp_name(rs.getString(3));
                    cmp.setCmp_url(rs.getString(4));
                    cmp.setCmp_detail(rs.getString(5));
                    cmp.setXii_marks(rs.getDouble(6));
                    cmp.setX_marks(rs.getDouble(7));
                    cmp.setInterview(rs.getDate(8));
                    cmp.setStream(rs.getString(9));
                    cmp.setJobProfile(rs.getString(10));
                    cmp.setSpec(rs.getString(11));
                  companies.add(cmp);
                }

        }
        catch(Exception e)
        {
        e.printStackTrace();
        return null;
        }
        return companies;
    }

    public Company getCompany(String company) {
        String sql = "";
        Statement st = null;
        ResultSet rs = null;
        Company cmp = new Company();
        try{
            if(conn == null)
              conn = getConnection();
         sql = "Select * from cmp_detail where cmp_id='"+company+"'";
         System.out.print("getCompany : "+ sql);
         st = conn.createStatement();
         rs = st.executeQuery(sql);

                while(rs.next())
                {
                   cmp.setCmp_id(rs.getString(2));
                   cmp.setCmp_name(rs.getString(3));
                   cmp.setCmp_url(rs.getString(4));
                   cmp.setCmp_detail(rs.getString(5));
                   cmp.setXii_marks(rs.getDouble(6));
                    cmp.setX_marks(rs.getDouble(7));
                    cmp.setInterview(rs.getDate(8));
                    cmp.setStream(rs.getString(9));
                    cmp.setJobProfile(rs.getString(10));
                    cmp.setSpec(rs.getString(11));
                }
         System.out.print("cmp id : " + cmp.getCmp_id());
         System.out.print("cmp name : " + cmp.getCmp_name());
         System.out.print("cmp id : " + cmp.getCmp_url());
         System.out.print("cmp id : " + cmp.getCmp_detail());

        }
        catch(Exception e){
            e.printStackTrace();

        }

        return cmp;

    }


    public List<Job> getJobs(String com_id){

    List<Job> jobs =new LinkedList<Job>();
    String sql = "";
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
        try{
            if(conn == null)
              conn = getConnection();
         sql = "Select * from jobs where comp_id='"+com_id+"'";
         System.out.print("getJobs : "+sql);
         st = conn.createStatement();
         rs = st.executeQuery(sql);

                while(rs.next())
                {
                    Job jb = new Job();
                    jb.setJob_id(rs.getString(2));
                    jb.setComp_id(rs.getString(3));
                    jb.setProfile(rs.getString(4));
                    jb.setDescription(rs.getString(5));
                    jb.setInterview(rs.getDate(6));
                    jb.setStream(rs.getString(7));
                    jobs.add(jb);
                
                }
        }
        catch(Exception e){
        e.printStackTrace();
        }
            return jobs;
    }

    public Boolean saveJobs(Job job) {

        String sql = "Insert into jobs (job_id,comp_id,profile,description,interview,stream_type) values(?,?,?,?,?,?)";
        System.out.print("saveJobs : "+sql);
        PreparedStatement pstmt = null;

        System.out.print("id : "+ job.getJob_id()+"\n");
        System.out.print("comid : "+ job.getJob_id()+"\n");
        System.out.print("profile : "+ job.getProfile()+"\n");
        System.out.print("description : "+ job.getDescription()+"\n");
        System.out.print("inter : "+ job.getInterview().toString()+"\n");
        System.out.print("inter : "+ job.getStream()+"\n");


        try{
            if(conn == null)
              conn = getConnection();
        conn.setAutoCommit(false);
        pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, job.getJob_id());
        pstmt.setString(2, job.getComp_id());
        pstmt.setString(3, job.getProfile());
        pstmt.setString(4, job.getDescription());
        pstmt.setTimestamp(5, new Timestamp(job.getInterview().getTime()));
        pstmt.setString(6, job.getStream());


        
         int i = pstmt.executeUpdate();
               conn.commit();
        }
        catch(Exception e){
         try {
            e.printStackTrace();
                conn.rollback();
                return false;
            } catch (SQLException ex) {
                Logger.getLogger(PlacementPersist.class.getName()).log(Level.SEVERE, null, ex);

            }
            return  false;
        }
        return  true;
    }

    public String getJobID() {

    String sql = "";
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    int count = 0;
        try{
            if(conn == null)
              conn = getConnection();
         sql = "Select count(*) from jobs";
         System.out.print("JobID : "+sql);
         st = conn.createStatement();
         rs = st.executeQuery(sql);
            
                while(rs.next())
                {
                    count = rs.getInt(1);

                }
        }
        catch(Exception e){
        e.printStackTrace();
        }

    return "careerstechno_"+count;
    }

    public List<Student> getStudents(String filter) {

        String sql_detail = "";
        String sql_edu = "";

        if(filter.equalsIgnoreCase("All"))
            sql_detail ="Select * from  user_personal_detail";
        else if(filter.equalsIgnoreCase("Shotlisted"))
             sql_detail ="Select * from  user_personal_detail where isSelected=true";
        else if(filter.equalsIgnoreCase("NotShortListed"))
            sql_detail ="Select * from  user_personal_detail where isSelected=false";
        else
            sql_detail ="Select * from  user_personal_detail where user_id='"+filter+"'";

        Statement st = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        List<Student> students = new LinkedList<Student>();

        try{
            if(conn == null)
              conn = getConnection();
        st = conn.createStatement();
        rs = st.executeQuery(sql_detail);

            while(rs.next()){
            Student det = new Student();
            String uid = rs.getString(1);
            det.setUserid(uid);
            det.setF_name(rs.getString(2));
            det.setL_name(rs.getString(3));
            det.setDob(rs.getDate(4));
            det.setGender(rs.getString(5));
            det.setEmail_id(rs.getString(6));
            det.setAddress(rs.getString(7));
            det.setCont_1(rs.getString(8));
            det.setCont_2(rs.getString(9));
            det.setIsShortlisted(rs.getBoolean(10));

            Student edu = getEduDetail(uid);
            det.setStream(edu.getStream());
            det.setPercentile(edu.getPercentile());
            det.setCollege(edu.getCollege());
            det.setBoard(edu.getBoard());
            det.setXii_marks(edu.getXii_marks());
            det.setMaths(edu.getMaths());
            det.setXii_school(edu.getXii_school());
            det.setXii_board(edu.getXii_board());

            det.setX_marks(edu.getX_marks());
            det.setX_school(edu.getX_school());
            det.setX_board(edu.getX_board());

            students.add(det);
            }

        }
        catch(Exception e){
           e.printStackTrace();
        }
        return students;
    }

    public Student getEduDetail(String stu_id){

     Statement st = null;
     ResultSet rs = null;
     PreparedStatement pstmt = null;
     Student students = new Student();
     String sql = "Select * from user_education where user_id='"+stu_id+"'";
     try{
         if(conn == null)
              conn = getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);

                while(rs.next())
                {
                students.setUserid(rs.getString(1));
                students.setStream(rs.getString(2));
                students.setPercentile(rs.getDouble(3));
                students.setCollege(rs.getString(4));
                students.setBoard(rs.getString(5))    ;
                students.setXii_marks(rs.getDouble(6));
                students.setMaths(rs.getBoolean(7));
                students.setXii_school(rs.getString(8));
                students.setXii_board(rs.getString(9));
                students.setX_marks(rs.getDouble(10));
                students.setX_school(rs.getString(11));
                students.setX_board(rs.getString(12));
                students.setSpec(rs.getString(13));

                }
     }
     catch(Exception e){
     e.printStackTrace();
     }

     return students;
    }

    public static void main(String args[]){
    

    }

    public List<Student> filterStudent(Double xii_marks,Double x_marks){

        String sql_detail ="Select edu.user_id,first_name,last_name,xii_marks,x_marks from  user_education as edu, user_personal_detail as per "
                              +"where edu.user_id=per.user_id AND edu.xii_marks>"+xii_marks
                              +" ANd edu.x_marks>"+x_marks+" And per.isSelected=false";

        System.out.println("filter query :");
        System.out.println(sql_detail);

        List<Student> students = new LinkedList<Student>();
        
         Statement st = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        
        try{
            if(conn == null)
              conn = getConnection();

            st = conn.createStatement();
        rs = st.executeQuery(sql_detail);

            while(rs.next()){
            Student det = new Student();
            det.setUserid(rs.getString(1));
            det.setF_name(rs.getString(2));
            det.setL_name(rs.getString(3));
            det.setXii_marks(rs.getDouble(4));
            det.setX_marks(rs.getDouble(5));

            students.add(det);


            }


        }
        catch(Exception e){
        e.printStackTrace();


        }

          return students;
    }

    public Student getStudentPersonal(String id){
     String sql_detail ="Select * from  user_personal_detail where user_id='"+id+"'";
     
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
     Student det = new Student();
   
    
    try{
        if(conn == null)
              conn = getConnection();

     st = conn.createStatement();
        rs = st.executeQuery(sql_detail);

            while(rs.next()){
           
            String uid = rs.getString(1);
            det.setUserid(uid);
            det.setF_name(rs.getString(2));
            det.setL_name(rs.getString(3));
            det.setDob(rs.getDate(4));
            det.setGender(rs.getString(5));
            det.setEmail_id(rs.getString(6));
            det.setAddress(rs.getString(7));
            det.setCont_1(rs.getString(8));
            det.setCont_2(rs.getString(9));
            det.setIsShortlisted(rs.getBoolean(10));

    }
    }
        catch(Exception e) {
        e.printStackTrace();
    }


    return det;
    }

    public List<Student> studentList(String filter){

        String var = "";
        if(filter.equalsIgnoreCase("1"))
            var = "IN";
        else if(filter.equalsIgnoreCase("0"))
            var = "NOT IN";

     String sql_detail = "SELECT * FROM user_personal_detail WHERE user_id "+var+" ( Select user.user_id from user_education as user, cmp_detail as cmp where user.xii_marks>cmp.xii_marks AND user.x_marks>cmp.x_marks AND user.stream = cmp.stream  AND user.maths=true AND user.spec=cmp.spec group by user.user_id )";
     Statement st = null;
     ResultSet rs = null;
     PreparedStatement pstmt = null;
     List<Student> students = null;
     
 try{

     if(conn == null)
              conn = getConnection();
     st = conn.createStatement();
        rs = st.executeQuery(sql_detail);
        
        students = new LinkedList<Student>();
            while(rs.next()){
            Student det = new Student();
            String uid = rs.getString(1);
            det.setUserid(uid);
            det.setF_name(rs.getString(2));
            det.setL_name(rs.getString(3));
            det.setDob(rs.getDate(4));
            det.setGender(rs.getString(5));
            det.setEmail_id(rs.getString(6));
            det.setAddress(rs.getString(7));
            det.setCont_1(rs.getString(8));
            det.setCont_2(rs.getString(9));
            det.setIsShortlisted(rs.getBoolean(10));
            students.add(det);
            }
 }
        catch(Exception e){
            e.printStackTrace();

        }
 
    return students;
    }

    public Student getStudentDetail(String id){

        String sql_detail ="Select * from  user_personal_detail where user_id='"+id+"'";
        System.out.print("Sql : "+ sql_detail);

        Statement st = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
         Student det = null;

        try{
        if(conn == null)
           conn = getConnection();
        st = conn.createStatement();
        rs = st.executeQuery(sql_detail);

            while(rs.next()){
            det = new Student();
            String uid = rs.getString(1);
            det.setUserid(uid);
            det.setF_name(rs.getString(2));
            det.setL_name(rs.getString(3));
            det.setDob(rs.getDate(4));
            det.setGender(rs.getString(5));
            det.setEmail_id(rs.getString(6));
            det.setAddress(rs.getString(7));
            det.setCont_1(rs.getString(8));
            det.setCont_2(rs.getString(9));
            det.setIsShortlisted(rs.getBoolean(10));

            Student edu = getEduDetail(uid);
            det.setStream(edu.getStream());
            det.setPercentile(edu.getPercentile());
            det.setCollege(edu.getCollege());
            det.setBoard(edu.getBoard());
            det.setXii_marks(edu.getXii_marks());
            det.setMaths(edu.getMaths());
            det.setXii_school(edu.getXii_school());
            det.setXii_board(edu.getXii_board());

            det.setX_marks(edu.getX_marks());
            det.setX_school(edu.getX_school());
            det.setX_board(edu.getX_board());

            
            }

        }
        catch(Exception e){
           e.printStackTrace();
        }
         return det;
       }

    public List<Company> getCompanies(String stu_id){
        String sql = "";
        Statement st = null;
        ResultSet rs = null;
        List<Company> companies = new LinkedList<Company>();
        try{
            if(conn == null)
              conn = getConnection();
         sql = "SELECT cmp.* FROM user_education AS user, cmp_detail AS cmp "+
                  "WHERE user.xii_marks > cmp.xii_marks AND user.x_marks > cmp.x_marks "+
                    "AND user.stream = cmp.stream "+
                    "AND user.user_id ='"+stu_id+"' AND user.maths=true AND user.spec=cmp.spec";
         st = conn.createStatement();
         rs = st.executeQuery(sql);

                while(rs.next())
                {
                    Company cmp = new Company();
                    cmp.setCmp_id(rs.getString(2));
                    cmp.setCmp_name(rs.getString(3));
                    cmp.setCmp_url(rs.getString(4));
                    cmp.setCmp_detail(rs.getString(5));
                    cmp.setXii_marks(rs.getDouble(6));
                    cmp.setX_marks(rs.getDouble(7));
                    cmp.setInterview(rs.getDate(8));
                    cmp.setStream(rs.getString(9));
                    cmp.setJobProfile(rs.getString(10));
                    cmp.setSpec(rs.getString(11));
                  companies.add(cmp);
                }

        }
        catch(Exception e)
        {
        e.printStackTrace();
        return null;
        }
        return companies;
    }

    public void closeConnection(){
        try{
            System.out.print("close conn");
         if( conn != null)
         conn.close();
        }
        catch(Exception e){
        e.printStackTrace();
        }
    }

    public Boolean updateStudent(Student student){

        String sql = "";
        Statement st = null;
        ResultSet rs = null;
        List<Company> companies = new LinkedList<Company>();
        System.out.print("----dob----"+ (new Timestamp(student.getDob().getTime())).toString());
        try{
            if(conn == null)
              conn = getConnection();


         System.out.println("----update sql------");
         System.out.println(sql);

         sql = "Update user_education " +
                 "set stream=?, percentile=?, college=?, board=?, xii_marks=?, maths=?, " +
                 " xii_school=?, xii_board=?, x_marks=?, x_school=?, x_board=? where user_id=?";

             PreparedStatement pst1 = null;
            pst1 = conn.prepareStatement(sql);
              pst1 = conn.prepareStatement(sql);
              pst1.setString(1, student.getStream());
              pst1.setDouble(2, student.getPercentile());
              pst1.setString(3, student.getCollege());
              pst1.setString(4, student.getBoard());
              pst1.setDouble(5, student.getXii_marks());
              pst1.setBoolean(6, student.getMaths());
              pst1.setString(7, student.getXii_school());
              pst1.setString(8, student.getXii_board());
              pst1.setDouble(9, student.getX_marks());
              pst1.setString(10, student.getX_school());
              pst1.setString(11, student.getX_board());
              pst1.setString(12, student.getUserid());

               ParameterMetaData pm = pst1.getParameterMetaData();
                       System.out.print(pst1.getParameterMetaData());
               int i=pst1.executeUpdate();
               

         sql = "Update user_personal_detail " +
                 "set address=?, contact_1=?, contact_2=? , email_id=? where user_id=?";
             System.out.println("----update sql------");
         System.out.println(sql);

            pst1 = null;
            pst1 = conn.prepareStatement(sql);

          
                       pst1.setString(1, student.getAddress());
                       pst1.setString(2, student.getCont_1());
                       pst1.setString(3, student.getCont_2());
                       pst1.setString(4, student.getEmail_id());
                       pst1.setString(5, student.getUserid());
                      i=pst1.executeUpdate();
         
   }
        catch(Exception e){

            e.printStackTrace();

        }
       
        return true;

    }
  }