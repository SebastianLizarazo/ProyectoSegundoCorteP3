import com.example.proyectosegundocortep3.logic.Activity;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.ActivityDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletActivity", value = "/servlet-activity")
public class ServletActivity extends HttpServlet {
    private ActivityDAO actDAO;

    @Override
    public void init() throws ServletException {
        actDAO = new ActivityDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        Gson gson = new Gson();

        List<Activity> activities = actDAO.findAll();


        PrintWriter out = response.getWriter();
        out.println( gson.toJson( activities ));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
