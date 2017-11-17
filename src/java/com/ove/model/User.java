/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ove.model;
import java.util.*;

/**
 *
 * @author Muhaimenul Islam
 */
public class User {
    
    String USER_ID, NAME, DEPT, BATCH, PHONE, EMAIL, 
            DESIGNATION, PASSWORD, ADDRESS, CURRENT_JOB;
     public boolean check;
    
    public User(){
        
    }
    public User(String USER_ID, String NAME, String DEPT, String BATCH, String PHONE, String EMAIL, String DESIGNATION, String PASSWORD, String ADDRESS, String CURRENT_JOB) {
        this.USER_ID = USER_ID;
        this.NAME = NAME;
        this.DEPT = DEPT;
        this.BATCH = BATCH;
        this.PHONE = PHONE;
        this.EMAIL = EMAIL;
        this.DESIGNATION = DESIGNATION;
        this.PASSWORD = PASSWORD;
        this.ADDRESS = ADDRESS;
        this.CURRENT_JOB = CURRENT_JOB;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDEPT() {
        return DEPT;
    }

    public void setDEPT(String DEPT) {
        this.DEPT = DEPT;
    }

    public String getBATCH() {
        return BATCH;
    }

    public void setBATCH(String BATCH) {
        this.BATCH = BATCH;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getDESIGNATION() {
        return DESIGNATION;
    }

    public void setDESIGNATION(String DESIGNATION) {
        this.DESIGNATION = DESIGNATION;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getCURRENT_JOB() {
        return CURRENT_JOB;
    }

    public void setCURRENT_JOB(String CURRENT_JOB) {
        this.CURRENT_JOB = CURRENT_JOB;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
    
    
}
