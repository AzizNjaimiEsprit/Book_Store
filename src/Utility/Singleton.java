package Utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class Singleton implements Credentials {
    private static String host ="bl0ne6dzuxgeguzrjivj-mysql.services.clever-cloud.com";
    private static String dbname = "bl0ne6dzuxgeguzrjivj";
    private static String url = "jdbc:mysql://"+host+":3306/"+dbname;
    private static String user = "urtaylpqbf6raugc";
    private static String passwd = "DTon5jDCKqlCCdaqMsH4";
    private static String driver = "com.mysql.jdbc.Driver";
    private static String sgbd_name = "MySQL";

    private static Connection conn;
    static {
        if (conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, passwd);
                System.out.println("connection etablie avec succée to "+Singleton.sgbd_name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConn() {
        return conn;
    }

}
