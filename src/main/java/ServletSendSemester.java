import com.example.proyectosegundocortep3.logic.Semester;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.SemesterDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "ServletSendSemester", value = "/add-semester")
public class ServletSendSemester extends HttpServlet{
    private SemesterDAO smDAO;

    @Override
    public void init() throws ServletException {
        smDAO = new SemesterDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        Integer id = Integer.parseInt(request.getParameter("idsemester"));
        Double finalScore = Double.parseDouble(request.getParameter("finalScore"));
        Semester semester = new Semester( id, finalScore);

        try(
                PrintWriter out = response.getWriter();
        ){
            if( smDAO.add( semester) ){
                out.println(gson.toJson(semester));
            }else{
                out.println(gson.toJson( null ));
            }
        }
    }

}
