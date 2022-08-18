package control;

import dao.DAO;
import entity.Account;
import entity.Product;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ManagerAccountView", urlPatterns="/manageraccountview")
public class ControllerManagerAccountView extends HttpServlet
{
    public void proccessRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            int id = Integer.parseInt(request.getParameter("id"));
            Account account = new DAO().getAccountById(id);
            List<Product> product = new DAO().getProductBySid(id);
            request.setAttribute("SHOWACC", account);
            request.setAttribute("SHOWPRO", product);
            request.getRequestDispatcher("ManagerAccountView.jsp").forward(request, response);
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
