package ru.leather.onlineshop.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user", schema = "onshope", catalog = "")
public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private Timestamp registered;
    private Byte enable;

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "registered")
    public Timestamp getRegistered() {
        return registered;
    }

    public void setRegistered(Timestamp registered) {
        this.registered = registered;
    }

    @Basic
    @Column(name = "enable")
    public Byte getEnable() {
        return enable;
    }

    public void setEnable(Byte enable) {
        this.enable = enable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (registered != null ? !registered.equals(that.registered) : that.registered != null) return false;
        if (enable != null ? !enable.equals(that.enable) : that.enable != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (registered != null ? registered.hashCode() : 0);
        result = 31 * result + (enable != null ? enable.hashCode() : 0);
        return result;
    }
}
