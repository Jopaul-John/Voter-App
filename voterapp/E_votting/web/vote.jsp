<%@page import="java.util.Iterator"%>
<%@page import="utility.AESCrypto"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Random"%>

<%  String user_id=request.getParameter("user_id").trim();
    dbconnection.connection con=new dbconnection.connection();
    Iterator sel= con.getData("SELECT * FROM `e-votting`.`register` WHERE `user_id`='"+user_id+"' AND `status`='0';").iterator();
    if(sel.hasNext()){
    String key=AESCrypto.getRandomHexString(32);
    String regcode=request.getParameter("region_code");
    String cid=AESCrypto.encrypt(request.getParameter("cid").trim(), key);
    Random ran=new Random();
    int rand=ran.nextInt(9999);
    String str="INSERT INTO `election`(`candidate_id`,`region_code`,`unique_token`)values('"+cid+"','"+regcode+"','"+AESCrypto.encrypt(""+rand,key)+"')";
    String str1="UPDATE `e-votting`.`register` SET `status` = '1',`unique_key` = '"+rand+"' WHERE `user_id` = '"+user_id+"';";
    System.out.println(str);
    System.out.println(str1);
    
   if(con.putData(str)>0){
         if(con.putData(str1)>0){
              String str2="SELECT MAX(`vote_id`) FROM `e-votting`.`election`;";
            Iterator it=con.getData(str2).iterator();
            System.out.println(str2);
            it.next();
            Vector v=(Vector)it.next();
            String str3="INSERT INTO `e-votting`.`key_tab` (`vote_id`, `password`) VALUES('"+v.get(0).toString() +"', '"+key+"') ;";
            if(con.putData(str3)>0){
            System.out.println(str3);
            out.print(rand);
            }else{
               out.print("failed"); 
            }
   }else{
               out.print("failed"); 
            } 
   }else{
               out.print("failed"); 
            }
    
    }else{
        out.print("failed");
    }






%>