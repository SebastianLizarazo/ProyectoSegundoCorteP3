package persistence;

import com.example.proyectosegundocortep3.logic.Activity;
import com.example.proyectosegundocortep3.logic.Semester;
import com.example.proyectosegundocortep3.logic.Subject;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ActivityDAO implements InterfaceDAO<Activity> {

    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://127.0.0.1:3306/bd_proycort2prog3?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "123456789";

    @Override
    public List<Activity> findAll() {
        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try (
                Connection connection = DriverManager.getConnection(URL, USER,PASSWORD);
                Statement statement = connection.createStatement();
        ){
            String query = "SELECT * FROM activity";
            ResultSet rs = statement.executeQuery( query );
            List<Activity> list = new ArrayList<>();

            while (rs.next()){
                Integer id = rs.getInt("idsubject");
                String activityType = rs.getString("activityType");
                Double weighted = rs.getDouble("weighted");
                Date aux = rs.getDate( "deadLine" );
                LocalDate deadLine = aux.toLocalDate();
                Double score = rs.getDouble("score");
                String state = rs.getString("state");

                int idSubject = rs.getInt("subject_idsubject");

                String searchSubjectQuery = "SELECT * FROM subject WHERE id='" + idSubject + "'";
                ResultSet rs2 = statement.executeQuery( searchSubjectQuery );

                String nameSubject = rs2.getString("name");
                Double finalScoreSubject = rs2.getDouble("finalScore");
                int idSemester = rs2.getInt("semester_idsemester");

                String searchSemesterQuery = "SELECT * FROM semester WHERE id='" + idSemester + "'";
                ResultSet rs3 = statement.executeQuery( searchSemesterQuery );
                Double semesterFinalScore = rs3.getDouble("finalScore");

                Semester semester =new Semester(idSemester,semesterFinalScore);

                Subject subject = new Subject(id,nameSubject,finalScoreSubject,semester);

                list.add( new Activity(id,activityType,weighted,deadLine,score,state,subject));
            }
            return list;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Activity findById(Integer idFind) {
        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try(
                Connection connection = DriverManager.getConnection(URL, USER,PASSWORD);
                Statement statement = connection.createStatement();
        ){
            String query = "SELECT * FROM activity WHERE id='" + idFind + "'";
            ResultSet rs = statement.executeQuery( query );
            Activity activity = null;

            while (rs.next()){
                Integer id = rs.getInt("idsubject");
                String activityType = rs.getString("activityType");
                Double weighted = rs.getDouble("weighted");
                Date aux = rs.getDate( "deadLine" );
                LocalDate deadLine = aux.toLocalDate();
                Double score = rs.getDouble("score");
                String state = rs.getString("state");

                int idSubject = rs.getInt("subject_idsubject");

                String searchSubjectQuery = "SELECT * FROM subject WHERE id='" + idSubject + "'";
                ResultSet rs2 = statement.executeQuery( searchSubjectQuery );

                String nameSubject = rs2.getString("name");
                Double finalScoreSubject = rs2.getDouble("finalScore");
                int idSemester = rs2.getInt("semester_idsemester");

                String searchSemesterQuery = "SELECT * FROM semester WHERE id='" + idSemester + "'";
                ResultSet rs3 = statement.executeQuery( searchSemesterQuery );
                Double semesterFinalScore = rs3.getDouble("finalScore");

                Semester semester =new Semester(idSemester,semesterFinalScore);

                Subject subject = new Subject(id,nameSubject,finalScoreSubject,semester);

                activity = new Activity(id,activityType,weighted,deadLine,score,state,subject);
            }

            return activity;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean add(Activity activity) {
        String activityType = activity.getActivityType();
        Double weighted = activity.getWeighted();
        LocalDate deadLine = activity.getDeadLine();
        Double score =activity.getScore();
        String state = activity.getState();
        Subject subject = activity.getSubject();

        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try(
                Connection connection = DriverManager.getConnection(URL, USER,PASSWORD);
                Statement statement = connection.createStatement();
        ){
            String query = "INSERT INTO activity VALUES('" + activityType  + "','" + weighted + "','" + deadLine + "','" +
                    score  + "','" + state + "','" + subject.getId() + "')";

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
    public Activity update(Activity object) {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
