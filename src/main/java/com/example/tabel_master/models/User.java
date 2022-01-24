package com.example.tabel_master.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @Email(message="Email must be valid")
    private String email;
    @Size(min = 8, message = "Must be greater or equal to 8 characters!")
    private String password;
    @Transient
    private String confirmPassword;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    @OneToMany(mappedBy="waiter", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Master> table;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_tables",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "table_id"))
    private List<Master> masterList;


    public User() {
    }

    public User(Long id, String name, String email, String password, String confirmPassword, Date createdAt, Date updatedAt, List<Master> table, List<Master> masterList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.table = table;
        this.masterList = masterList;
    }

    public List<Master> getTable() {
        return table;
    }

    public void setTable(List<Master> table) {
        this.table = table;
    }

    public List<Master> getMasterList() {
        return masterList;
    }

    public void setMasterList(List<Master> masterList) {
        this.masterList = masterList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
