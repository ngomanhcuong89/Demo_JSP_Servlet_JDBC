package control;

import dao.DAO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ManagerAccountEdit", urlPatterns="/manageraccountedit")
public class ControllerManagerAccountEdit extends HttpServlet
{
    public void proccessRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            int id = Integer.parseInt(request.getParameter("id"));
            String pass = request.getParameter("pass");
            int issell = Integer.parseInt(request.getParameter("issellradio"));

            new DAO().updateAccountById(pass, issell, id);

            request.getRequestDispatcher("manageraccount").forward(request, response);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        proccessRequest(req,resp);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        proccessRequest(req,resp);
    }
}
