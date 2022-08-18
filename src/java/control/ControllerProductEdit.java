package control;

import dao.DAO;
import entity.Account;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="ProductEdit", urlPatterns="/productedit")
public class ControllerProductEdit extends HttpServlet
{
    public void proccessRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            request.setCharacterEncoding("UTF-8");
            String p_name           = request.getParameter("name"); 
            String p_image          = request.getParameter("image"); 
            double p_price          = Double.parseDouble(request.getParameter("price")); 
            String p_title          = request.getParameter("title"); 
            String p_description    = request.getParameter("description"); 
            int c_id                = Integer.parseInt(request.getParameter("category")); 
            int p_id                = Integer.parseInt(request.getParameter("p_id"));

            new DAO().updateProduct(p_name, p_image, p_price, p_title, p_description, c_id, p_id);
            response.sendRedirect("managerproduct");
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
