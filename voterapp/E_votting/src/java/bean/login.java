/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Vector;

/**
 *
 * @author admin
 */
public class login {
    String user_id,adhar_no,name,address,dob,gender,fingerprint,region_code,status,unique_key;
    dbconnection.connection con=new dbconnection.connection();

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAdhar_no() {
        return adhar_no;
    }

    public void setAdhar_no(String adhar_no) {
        this.adhar_no = adhar_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getRegion_code() {
        return region_code;
    }

    public void setRegion_code(String region_code) {
        this.region_code = region_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUnique_key() {
        return unique_key;
    }

    public void setUnique_key(String unique_key) {
        this.unique_key = unique_key;
    }
    
     public int putData(int opt){
        return con.putData(generateQuery(opt));
    }
    
    public Vector getData(int opt){
        System.out.println("");
        return con.getData(generateQuery(opt));
    }
        
    private String generateQuery(int opt){
        if(opt==1){
            return "select * from register where adhar_no='"+getAdhar_no()+"'";
        }
        if(opt == 2){
            return "UPDATE `e-votting`.`register` SET `status` = '1' , `unique_key` = '"+getUnique_key()+"' WHERE `user_id` = '"+getUser_id()+"' ;";
        }
        
        if(opt ==3){
            return "SELECT * FROM `e-votting`.`register` WHERE adhar_no='"+getAdhar_no()+"' AND unique_key='"+getUnique_key()+"';";
        }
        return"";
    
}
}