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
public class Job {


    private String job_id;
    private String comp_id;
    private String profile;
    private String description;
    private String stream;
    private Date interview;

    /**
     * @return the job_id
     */
    public String getJob_id() {
        return job_id;
    }

    /**
     * @param job_id the job_id to set
     */
    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    /**
     * @return the comp_id
     */
    public String getComp_id() {
        return comp_id;
    }

    /**
     * @param comp_id the comp_id to set
     */
    public void setComp_id(String comp_id) {
        this.comp_id = comp_id;
    }

    /**
     * @return the profile
     */
    public String getProfile() {
        return profile;
    }

    /**
     * @param profile the profile to set
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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
     * @return the dob
     */
    public Date getInterview() {
        return interview;
    }

    /**
     * @param dob the dob to set
     */
    public void setInterview(Date interview) {
        this.interview = interview;
    }




}
