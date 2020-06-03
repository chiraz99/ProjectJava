package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;



public class Singleton {

	
	        private static String url  = "jdbc:mysql://localhost:3306/car";
	        private static String user = "root";
	        private static String passwd = "houssemeleuch11";

	    public static Connection getConn() {
	    	   try{
	    		   //chargement de driver
	    	        Class.forName("com.mysql.jdbc.Driver");
	    	        return DriverManager.getConnection(url, user, passwd);
	    	    }catch(Exception ex){
	    	        System.out.println(ex.getMessage());
	    	        System.out.println("couldn't connect!");
	    	        // ca sert pour ouvrir et fermer la connection a chaque fois
	    	        throw new RuntimeException(ex);
	    	    }
         }
}
	


