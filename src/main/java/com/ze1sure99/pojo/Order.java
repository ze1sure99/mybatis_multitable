package com.ze1sure99.pojo;

public class Order {
    private Integer id;
    private String orderTime;
    private Double total;

    //表明该订单属于哪个用户
    private  User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Order{");
        sb.append("id=").append(id);
        sb.append(", orderTime='").append(orderTime).append('\'');
        sb.append(", total=").append(total);
        sb.append('}');
        return sb.toString();
    }
}
