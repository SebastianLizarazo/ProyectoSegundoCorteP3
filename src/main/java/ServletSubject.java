import com.example.proyectosegundocortep3.logic.Subject;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.SubjectDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletSubject", value = "/servlet-subject")
public class ServletSubject extends HttpServlet {

    private SubjectDAO sjDAO;

    @Override
    public void init() throws ServletException {
        sjDAO = new SubjectDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        Gson gson = new Gson();

        List<Subject> subjects = sjDAO.findAll();


        PrintWriter out = response.getWriter();
        out.println( gson.toJson( subjects ));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
