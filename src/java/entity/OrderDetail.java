package entity;

import java.util.Date;
import java.util.List;

public class OrderDetail 
{
    private int id;
    private String orderDate;
    private int uid;
    private String completeDate;
    private int orderStatus;
    
    public OrderDetail(){}
    public OrderDetail(int id, String orderDate, int uid, String completeDate, int orderStatus)
    {
        this.id = id;
        this.orderDate = orderDate;
        this.uid = uid;
        this.completeDate = completeDate;
        this.orderStatus = orderStatus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public int getUid() {
        return uid;
    }

    public String getCompleteDate() {
        return completeDate;
    }

    public int getOrderStatus() {
        return orderStatus;
    }
}
