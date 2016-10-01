/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.placement.types;

/**
 *
 * @author arup
 */
public enum UserType {

    STUDENT("Student"),
    ADMIN("Admin");

    private String user;
    private UserType(String user) {
        this.user = user;
    }

    @Override
	public String toString() {
		return user;

    }

}
