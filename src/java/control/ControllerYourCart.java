package control;

import dto.CartBean;
import dto.ProductDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="YourCart", urlPatterns="/yourcart")
public class ControllerYourCart extends HttpServlet
{
    public void proccessRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            HttpSession session = request.getSession();
            CartBean cart = (CartBean)session.getAttribute("CARTS");
            List<ProductDTO> product = new ArrayList<ProductDTO>();
            if(cart != null)
            {
                Set<Integer> keySet = cart.keySet();
                for(Integer key : keySet)
                {
                    product.add(new ProductDTO(((ProductDTO)cart.get(key)).getProduct(), (Integer)((ProductDTO)cart.get(key)).getQuatity() ));
                }
            }
            session.setAttribute("PRODTO", product);
            request.getRequestDispatcher("YourCart.jsp").forward(request, response);
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
