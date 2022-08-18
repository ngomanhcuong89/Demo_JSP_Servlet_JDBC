package control;

import dao.DAO;
import entity.Account;
import entity.OrderDetail;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="MyAccount", urlPatterns="/myaccount")
public class ControllerMyAccount extends HttpServlet
{
    public void proccessRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            HttpSession session = request.getSession();
            Account acc = (Account)session.getAttribute("ACCOUNT");
            List<OrderDetail> orderDetail = new DAO().getAllOrderDetailByBuyerId(acc.getId());
            session.setAttribute("LISTMYORDER", orderDetail);
            request.getRequestDispatcher("MyAccount.jsp").forward(request, response);
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
