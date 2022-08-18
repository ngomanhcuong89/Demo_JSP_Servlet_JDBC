package dto;

import entity.Product;
import java.util.HashMap;

public class CartBean extends HashMap
{
    
    public void addProductCart(Product product)
    {
        int code = product.getId();
        if(this.containsKey(code))
        {
            int quatityOld = ((ProductDTO)(this.get(code))).getQuatity();
            ((ProductDTO)(this.get(code))).setQuatity(quatityOld+1);
        }
        else
        {
            ProductDTO productdto = new ProductDTO(product);
            this.put(code, productdto);
        }
    }
    
}
