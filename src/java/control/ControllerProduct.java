/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import entity.Category;
import entity.Product;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CuongPC
 */
@WebServlet(name = "product", urlPatterns = "/showproduct")
public class ControllerProduct extends HttpServlet
{
    public void proccessRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try 
        {
            DAO dao = new DAO();
            int totalIndexPage = new DAO().getProductIndexPage();
            String indexPageS = request.getParameter("indexpage");
            int indexPage;
            if(indexPageS == null)
            {
                indexPage = 1;
            }
            else
            {
                indexPage = Integer.parseInt(indexPageS);
            }
            
            List<Product> product = dao.getAllProductFromIndexPage(indexPage);
            List<Category> category = dao.getAllCategory();
            Product pronew = dao.getOneProduct();
            request.removeAttribute("ISCATEPRO");
            request.setAttribute("TOTALINDEXPAGE", totalIndexPage);
            request.setAttribute("INDEXPAGE", indexPage);
            request.setAttribute("SHOWPRO", product);
            request.setAttribute("SHOWCATE", category);
            request.setAttribute("SHOWPRONEW", pronew);
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ControllerProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControllerProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proccessRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proccessRequest(req,resp);
    }
    
}
