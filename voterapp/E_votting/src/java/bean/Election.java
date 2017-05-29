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
public class Election {
        dbconnection.connection con=new dbconnection.connection();
  String vote_id,candidate_id, region_code, unique_token;

    public String getVote_id() {
        return vote_id;
    }

    public void setVote_id(String vote_id) {
        this.vote_id = vote_id;
    }

    public String getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(String candidate_id) {
        this.candidate_id = candidate_id;
    }

    public String getRegion_code() {
        return region_code;
    }

    public void setRegion_code(String region_code) {
        this.region_code = region_code;
    }

    public String getUnique_token() {
        return unique_token;
    }

    public void setUnique_token(String unique_token) {
        this.unique_token = unique_token;
    }
  
       public int putData(int opt){
        return con.putData(generateQuery(opt));
    }
    
    public Vector getData(int opt){
        System.out.println(generateQuery(opt));
        return con.getData(generateQuery(opt));
    }
        
    private String generateQuery(int opt){
        if(opt==1){
            return "SELECT b.`candidate_id`, b.`region_code`, a.`password` FROM `key_tab` a RIGHT OUTER JOIN `election` b  ON a.`vote_id`= b.`vote_id` WHERE region_code='"+getRegion_code()+"';";
        }
        
        if(opt==2){
            return "SELECT b.*,a.`password` FROM `key_tab` a LEFT OUTER JOIN `election` b  ON a.`vote_id`= b.`vote_id`;";
        }
        return "";
    }
}
