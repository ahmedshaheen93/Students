/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students.Student;

import control.ConnectionMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lts
 */
public class StudenDB {

    String selectAllStudents = "SELECT * FROM student";
    String selectStudentByID = "SELECT * FROM student WHERE student.id = ?";
//    String selectStudentByName = "SELECT * FROM student WHERE student.name = ?";
    String searchStudentByName = "SELECT * FROM student WHERE student.name LIKE '%' ? '%'";
    String selectStudentByCode = "SELECT * FROM student WHERE student.code = ?";
    String InsertStudent = "INSERT INTO `student` (`name`, `code`, `adress`, `phone`, `nots`) "
            + "VALUES ( ?, ?, ?, ?, ?);";
    String UpdateStudent = "UPDATE  `student` SET `name` = ? , `code` = ?, `adress` = ?, `phone` = ?, `nots` =? "
            + "WHERE student.id = ? ";
    String DelStudent = "DELETE FROM student WHERE student.id = ? ";

// 
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public StudenDB() {
        connection = ConnectionMySql.connection();
    }

    public ArrayList<Student> selectAllStudents() {
        ArrayList<Student> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(selectAllStudents);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setCode(resultSet.getString("code"));
                student.setAdress(resultSet.getString("adress"));
                student.setPhone(resultSet.getString("phone"));
                student.setNots(resultSet.getString("nots"));
                list.add(student);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Student selectStudentbyID(int id) {
//    ArrayList<Student> list = new ArrayList<>();
        Student student = new Student();
        try {
            preparedStatement = connection.prepareStatement(selectStudentByID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setCode(resultSet.getString("code"));
                student.setAdress(resultSet.getString("adress"));
                student.setPhone(resultSet.getString("phone"));
                student.setNots(resultSet.getString("nots"));

            }
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    public ArrayList<Student> SeachStudent(String Name) {
        ArrayList<Student> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(searchStudentByName);
            preparedStatement.setString(1, Name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setCode(resultSet.getString("code"));
                student.setAdress(resultSet.getString("adress"));
                student.setPhone(resultSet.getString("phone"));
                student.setNots(resultSet.getString("nots"));
                list.add(student);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Student selectStudentbycode(String code) {
//    ArrayList<Student> list = new ArrayList<>();
        Student student = new Student();
        try {
            preparedStatement = connection.prepareStatement(selectStudentByCode);
            preparedStatement.setString(1, code);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setCode(resultSet.getString("code"));
                student.setAdress(resultSet.getString("adress"));
                student.setPhone(resultSet.getString("phone"));
                student.setNots(resultSet.getString("nots"));

            }
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    public int insetStudent(String Name, String code, String Adress, String phone, String nots) {
        try {
            int coulmnCount = 0;
            int id = 0;
            preparedStatement = connection.prepareStatement(InsertStudent, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, Name);
            preparedStatement.setString(2, code);
            preparedStatement.setString(3, Adress);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, nots);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                coulmnCount = resultSet.getMetaData().getColumnCount();
                for (int i = 1; i <= coulmnCount; i++) {
                    id = Integer.valueOf(resultSet.getString(i));
                }

            }
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int UpdateStudent(int id,String Name, String code, String Adress, String phone, String nots) {
        try {

            preparedStatement = connection.prepareStatement(UpdateStudent);
            preparedStatement.setString(1, Name);
            preparedStatement.setString(2, code);
            preparedStatement.setString(3, Adress);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, nots);
            preparedStatement.setInt(6, id);
            int executeUpdate = preparedStatement.executeUpdate();
            return executeUpdate;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int delStudent(int id ){
        
        try {
            preparedStatement = connection.prepareStatement(DelStudent);
            preparedStatement.setInt(1, id);
            int executeUpdate = preparedStatement.executeUpdate();
            return executeUpdate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;}
}
