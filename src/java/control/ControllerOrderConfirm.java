package control;

import dto.ProductDTO;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="OrderConfirm", urlPatterns="/orderconfirm")
public class ControllerOrderConfirm extends HttpServlet
{
    public void proccessRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            HttpSession session = request.getSession();
            List<ProductDTO> product = (List<ProductDTO>)session.getAttribute("PRODTO");
            if(product.size() == 0)
            {
                request.setAttribute("CARTEMPTY", "XIN LỖI !! HIỆN TẠI GIỎ HÀNG BẠN ĐANG TRỐNG, VUI LÒNG CHỌN SẢN PHẨM ĐỂ CÓ THỂ ĐẶT HÀNG");
                request.getRequestDispatcher("YourCart.jsp").forward(request, response);
            }
            else if(session.getAttribute("ACCOUNT") == null)
            {
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
            else
            {
                request.getRequestDispatcher("OrderConfirm.jsp").forward(request, response);
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
