import com.example.proyectosegundocortep3.logic.Activity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.ActivityDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet(name = "ServletSendActivity", value = "/add-activity")
public class ServletSendActivity extends HttpServlet{
    private ActivityDAO actDAO;

    @Override
    public void init() throws ServletException {
        actDAO = new ActivityDAO();
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

        Integer id = Integer.parseInt(request.getParameter("idactivity"));
        String activityType = request.getParameter("activityType");
        Double weighted = Double.parseDouble(request.getParameter("weighted"));
        String deadLine = request.getParameter("deadLine");
        //Convertimos la fecha que viene como un String ("2023-08-25") a un arreglo de String ([2023,8,23]), para
        //convertor los datos a valores numéricos y poder instanciar un LocalDate
        String[] aux = deadLine.split("-");
        int year = Integer.parseInt( aux[0]);
        int month = Integer.parseInt( aux[1]);
        int day = Integer.parseInt( aux[2]);
        LocalDate dl = LocalDate.of( year,month,day);
        Double score = Double.parseDouble(request.getParameter("score"));
        String state = request.getParameter("state");


        Activity activity = new Activity(id,activityType,weighted,dl,score,state);

        try(
                PrintWriter out = response.getWriter();
        ){
            if( actDAO.add( activity) ){
                out.println(gson.toJson(activity));
            }else{
                out.println(gson.toJson( null ));
            }
        }
    }

}
