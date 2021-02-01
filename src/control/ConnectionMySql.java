/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
//import org.apache.commons.lang3.SystemUtils;

/**
 *
 * @author lts
 */
public class ConnectionMySql {

    public Statement stmt;
    static String url = "jdbc:mysql://localhost/";
    static String db = "Students";
    static String driver = "com.mysql.jdbc.Driver";
    static String unicode = "?useUnicode=yes&characterEncoding=UTF-8";
    static Connection connection;

    /**
     *
     * @return
     */
    public static Connection connection() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //      Class.forName("oracle.jdbc.driver.OracleDriver");
//            System.out.println("Driver loaded");

            // Establish a connection
            connection = DriverManager.getConnection(url + db + unicode, "root", "root");
            System.out.println("new connection");
//            
//            System.out.println("done");
//            System.out.println("تم الاتصال");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "هناك خطأ في المكتبات اعد تثبيت البرنامج ثم حاول مره اخري"
                    + "\n اذا استمرت المشكله اتصل بنا", "خطأ", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            return null;

        } catch (SQLException e) {
            int showConfirmDialog = JOptionPane.showConfirmDialog(null, "خطأ فى الاتصال بقاعدة البيانات"
                    + "\n ربما كان الخطأ ناتجا عن عدم وجود نسخه من قاعدالبيانات مخرنه علي جهازك"
                    + "\n لاستعاده نسخه سابقه اضغط yes "
                    + "\n لانشاء قاعدة بيانات والبدأ من جديد  اضغط NO", "خطأ", JOptionPane.YES_NO_OPTION);
            e.printStackTrace();
//            if (showConfirmDialog == JOptionPane.YES_OPTION) {
//                makeRestore makeRestore = new makeRestore(null, true);
//                makeRestore.setVisible(true);
//
//            } else if (showConfirmDialog == JOptionPane.NO_OPTION) {
//                makeBackUp makeBackUp = new makeBackUp();
//
//                makeBackUp.Restoredbfromsql("action.sql");
//                System.exit(0);
//
//            } else {
//                System.exit(0);
//            }

        }
        return connection;

    }
//    public static Connection connectionmydb() {
//        try {
//            // Load the JDBC driver
//            Class.forName("com.mysql.jdbc.Driver");
//            //      Class.forName("oracle.jdbc.driver.OracleDriver");
////            System.out.println("Driver loaded");
//
//            // Establish a connection
//            connection = DriverManager.getConnection(url + "mydb" + unicode, "root", "root");
//            System.out.println("new connection");
////            
////            System.out.println("done");
////            System.out.println("تم الاتصال");
//        } catch (ClassNotFoundException ex) {
//            JOptionPane.showMessageDialog(null, "هناك خطأ في المكتبات اعد تثبيت البرنامج ثم حاول مره اخري"
//                    + "\n اذا استمرت المشكله اتصل بنا", "خطأ", JOptionPane.ERROR_MESSAGE);
//            ex.printStackTrace();
//            return null;
//
//        } catch (SQLException e) {
//            int showConfirmDialog = JOptionPane.showConfirmDialog(null, "خطأ فى الاتصال بقاعدة البيانات"
//                    + "\n ربما كان الخطأ ناتجا عن عدم وجود نسخه من قاعدالبيانات مخرنه علي جهازك"
//                    + "\n لاستعاده نسخه سابقه اضغط yes "
//                    + "\n لانشاء قاعدة بيانات والبدأ من جديد  اضغط NO", "خطأ", JOptionPane.YES_NO_OPTION);
//            e.printStackTrace();
//            if (showConfirmDialog == JOptionPane.YES_OPTION) {
//                makeRestore makeRestore = new makeRestore(null, true);
//                makeRestore.setVisible(true);
//
//            } else if (showConfirmDialog == JOptionPane.NO_OPTION) {
//                makeBackUp makeBackUp = new makeBackUp();
//
//                makeBackUp.Restoredbfromsql("ELDELTA.sql");
//                System.exit(0);
//
//            } else {
//                System.exit(0);
//            }
//
//        }
//        return connection;
//
//    }

    public static void closeConnection(ResultSet resultSet, PreparedStatement preparedStatement) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

            }

        }
    }

}
