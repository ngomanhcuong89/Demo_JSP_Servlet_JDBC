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

@WebServlet(name="ProductAdd", urlPatterns="/productadd")
public class ControllerProductAdd extends HttpServlet
{
    public void proccessRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            Account account = (Account)session.getAttribute("ACCOUNT");
            String p_name = request.getParameter("name");
            String p_image = request.getParameter("image");
            double p_price = Double.parseDouble(request.getParameter("price"));
            String p_title = request.getParameter("title");
            String p_description = request.getParameter("description");
            int    p_cid = Integer.parseInt(request.getParameter("category"));
            int    p_sid = account.getId();
            new DAO().addProduct(p_name, p_image, p_price, p_title, p_description, p_cid, p_sid);
            response.sendRedirect("managerproduct");
        }
        catch(Exception ex)
        {
            System.out.println("Error: "+ex.toString());
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
