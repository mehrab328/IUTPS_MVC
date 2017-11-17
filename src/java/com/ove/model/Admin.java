/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ove.model;

/**
 *
 * @author Muhaimenul Islam
 */
public class Admin {
    String ADMIN_ID, ADMIN_PASS;
      public boolean valid;

    public String getADMIN_ID() {
        return ADMIN_ID;
    }

    public void setADMIN_ID(String ADMIN_ID) {
        this.ADMIN_ID = ADMIN_ID;
    }

    public String getADMIN_PASS() {
        return ADMIN_PASS;
    }

    public void setADMIN_PASS(String ADMIN_PASS) {
        this.ADMIN_PASS = ADMIN_PASS;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
    
    
}
