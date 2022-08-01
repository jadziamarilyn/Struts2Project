package com.facilio.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class contact {
//    public static void main(String args[]) throws IOException {
//        Properties p = new Properties();
//        OutputStream os = new FileOutputStream("db.properties");
//        p.setProperty("url","jdbc:mysql://localhost:3306/usercontact");
//        p.setProperty("uname","root");
//        p.setProperty("password","Jadseb@1329");
//        p.store(os,null);
//    }
private Integer personid;
    private String name;
    private String age;
    private String mobileno;
    private String mailid;

    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getMailid() {
        return mailid;
    }

    public void setMailid(String mail) {
        this.mailid = mailid;
    }
    public contact(Integer personid,String name, String age, String mobileno, String mailid){
        this.personid=personid;
        this.name = name;
        this.age = age;
        this.mobileno = mobileno;
        this.mailid = mailid;
    }
}
