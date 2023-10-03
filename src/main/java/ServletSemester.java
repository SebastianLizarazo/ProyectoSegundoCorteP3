import com.example.proyectosegundocortep3.logic.Semester;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.SemesterDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletSemester", value = "/servlet-semester")
public class ServletSemester extends HttpServlet {

    private SemesterDAO smDAO;

    @Override
    public void init() throws ServletException {
        smDAO = new SemesterDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        Gson gson = new Gson();

        List<Semester> semesters = smDAO.findAll();


        PrintWriter out = response.getWriter();
        out.println( gson.toJson( semesters ));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
