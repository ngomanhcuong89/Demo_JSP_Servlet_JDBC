/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import entity.Account;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CuongPC
 */
@WebServlet(name="Login", urlPatterns="/login")
public class ControllerLogin extends HttpServlet
{
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            String username = request.getParameter("user");
            String password = request.getParameter("pass");
            Account account = new DAO().checkLogin(username, password);
            if(account != null)
            {
                HttpSession session = request.getSession();
                session.setAttribute("ACCOUNT", account);
                if(session.getAttribute("DANHDAUTRANG").equals("T1"))
                {
                    request.getRequestDispatcher("Home.jsp").forward(request, response);
                }
                else if(session.getAttribute("DANHDAUTRANG").equals("T2"))
                {
                    request.getRequestDispatcher("OrderConfirm.jsp").forward(request, response);
                }
            }
            else
            {
                request.setAttribute("THONGBAO", "Đăng Nhập Thất Bại !! Vui Lòng Kiểm Tra Lại");
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
        processRequest(req, resp);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        processRequest(req, resp);
    }
}
