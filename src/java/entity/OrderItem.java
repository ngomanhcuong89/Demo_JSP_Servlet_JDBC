package entity;

public class OrderItem 
{
    private int pid;
    private String pname;
    private double pricenow;
    private int quatity;
    
    public OrderItem(){}
    public OrderItem(int pid, double pricenow, int quatity)
    {
        this.pid = pid;
        this.pricenow = pricenow;
        this.quatity = quatity;
    }
    public OrderItem(int pid, String pname, double pricenow, int quatity)
    {
        this.pid = pid;
        this.pricenow = pricenow;
        this.quatity = quatity;
        this.pname = pname;
    }
    
    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setPricenow(double pricenow) {
        this.pricenow = pricenow;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
    
    public int getPid() {
        return pid;
    }

    public double getPricenow() {
        return pricenow;
    }

    public int getQuatity() {
        return quatity;
    }

    public String getPname() {
        return pname;
    }
}
