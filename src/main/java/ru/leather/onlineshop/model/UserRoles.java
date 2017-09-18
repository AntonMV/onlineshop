package ru.leather.onlineshop.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_roles", schema = "onshope", catalog = "")
public class UserRoles {
    private int roleId;
    private int userId;
    private String role;
    private Set<UserRoles> userRoles;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @ManyToMany(mappedBy = "userRoles")
    public Set<UserRoles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRoles> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoles userRoles = (UserRoles) o;

        if (roleId != userRoles.roleId) return false;
        if (userId != userRoles.userId) return false;
        if (role != null ? !role.equals(userRoles.role) : userRoles.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + userId;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

}
