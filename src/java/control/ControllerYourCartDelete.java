package control;

import dto.CartBean;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="CartDelete", urlPatterns="/cartdelete")
public class ControllerYourCartDelete extends HttpServlet
{
    public void proccessRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            HttpSession session = request.getSession();
            CartBean cart = (CartBean)session.getAttribute("CARTS");
            int pid = Integer.parseInt(request.getParameter("id"));
            cart.remove(pid);
            session.setAttribute("CARTS", cart);
            request.getRequestDispatcher("yourcart").forward(request, response);
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
