import com.example.proyectosegundocortep3.logic.Subject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.SubjectDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet(name = "ServletSendSubject", value = "/add-subject")
public class ServletSendSubject extends HttpServlet {
    private SubjectDAO sjDAO;

    @Override
    public void init() throws ServletException {
        sjDAO = new SubjectDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        Gson gson = new Gson();

        //Integer id = Integer.parseInt(request.getParameter("idsubject"));
        String name = request.getParameter("nameSubject");
        //int numActivities = request.getParameter("");
        //Double finalScore = Double.parseDouble(request.getParameter("finalScore"));

        Subject subject = new Subject( name);

        try(
                PrintWriter out = response.getWriter();
        ){
            if( sjDAO.add( subject) ){
                out.println(gson.toJson(subject));
            }else{
                out.println(gson.toJson( null ));
            }
        }
    }
}
