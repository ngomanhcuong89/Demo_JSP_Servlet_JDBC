package control;

import dao.DAO;
import entity.Account;
import entity.Product;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="ProductDelete", urlPatterns="/productdelete")
public class ControllerProductDelete extends HttpServlet
{
    public void proccessRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            HttpSession session = request.getSession();
            int id = Integer.parseInt(request.getParameter("id"));
            new DAO().deleteProductById(id);
            
            Account account = (Account)session.getAttribute("ACCOUNT");
            List<Product> product = new DAO().getProductBySid(account.getId());
            request.setAttribute("SHOWPRO", product);
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
        proccessRequest(req,resp);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        proccessRequest(req,resp);
    }
}
