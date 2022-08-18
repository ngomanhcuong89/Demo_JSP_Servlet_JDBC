package control;

import dao.DAO;
import dto.CartBean;
import entity.Category;
import entity.Product;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="AddToCart", urlPatterns="/addtocart")
public class ControllerAddToCart extends HttpServlet
{
    public void proccessRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            HttpSession session = request.getSession();
            CartBean cart = (CartBean)session.getAttribute("CARTS");
            int id = Integer.parseInt(request.getParameter("id"));
            Product productcart = new DAO().getProductById(id);
            if(cart == null)
            {
                cart = new CartBean();
            }
            cart.addProductCart(productcart);
            session.setAttribute("CARTS", cart);

            if(request.getParameter("cid").length()>0)
            {
                request.getRequestDispatcher("category?cid="+request.getParameter("cid")).forward(request, response);
            }
            else
            {
                request.getRequestDispatcher("showproduct").forward(request, response);
            }
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
