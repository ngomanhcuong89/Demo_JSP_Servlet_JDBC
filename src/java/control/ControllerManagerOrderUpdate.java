package control;

import dao.DAO;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ManagerOrderUpdate", urlPatterns="/managerorderupdate")
public class ControllerManagerOrderUpdate extends HttpServlet
{
    public void proccessRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            response.setCharacterEncoding("UTF-8");         
            String action = request.getParameter("action");
            int orderId = Integer.parseInt(request.getParameter("orderid"));
            Date date = new Date();
            SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
            String day = formater.format(date);

            if(action.equals("CANCEL"))
            {
                new DAO().updateOrderDetailById(day, 2, orderId);
            }
            else if(action.equals("SUBMIT"))
            {
                new DAO().updateOrderDetailById(day, 1, orderId);
            }
            request.getRequestDispatcher("managerorder").forward(request, response);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        proccessRequest(req, resp);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        proccessRequest(req, resp);
    }
}
