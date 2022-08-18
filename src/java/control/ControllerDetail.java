package control;

import dao.DAO;
import entity.Category;
import entity.Product;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="detail", urlPatterns="/detail")
public class ControllerDetail extends HttpServlet
{
    public void proccessRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            List<Category> category = new DAO().getAllCategory();
            Product pronew = new DAO().getOneProduct();
            int id = Integer.parseInt(request.getParameter("id"));
            Product probyid = new DAO().getProductById(id);
            request.setAttribute("SHOWCATE", category);
            request.setAttribute("SHOWPRONEW", pronew);
            request.setAttribute("PROBYID", probyid);
            request.getRequestDispatcher("Detail.jsp").forward(request, response);
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
