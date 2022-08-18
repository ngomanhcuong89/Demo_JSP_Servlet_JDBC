package control;

import dao.DAO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Sign_up", urlPatterns="/signup")
public class ControllerSignup extends HttpServlet
{
    public void proccessRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            String user     = request.getParameter("user");
            String pass     = request.getParameter("pass");
            String repass   = request.getParameter("repass");
            if(pass.equals(repass))
            {
                if(new DAO().checkUserAccount(user) == null)
                {
                    new DAO().createAccount(user, pass);
                    request.setAttribute("THONGBAO", "Bạn đã tạo thành công tài khoản");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
                else
                {
                    request.setAttribute("THONGBAO", "Register: User đã có trong hệ thống. Vui lòng nhập user khác");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);                    
                }
            }
            else
            {
                request.setAttribute("THONGBAO", "Register: Mật khẩu xác nhận không trùng khớp");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
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
