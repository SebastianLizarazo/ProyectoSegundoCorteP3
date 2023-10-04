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
                Integer id = rs.getInt(1);
                String activityType = rs.getString(2);
                Double weighted = rs.getDouble(3);
                Date aux = rs.getDate( 4);
                LocalDate deadLine = aux.toLocalDate();
                Double score = rs.getDouble(5) ;
                String state = rs.getString(6);

                int idSubject = rs.getInt(7);

                list.add( new Activity(id,activityType,weighted,deadLine,score,state,idSubject));
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
                Integer id = rs.getInt(1);
                String activityType = rs.getString(2);
                Double weighted = rs.getDouble(3);
                Date aux = rs.getDate( 4);
                LocalDate deadLine = aux.toLocalDate();
                Double score = rs.getDouble(5);
                String state = rs.getString(6);

                int idSubject = rs.getInt(7);

                activity = new Activity(id,activityType,weighted,deadLine,score,state,idSubject);
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
        int idSubject = activity.getIdSubject();

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
                    score  + "','" + state + "','" + idSubject + "')";

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
