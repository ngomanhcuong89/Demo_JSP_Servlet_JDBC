package control;

import dao.DAO;
import entity.Category;
import entity.Product;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="SearchProduct", urlPatterns="/search")
public class ControllerSearch extends HttpServlet
{
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            request.setCharacterEncoding("UTF-8");
            String name = request.getParameter("txt");
            List<Category> category = new DAO().getAllCategory();
            Product pronew = new DAO().getOneProduct();
            List<Product> prosearch = new DAO().getProductByName(name);
            request.setAttribute("SHOWCATE", category);
            request.setAttribute("SHOWPRONEW", pronew);
            request.setAttribute("SHOWPRO", prosearch);
            request.setAttribute("SEARCHCONTENT", name);
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        processRequest(req, resp);
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        processRequest(req, resp);
    }
}
