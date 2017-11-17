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
public class Blogs {
    
    String bId,uId,title,body,btime;

    public Blogs() {
    }

    
    public Blogs(String bId, String uId, String title, String body, String btime) {
        this.bId = bId;
        this.uId = uId;
        this.title = title;
        this.body = body;
        this.btime = btime;
    }

    
    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    public String getBtime() {
        return btime;
    }

    public void setBtime(String btime) {
        this.btime = btime;
    }
    
}
