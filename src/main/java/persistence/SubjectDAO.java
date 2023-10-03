package persistence;

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
                Integer id = rs.getInt("idSubject");
                String name = rs.getString("name");
                Double finalScore = rs.getDouble("finalScore");


                list.add( new Subject(id,name,finalScore));
            }
            return list;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Subject findById(Integer id) {
        return null;
    }

    @Override
    public boolean add(Subject object) {
        return false;
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
