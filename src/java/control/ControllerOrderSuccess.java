package control;

import dao.DAO;
import dto.ProductDTO;
import entity.Account;
import entity.OrderDetail;
import entity.OrderItem;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="OrderSuccess", urlPatterns="/ordersuccess")
public class ControllerOrderSuccess extends HttpServlet
{
    public void proccessRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            HttpSession session = request.getSession();
            /*Thêm Order new vào database OrderDetail và OrderItem*/
            Date date = new Date();
            SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
            String time = formater.format(date);
            new DAO().addOrderDetail(time, ((Account)(session.getAttribute("ACCOUNT"))).getId());
            int newid = new DAO().getOrderDetailId();
            List<ProductDTO> prodto = (List<ProductDTO>)session.getAttribute("PRODTO");
            for(int i=0; i<prodto.size(); i++)
            {
                new DAO().addOrderItem(newid, prodto.get(i).getProduct().getId(), prodto.get(i).getProduct().getPrice(), prodto.get(i).getQuatity());
            }
            session.removeAttribute("PRODTO");
            session.removeAttribute("CARTS");
            /*Lấy OrderDetail và OrderItem truyền sang trang OrderSuccess*/
            OrderDetail orderDetail = new DAO().getOrderDetailById(newid);
            List<OrderItem> orderItem = new DAO().getOrderItemByOrderDetailId(newid);
            request.setAttribute("ORDERDETAIL", orderDetail);
            request.setAttribute("ORDERITEM", orderItem);
            request.getRequestDispatcher("OrderSuccess.jsp").forward(request, response);
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
