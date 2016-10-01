/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.placement.app;

import java.util.Date;

/**
 *
 * @author arup
 */
public class JobSeeker {

    private String userid;
    private String password;
    private String f_name;
    private String l_name;
    private Date dob;
    private String gender;
    private String address;
    private String cont_1;
    private String cont_2;
    private String email_id;
    private Boolean isShortlisted;

    /**
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the f_name
     */
    public String getF_name() {
        return f_name;
    }

    /**
     * @param f_name the f_name to set
     */
    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    /**
     * @return the l_name
     */
    public String getL_name() {
        return l_name;
    }

    /**
     * @param l_name the l_name to set
     */
    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the cont_1
     */
    public String getCont_1() {
        return cont_1;
    }

    /**
     * @param cont_1 the cont_1 to set
     */
    public void setCont_1(String cont_1) {
        this.cont_1 = cont_1;
    }

    /**
     * @return the cont_2
     */
    public String getCont_2() {
        return cont_2;
    }

    /**
     * @param cont_2 the cont_2 to set
     */
    public void setCont_2(String cont_2) {
        this.cont_2 = cont_2;
    }

    /**
     * @return the email_id
     */
    public String getEmail_id() {
        return email_id;
    }

    /**
     * @param email_id the email_id to set
     */
    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    /**
     * @return the isShortlisted
     */
    public Boolean getIsShortlisted() {
        return isShortlisted;
    }

    /**
     * @param isShortlisted the isShortlisted to set
     */
    public void setIsShortlisted(Boolean isShortlisted) {
        this.isShortlisted = isShortlisted;
    }
}
