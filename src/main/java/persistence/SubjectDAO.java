package persistence;

import com.example.proyectosegundocortep3.logic.Semester;
import com.example.proyectosegundocortep3.logic.Subject;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO implements InterfaceDAO<Subject> {

    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://127.0.0.1:3306/bd_proycort2prog3?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "123456789";

    @Override
    public List<Subject> findAll() {
        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try (
                Connection connection = DriverManager.getConnection(URL, USER,PASSWORD);
                Statement statement = connection.createStatement();
        ){
            String query = "SELECT * FROM subject";
            ResultSet rs = statement.executeQuery( query );
            List<Subject> list = new ArrayList<>();

            while (rs.next()){
                Integer id = rs.getInt("idsubject");
                String name = rs.getString("name");
                Double finalScore = rs.getDouble("finalScore");
                int idSemester = rs.getInt("semester_idsemester");

                String searchSemesterQuery = "SELECT * FROM semester WHERE id='" + idSemester + "'";
                ResultSet rs2 = statement.executeQuery( searchSemesterQuery );
                Double semesterFinalScore = rs2.getDouble("finalScore");

                Semester semester =new Semester(idSemester,semesterFinalScore);

                list.add( new Subject(id,name,finalScore,semester));
            }
            return list;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Subject findById(Integer idFind) {
        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try(
                Connection connection = DriverManager.getConnection(URL, USER,PASSWORD);
                Statement statement = connection.createStatement();
        ){
            String query = "SELECT * FROM subject WHERE id='" + idFind + "'";
            ResultSet rs = statement.executeQuery( query );
            Subject subject = null;

            while (rs.next()){
                Integer id = rs.getInt("idsubject");
                String name = rs.getString("name");
                Double finalScore = rs.getDouble("finalScore");
                int idSemester = rs.getInt("semester_idsemester");

                String searchSemesterQuery = "SELECT * FROM semester WHERE id='" + idSemester + "'";
                ResultSet rs2 = statement.executeQuery( searchSemesterQuery );
                Double semesterFinalScore = rs2.getDouble("finalScore");

                Semester semester =new Semester(idSemester,semesterFinalScore);

                subject = new Subject(id,name,finalScore,semester);
            }

            return subject;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean add(Subject subject) {

        String name = subject.getName();

        Double finalScore = subject.getFinalScore();

        int semesterIdSemester = 1;

        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try(
                Connection connection = DriverManager.getConnection(URL, USER,PASSWORD);
                Statement statement = connection.createStatement();
        ){
            String query = "INSERT INTO subject VALUES('" + name  + "','" + finalScore + "','" + semesterIdSemester + "')";

            int rows = statement.executeUpdate( query );

            return rows > 0 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Subject update(Subject object) {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
