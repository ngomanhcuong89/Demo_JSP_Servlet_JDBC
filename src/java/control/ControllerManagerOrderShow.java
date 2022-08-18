package control;

import dao.DAO;
import entity.Account;
import entity.OrderDetail;
import entity.OrderItem;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ManagerOrderShow", urlPatterns = "/managerordershow")
public class ControllerManagerOrderShow extends HttpServlet {

    public void proccessRequest(HttpServletRequest request, HttpServletResponse response) 
    {
        try
        {
            HttpSession session = request.getSession();
            List<OrderDetail> orderDetail = new DAO().getAllOrderDetailByUid(((Account) session.getAttribute("ACCOUNT")).getId());
            request.setAttribute("SHOW_ORDER_BY_CUST", orderDetail);
            request.setAttribute("UNLOCK", "open");
            int oid = Integer.parseInt(request.getParameter("oid"));
            OrderDetail orderDetailOid = new DAO().getOrderDetailById(oid);
            List<OrderItem> orderItem = new DAO().getOrderItemByOrderDetailId(oid);
            request.setAttribute("ORDERDETAIL", orderDetailOid);
            request.setAttribute("ORDERITEM", orderItem);
            request.setAttribute("OID", oid);
            request.getRequestDispatcher("ManagerOrder.jsp").forward(request, response);
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
