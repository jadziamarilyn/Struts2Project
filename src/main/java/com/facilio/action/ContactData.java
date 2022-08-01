package com.facilio.action;
import com.opensymphony.xwork2.ActionSupport;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
public class ContactData extends ActionSupport {

    public void setName(String name) {this.name = name;}
    public void setAge(String age) {
        this.age = age;
    }
    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
    public void setMailid(String mailid) {
        this.mailid = mailid;
    }
    private String name;
    private String age;
    private String mobileno;
    private String mailid;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private String key;

    public List<contact> getLst() {
        return lst;
    }
    private List<contact> lst = new ArrayList<>();
    public String CreateContact() throws Exception {
        Properties p = new Properties();
        InputStream is = new FileInputStream("C:\\Users\\Hp\\IdeaProjects\\Struts2Project\\db.properties");
        p.load(is);
        String url = p.getProperty("url");
        String uname = p.getProperty("uname");
        String password = p.getProperty("password");
        String query = "INSERT INTO usercontact(name,age,mobileno,mailid) VALUES(?,?,?,?)";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, password);
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, name);
        st.setString(2, age);
        st.setString(3, mobileno);
        st.setString(4, mailid);
        st.executeUpdate();
        st.close();
        con.close();
        setStatus("Created Successfully");
        return SUCCESS;
    }
    public String ListContact() throws Exception {
        Properties p = new Properties();
        InputStream is = new FileInputStream("C:\\Users\\Hp\\IdeaProjects\\Struts2Project\\db.properties");
        p.load(is);
        String url = p.getProperty("url");
        String uname = p.getProperty("uname");
        String password = p.getProperty("password");
        String query = "SELECT * FROM usercontact";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, password);
        PreparedStatement st = con.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Integer personid = rs.getInt(1);
            String name = rs.getString(2);
            String age = rs.getString(3);
            String mobileno = rs.getString(4);
            String mailid = rs.getString(5);
            contact c = new contact(personid,name,age,mobileno,mailid);
            lst.add(c);
        }
        return "done";
}
    public String UpdateContact() throws Exception{
        Properties p = new Properties();
        InputStream is = new FileInputStream("C:\\Users\\Hp\\IdeaProjects\\Struts2Project\\db.properties");
        p.load(is);
        String url = p.getProperty("url");
        String uname = p.getProperty("uname");
        String password = p.getProperty("password");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, password);
        if  (!name.equals("")){
            String query="UPDATE usercontact SET name=? WHERE personid=?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1,name);
            st.setInt(2, Integer.parseInt(key));
            st.executeUpdate();
            st.close();
        }
        if  (!age.equals("")){
            String query="UPDATE usercontact SET age=? WHERE personid=?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1,age);
            st.setInt(2, Integer.parseInt(key));
            st.executeUpdate();
            st.close();
        }
        if  (!mobileno.equals("")){
            String query="UPDATE usercontact SET mobileno=? WHERE personid=?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1,mobileno);
            st.setInt(2, Integer.parseInt(key));
            st.executeUpdate();
            st.close();
        }
        if  (!mailid.equals("")){
            String query="UPDATE usercontact SET mailid=? WHERE personid=?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1,mailid);
            st.setInt(2, Integer.parseInt(key));
            st.executeUpdate();
            st.close();
        }
        con.close();
        setStatus("Updated Successfully");
        return"updated";
    }
    public String DeleteContact() throws Exception{
        Properties p = new Properties();
        InputStream is = new FileInputStream("C:\\Users\\Hp\\IdeaProjects\\Struts2Project\\db.properties");
        p.load(is);
        String url = p.getProperty("url");
        String uname = p.getProperty("uname");
        String password = p.getProperty("password");
        String query ="DELETE FROM usercontact WHERE personid=?";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, password);
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, Integer.parseInt(key));
        st.executeUpdate();
        st.close();
        con.close();
        setStatus("Deleted Successfully");
        return "delete";
    }
}
