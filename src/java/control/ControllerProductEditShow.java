package control;

import dao.DAO;
import entity.Category;
import entity.Product;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductEditShow", urlPatterns = "/producteditshow")
public class ControllerProductEditShow extends HttpServlet {

    public void proccessRequest(HttpServletRequest request, HttpServletResponse response) 
    {
        try
        {
            int p_id = Integer.parseInt(request.getParameter("id"));
            Product product = new DAO().getProductById(p_id);
            List<Category> category = new DAO().getAllCategory();
            request.setAttribute("PRO", product);
            request.setAttribute("SHOWCATE", category);
            request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        proccessRequest(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        proccessRequest(req, resp);
    }
}
