package com.hr;

import java.io.Serializable;

public class Resume implements Serializable {
    private static final long serialVersionUID = 11;
    private Integer id;
    private String name;
    private String school;
    /**
     *
     * * 0：已申请
     * 1：简历通过
     * 2：笔试通过
     * 3：体检通过
     * 4：背调通过
     * 5：已签约
     * 6：已入职
     * 7: 简历已失效
     */
    private String status;
    public Resume(String stdName, String stdSchool, String stdStatus){
        this.name = stdName;
        this.status = stdStatus;
        this.school = stdSchool;
    }
    public Resume(String stdName){
        this.name = stdName;
    }
    public int getId(){ return this.id; }
    public String getName(){
        return this.name;
    }
    public String getSchool(){
        return this.school;
    }
    public String getStatus(){return this.status;}
    public void setName(String stdName){this.name = stdName;}
    public void setId(Integer stdId){this.id = stdId;}
    public void setSchool(String stdSchool){this.school = stdSchool;}
    public void setStatus(String stdStatus){this.status = stdStatus;}
}