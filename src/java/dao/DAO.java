package dao;

import context.ConnectionDB;
import entity.Account;
import entity.Category;
import entity.OrderDetail;
import entity.OrderItem;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO 
{
    public int getProductIndexPage()
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String query = "select count(*) from product";
            PreparedStatement sttm = conn.prepareStatement(query);
            ResultSet rs = sttm.executeQuery();
            int index = 0;
            while(rs.next())
            {
                index += rs.getInt(1)/6;
                if(rs.getInt(1)%6 != 0 || rs.getInt(1)==0)
                {
                    index++;
                }
                return index;
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return -1;
    }
    public int getProductIndexPageByCid(int cid)
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String query = "select count(*) from Product where cid = ?";
            PreparedStatement sttm = conn.prepareStatement(query);
            sttm.setInt(1, cid);
            ResultSet rs = sttm.executeQuery();
            int indexPage = 0;
            while(rs.next())
            {
                indexPage += rs.getInt(1)/6;
                if(rs.getInt(1) % 6 != 0 || rs.getInt(1)==0)
                {
                    indexPage++;
                }
                return indexPage;
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return -1;
    }
    public List<Product> getAllProductFromIndexPage(int indexPage)
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String query = "select * from product order by product.id offset ? rows fetch next 6 rows only";
            PreparedStatement sttm = conn.prepareStatement(query);
            sttm.setInt(1, (indexPage*6)-6);
            ResultSet rs = sttm.executeQuery();
            List<Product> product = new ArrayList<Product>();
            while(rs.next())
            {
                product.add(new Product(
                                        rs.getInt(1),
                                        rs.getString(2),
                                        rs.getString(3),
                                        rs.getDouble(4),
                                        rs.getString(5),
                                        rs.getString(6)
                                        ));
            }
            return product;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    public List<Product> getAllProductFromIndexPageByCid(int cid, int indexPage)
    {      
        try
        {
            Connection conn = ConnectionDB.Connect();
            String query = "select * from Product where cid = ? order by id offset ? rows fetch next 6 rows only";
            PreparedStatement sttm = conn.prepareStatement(query);
            sttm.setInt(1, cid);
            sttm.setInt(2, (indexPage*6)-6);
            ResultSet rs = sttm.executeQuery();
            List<Product> product = new ArrayList<Product>();
            while(rs.next())
            {
                product.add(new Product(
                                        rs.getInt(1),
                                        rs.getString(2),
                                        rs.getString(3),
                                        rs.getDouble(4),
                                        rs.getString(5),
                                        rs.getString(6)
                                        ));
            }
            return product;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    /* Change: getAllProductFromIndexPage
    public List<Product> getAllProduct()
    {
        try
        {
            List<Product> product = new ArrayList<Product>();
            Connection conn = ConnectionDB.Connect();
            String sql = "select [id], [name], [image], [price], [title], [description] from Product";
            PreparedStatement sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while(rs.next())
            {
                Product pro = new Product();
                pro.setId(rs.getInt(1));
                pro.setName(rs.getString(2));
                pro.setImage(rs.getString(3));
                pro.setPrice(rs.getDouble(4));
                pro.setTitle(rs.getString(5));
                pro.setDescription(rs.getString(6));
                
                product.add(pro);
            }
            conn.close();
            return product;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    */
    public Product getOneProduct()
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String sql = "select TOP 1 * from Product order by id DESC";
            PreparedStatement sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            Product product = new Product();
            while(rs.next())
            {
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setImage(rs.getString(3));
                product.setPrice(rs.getDouble(4));
                product.setTitle(rs.getString(5));
                product.setDescription(rs.getString(6));                
            }
            return product;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }    
        return null;
    }
    /* Change: getAllProductFromIndexPageByCid
    public List<Product> getProductByCid(int cid)
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String query = "select * from Product where cid = ?";
            PreparedStatement sttm = conn.prepareStatement(query);
            sttm.setInt(1, cid);
            List<Product> product = new ArrayList<Product>();
            ResultSet rs = sttm.executeQuery();
            while(rs.next())
            {
                Product pro = new Product(
                                            rs.getInt(1),
                                            rs.getString(2),
                                            rs.getString(3),
                                            rs.getDouble(4),
                                            rs.getString(5),
                                            rs.getString(6)
                                         );
                product.add(pro);
            }
            return product;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    */
    public List<Product> getProductBySid(int sid)
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String sql = "select * from [Product] where [sellid] = ?";
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setInt(1, sid);
            ResultSet rs = sttm.executeQuery();
            List<Product> product = new ArrayList<Product>();
            while(rs.next())
            {
                Product pro = new Product(
                                         rs.getInt(1),
                                         rs.getString(2),
                                         rs.getString(3),
                                         rs.getDouble(4),
                                         rs.getString(5),
                                         rs.getString(6)
                                         );
                product.add(pro);
            }
            return product;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Product getProductById(int id)
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String query = "select * from Product where id = ?";
            PreparedStatement sttm = conn.prepareStatement(query);
            sttm.setInt(1, id);
            ResultSet rs = sttm.executeQuery();
            while(rs.next())
            {
                return new Product(
                                    rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getDouble(4),
                                    rs.getString(5),
                                    rs.getString(6)
                                   );
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Product> getProductByName(String name)
    {
        List<Product> product = new ArrayList<Product>();
        try
        {
            Connection conn = ConnectionDB.Connect();
            String sql = "select * from Product where name like ?";
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setString(1, "%"+name+"%");
            ResultSet rs = sttm.executeQuery();
            
            while(rs.next())
            {
                Product pro =  new Product(
                                            rs.getInt(1),
                                            rs.getString(2),
                                            rs.getString(3),
                                            rs.getDouble(4),
                                            rs.getString(5),
                                            rs.getString(6)
                                           );
                product.add(pro);
            }
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return product;
    }
    
    public void deleteProductById(int id)
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String sql = "delete [Product] where [id] = ?";
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setInt(1, id);
            sttm.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void addProduct(String name, String image, double price, String title, String description, int cid, int sid)
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String sql = "insert into [Product]([name],[image],[price],[title],[description],[cid],[sellid]) values(?,?,?,?,?,?,?)";
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setString(1, name);
            sttm.setString(2, image);
            sttm.setDouble(3, price);
            sttm.setString(4, title);
            sttm.setString(5, description);
            sttm.setInt(6, cid);
            sttm.setInt(7, sid);
            sttm.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void updateProduct(String p_name, String p_image, double p_price, String p_title, String p_description, int c_id, int p_id)
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String sql = "update [Product] set [name]=?, [image] = ?, [price] = ?, [title] = ?, [description] = ?, [cid] = ? where [id] = ?";
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setString(1, p_name);
            sttm.setString(2, p_image);
            sttm.setDouble(3, p_price);
            sttm.setString(4, p_title);
            sttm.setString(5, p_description);
            sttm.setInt   (6, c_id);
            sttm.setInt   (7, p_id);
            sttm.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public List<Category> getAllCategory()
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String sql = "select * from Category";
            PreparedStatement sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            List<Category> category = new ArrayList<Category>();
            while(rs.next())
            {
                category.add(new Category(rs.getInt(1),rs.getString(2)));
            }
            conn.close();
            return category;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Account checkLogin(String user, String pass)
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String sql = "select * from [Account] where [user]=? and [pass]=?";
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setString(1, user);
            sttm.setString(2, pass);
            ResultSet rs = sttm.executeQuery();
            while(rs.next())
            {
                return new Account(
                                    rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getInt(4),
                                    rs.getInt(5)
                                   );
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public void createAccount(String user, String pass)
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String sql = "insert into Account values(?,?,0,0)";
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setString(1, user);
            sttm.setString(2, pass);
            sttm.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public Account checkUserAccount(String user)
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String sql = "select * from [Account] where [user] = ?";
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setString(1, user);
            ResultSet rs = sttm.executeQuery();
            while(rs.next())
            {
                return new Account(
                                    rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getInt(4),
                                    rs.getInt(5)
                                   );
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Account> getAllAccount()
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String sql = "select * from [Account]";
            PreparedStatement sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            List<Account> account = new ArrayList<Account>();
            while(rs.next())
            {
                account.add(new Account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
            }
            return account;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Account getAccountById(int id)
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String sql = "select * from [Account] where [uid] = ?";
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setInt(1, id);
            ResultSet rs = sttm.executeQuery();
            while(rs.next())
            {
                return new Account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void updateAccountById(String pass, int issell, int id)
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String sql = "update [Account] set [pass] = ?, [issell] = ? where [uid] = ?";
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setString(1, pass);
            sttm.setInt(2, issell);
            sttm.setInt(3, id);
            sttm.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public int getOrderDetailId()
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String query = "select top 1.id from Orderdetail order by [id] DESC";
            PreparedStatement sttm = conn.prepareStatement(query);
            ResultSet rs = sttm.executeQuery();
            while(rs.next())
            {
                return rs.getInt(1);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return -1;
    }
    
    public void addOrderDetail(String orderDate, int uid)
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String sql = "insert into Orderdetail([orderdate],[uid],[orderstatus]) values(?,?,0)";
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setString(1, orderDate);
            sttm.setInt(2, uid);
            sttm.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public void addOrderItem(int oid, int pid, double price, int quatity)
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String sql = "insert into Orderitem([oid],[pid],[pricenow],[quatity]) values(?,?,?,?)";
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setInt(1, oid);
            sttm.setInt(2, pid);
            sttm.setDouble(3, price);
            sttm.setInt(4, quatity);
            sttm.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public List<OrderDetail> getAllOrderDetailByBuyerId(int uid)
    {      
        try
        {
            Connection conn = ConnectionDB.Connect();
            String sql = "select * from Orderdetail where uid = ?";
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setInt(1, uid);
            ResultSet rs = sttm.executeQuery();
            List<OrderDetail> orderDetail = new ArrayList<OrderDetail>();
            while(rs.next())
            {
                orderDetail.add(new OrderDetail(
                                                rs.getInt(1),
                                                rs.getString(2),
                                                rs.getInt(3),
                                                rs.getString(4),
                                                rs.getInt(5)
                                                ));
            }
            return orderDetail;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    public List<OrderDetail> getAllOrderDetailByUid(int uid)
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String sql = "select DISTINCT Orderdetail.* from Orderdetail inner join Orderitem on Orderdetail.id = Orderitem.oid inner join Product on Orderitem.pid = Product.id where Product.sellid = ?";
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setInt(1, uid);
            ResultSet rs = sttm.executeQuery();
            List<OrderDetail> orderDetail = new ArrayList<OrderDetail>();
            while(rs.next())
            {
                orderDetail.add(new OrderDetail(
                                                rs.getInt(1),
                                                rs.getString(2),
                                                rs.getInt(3),
                                                rs.getString(4),
                                                rs.getInt(5)
                                                ));
            }
            return orderDetail;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public OrderDetail getOrderDetailById(int id)
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String sql = "select * from Orderdetail where id = ?";
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setInt(1, id);
            ResultSet rs = sttm.executeQuery();

            while(rs.next())
            {
                return new OrderDetail(
                                        rs.getInt(1),
                                        rs.getString(2),
                                        rs.getInt(3),
                                        rs.getString(4),
                                        rs.getInt(5)
                                        );
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    public List<OrderItem> getOrderItemByOrderDetailId(int orderDetailId)
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String sql = "select Orderitem.pid, Product.name, Orderitem.pricenow, Orderitem.quatity from Orderitem inner join Orderdetail on Orderitem.oid = Orderdetail.id inner join Product on Orderitem.pid = Product.id where Orderdetail.id = ?";
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setInt(1, orderDetailId);
            ResultSet rs = sttm.executeQuery();
            List<OrderItem> listItem =  new ArrayList<OrderItem>();
            while(rs.next())
            {
                listItem.add(new OrderItem(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4)));
            }
            return listItem;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    public void updateOrderDetailById(String completedate, int status, int id)
    {
        try
        {
            Connection conn = ConnectionDB.Connect();
            String sql = "update Orderdetail set completedate = ?, orderstatus = ? where id = ?";
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setString(1, completedate);
            sttm.setInt(2, status);
            sttm.setInt(3, id);
            sttm.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
}
