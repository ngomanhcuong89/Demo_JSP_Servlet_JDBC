package control;

import dao.DAO;
import entity.Account;
import entity.OrderDetail;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="ManagerOrder", urlPatterns="/managerorder")
public class ControllerManagerOrder extends HttpServlet
{
    public void proccessRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            HttpSession session = request.getSession();
            List<OrderDetail> orderDetail = new DAO().getAllOrderDetailByUid( ((Account)session.getAttribute("ACCOUNT")).getId() );
            if(orderDetail.size() > 0)
            {
                request.setAttribute("SHOW_ORDER_BY_CUST", orderDetail);
                request.removeAttribute("UNLOCK");
            }
            else
            {
                request.removeAttribute("UNLOCK");
            }
            request.getRequestDispatcher("ManagerOrder.jsp").forward(request, response);

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
