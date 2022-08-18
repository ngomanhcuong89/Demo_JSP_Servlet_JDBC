package dto;

import entity.Product;
import java.io.Serializable;

public class ProductDTO implements Serializable
{
    private Product product;
    private int quatity;
    
    public ProductDTO(){}
    public ProductDTO(Product product)
    {
        this.product = product;
        this.quatity = 1;
    }
    public ProductDTO(Product product, int quatity)
    {
        this.product = product;
        this.quatity = quatity;
    }    
    
    public void setProduct(Product product)
    {
        this.product = product;
    }
    public Product getProduct()
    {
        return this.product;
    }
    
    public void setQuatity(int quatity)
    {
        this.quatity = quatity;
    }
    public int getQuatity()
    {
        return this.quatity;
    }
}
