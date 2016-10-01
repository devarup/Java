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
public class Company {

    private String cmp_id;
    private String cmp_name;
    private String cmp_url;
    private String cmp_detail;
    private Double xii_marks;
    private Double x_marks;
    private String stream;
    private Date interview;
    private String jobProfile;
    private String spec;


    /**
     * @return the cmp_id
     */
    public String getCmp_id() {
        return cmp_id;
    }

    /**
     * @return the cmp_name
     */
    public String getCmp_name() {
        return cmp_name;
    }

    /**
     * @return the cmp_url
     */
    public String getCmp_url() {
        return cmp_url;
    }

    /**
     * @return the cmp_detail
     */
    public String getCmp_detail() {
        return cmp_detail;
    }

    /**
     * @param cmp_id the cmp_id to set
     */
    public void setCmp_id(String cmp_id) {
        this.cmp_id = cmp_id;
    }

    /**
     * @param cmp_name the cmp_name to set
     */
    public void setCmp_name(String cmp_name) {
        this.cmp_name = cmp_name;
    }

    /**
     * @param cmp_url the cmp_url to set
     */
    public void setCmp_url(String cmp_url) {
        this.cmp_url = cmp_url;
    }

    /**
     * @param cmp_detail the cmp_detail to set
     */
    public void setCmp_detail(String cmp_detail) {
        this.cmp_detail = cmp_detail;
    }

    /**
     * @return the xii_marks
     */
    public Double getXii_marks() {
        return xii_marks;
    }

    /**
     * @param xii_marks the xii_marks to set
     */
    public void setXii_marks(Double xii_marks) {
        this.xii_marks = xii_marks;
    }

    /**
     * @return the x_marks
     */
    public Double getX_marks() {
        return x_marks;
    }

    /**
     * @param x_marks the x_marks to set
     */
    public void setX_marks(Double x_marks) {
        this.x_marks = x_marks;
    }

    /**
     * @return the stream
     */
    public String getStream() {
        return stream;
    }

    /**
     * @param stream the stream to set
     */
    public void setStream(String stream) {
        this.stream = stream;
    }

    /**
     * @return the interview
     */
    public Date getInterview() {
        return interview;
    }

    /**
     * @param interview the interview to set
     */
    public void setInterview(Date interview) {
        this.interview = interview;
    }

    /**
     * @return the jobProfile
     */
    public String getJobProfile() {
        return jobProfile;
    }

    /**
     * @param jobProfile the jobProfile to set
     */
    public void setJobProfile(String jobProfile) {
        this.jobProfile = jobProfile;
    }

    /**
     * @return the spec
     */
    public String getSpec() {
        return spec;
    }

    /**
     * @param spec the spec to set
     */
    public void setSpec(String spec) {
        this.spec = spec;
    }


}
