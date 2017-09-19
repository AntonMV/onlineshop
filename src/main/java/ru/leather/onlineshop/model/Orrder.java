package ru.leather.onlineshop.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orrder", schema = "onshope", catalog = "")
public class Orrder {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "userId")
    private Integer userId;

    @Basic
    @Column(name = "productId")
    private Integer productId;

    @Basic
    @Column(name = "quantity")
    private Integer quantity;

    @Basic
    @Column(name = "purdate")
    private Timestamp purdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Timestamp getPurdate() {
        return purdate;
    }

    public void setPurdate(Timestamp purdate) {
        this.purdate = purdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orrder that = (Orrder) o;

        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (purdate != null ? !purdate.equals(that.purdate) : that.purdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (purdate != null ? purdate.hashCode() : 0);
        return result;
    }
}
