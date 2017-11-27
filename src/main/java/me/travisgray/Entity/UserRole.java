package me.travisgray.Entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ${TravisGray} on 11/26/2017.
 */
@Entity
public class UserRole {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique=true)
    private String role;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Collection<UserData> users;

    public UserRole() {
    }

    public UserRole(String role, Collection<UserData> users) {
        this.role = role;
        this.users = users;
    }


    public UserRole(String user) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Collection<UserData> getUsers() {
        return users;
    }

    public void setUsers(Collection<UserData> users) {
        this.users = users;
    }
}
