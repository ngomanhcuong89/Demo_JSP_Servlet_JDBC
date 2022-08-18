package control;

import dao.DAO;
import entity.Account;
import entity.Category;
import entity.Product;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="ManagerProduct", urlPatterns="/managerproduct")
public class ControllerManagerProduct extends HttpServlet
{
    public void proccessRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            HttpSession session = request.getSession();
            Account acc = (Account)session.getAttribute("ACCOUNT");
            List<Product> product = new DAO().getProductBySid(acc.getId());
            List<Category> category = new DAO().getAllCategory();
            request.setAttribute("SHOWPRO", product);
            request.setAttribute("SHOWCATE", category);
            request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
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
