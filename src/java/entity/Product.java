package entity;

public class Product 
{
    private int id;
    private String name;
    private String image;
    private double price;
    private String title;
    private String description;
    
    public Product(){}
    public Product(int id, String name, String image, double price, String title, String description)
    {
        this.id          = id;
        this.name        = name;
        this.image       = image;
        this.price       = price;
        this.title       = title;
        this.description = description;
    }
    /* Getter */
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    /* Setter */

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
