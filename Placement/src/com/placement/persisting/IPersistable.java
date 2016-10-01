/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.placement.persisting;

import com.placement.app.Company;
import com.placement.app.Job;
import com.placement.app.JobSeeker;
import com.placement.app.Student;
import java.util.List;

/**
 *
 * @author arup
 */
public interface IPersistable {

    /**
     * Save student detail
     * @param jb
     * @return
     */
    public Boolean saveStudent(Student jb) ;

    /**
     * Get User Role;
     *
     * @param user_id
     * @param password
     * @return
     */
    public String getUserRole(String user_id, String password);

    /**
     * Save company's detail
     * @param company
     * @return
     */
    public Boolean saveCompany(Company company);

    /**
     * Get list of company
     * @return
     */
    public List<Company> getCompany();

    /**
     * Get a company detail
     * @param company
     * @return
     */
    public Company getCompany(String company);

    /**
     *
     * Get jobs of a company;
     * @param com_id
     * @return
     */
    public List<Job> getJobs(String com_id);
/**
 *
 * @param job
 * @return
 */
    public Boolean saveJobs(Job job);
/**
 *
 * @return
 */
    public String getJobID();

   /**
    *
    * @param filter
    * @return
    */ public List<Student> getStudents(String filter);
/**
 * 
 * @param stu_id
 * @return
 */
    public Student getEduDetail(String stu_id);

    public List<Student> filterStudent(Double xii_marks,Double x_marks);

     public Student getStudentPersonal(String id);

     public List<Student> studentList(String filter);

     public Student getStudentDetail(String id);

     public List<Company> getCompanies(String stu_id);

     public Boolean updateStudent(Student student);
}
