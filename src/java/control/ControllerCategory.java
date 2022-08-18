/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import entity.Category;
import entity.Product;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CuongPC
 */
@WebServlet(name="category", urlPatterns="/category")
public class ControllerCategory extends HttpServlet
{
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            if(request.getParameter("indexpage") == null)
            {
                int cid = Integer.parseInt(request.getParameter("cid"));
                List<Category> category = new DAO().getAllCategory();
                Product pro = new DAO().getOneProduct();
//                List<Product> product = new DAO().getProductByCid(cid);
                int totalIndexPage = new DAO().getProductIndexPageByCid(cid);
                List<Product> product = new DAO().getAllProductFromIndexPageByCid(cid, 1);
                
                request.setAttribute("TOTALINDEXPAGE", totalIndexPage);
                request.setAttribute("INDEXPAGE", 1);
                request.setAttribute("ISCATEPRO", "catepro");
                request.setAttribute("TAGCID", cid);
                request.setAttribute("SHOWCATE", category);
                request.setAttribute("SHOWPRONEW", pro);
                request.setAttribute("SHOWPRO", product);            
            }
            else if(request.getParameter("indexpage") != null)
            {
                int cid = Integer.parseInt(request.getParameter("cid"));
                int indexPage = Integer.parseInt(request.getParameter("indexpage"));
                List<Category> category = new DAO().getAllCategory();
                Product pro = new DAO().getOneProduct();
                int totalIndexPage = new DAO().getProductIndexPageByCid(cid);
                List<Product> product = new DAO().getAllProductFromIndexPageByCid(cid, indexPage);
                
                request.setAttribute("TOTALINDEXPAGE", totalIndexPage);
                request.setAttribute("INDEXPAGE", indexPage);                
                request.setAttribute("ISCATEPRO", "catepro");
                request.setAttribute("TAGCID", cid);
                request.setAttribute("SHOWCATE", category);
                request.setAttribute("SHOWPRONEW", pro);
                request.setAttribute("SHOWPRO", product);                  
            }

            request.getRequestDispatcher("Home.jsp").forward(request, response);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        processRequest(req,resp);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        processRequest(req,resp);
    }
}
