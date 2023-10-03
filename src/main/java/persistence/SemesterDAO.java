package persistence;

import com.example.proyectosegundocortep3.logic.Semester;
import com.example.proyectosegundocortep3.logic.Subject;

import java.sql.*;
import java.util.List;

public class SemesterDAO implements InterfaceDAO<Semester> {

    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://127.0.0.1:3306/bd_proycort2prog3?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "123456789";

    @Override
    public List<Semester> findAll() {
        return null;
    }

    @Override
    public Semester findById(Integer idFind) {
        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try(
                Connection connection = DriverManager.getConnection(URL, USER,PASSWORD);
                Statement statement = connection.createStatement();
        ){
            String query = "SELECT * FROM semester WHERE id='" + idFind + "'";
            ResultSet rs = statement.executeQuery( query );
            Semester semester = null;

            while (rs.next()){
                Integer id = rs.getInt("idsemester");
                Double finalScore = rs.getDouble("finalScore");

                semester = new Semester(id,finalScore);
            }

            return semester;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean add(Semester semester) {

        Double finalScore = semester.getFinalScore();

        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try(
                Connection connection = DriverManager.getConnection(URL, USER,PASSWORD);
                Statement statement = connection.createStatement();
        ){
            String query = "INSERT INTO semester VALUES('" + finalScore + "')";

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
    public Semester update(Semester object) {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
