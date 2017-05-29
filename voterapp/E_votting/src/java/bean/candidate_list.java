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
public class candidate_list {
    String candidate_id,candidate_name,party_name,region_code;
    dbconnection.connection con=new dbconnection.connection();

    public String getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(String candidate_id) {
        this.candidate_id = candidate_id;
    }

    public String getCandidate_name() {
        return candidate_name;
    }

    public void setCandidate_name(String candidate_name) {
        this.candidate_name = candidate_name;
    }

    public String getParty_name() {
        return party_name;
    }

    public void setParty_name(String party_name) {
        this.party_name = party_name;
    }

    public String getRegion_code() {
        return region_code;
    }

    public void setRegion_code(String region_code) {
        this.region_code = region_code;
    }
    
    public int putData(int opt){
        return con.putData(generateQuery(opt));
    }
    
    public Vector getData(int opt){
        System.out.println(generateQuery(opt));
        return con.getData(generateQuery(opt));
    }
        
    private String generateQuery(int opt){
                    String str="SELECT `candidate_id`,`candidate_name`,`party_name` FROM`candidate_list` WHERE `region_code`='"+getRegion_code()+"'";

        if(opt==1){
           // System.out.println(str);

            return str;
//                    
        }
        if(opt == 2){
            return "select distinct `region_code` from `candidate_list`;";
        }
        
        if(opt == 3){
            return "SELECT COUNT(`candidate_id`) FROM `e-votting`.`candidate_list` WHERE region_code='"+getRegion_code()+"';";
        }

        return"";
    
}
}
