package com.example.tabel_master.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "masters")
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, message = "Guest name must be at least 2 letters")
    private String name;
    @Min(1)
    @Max(10)
    private Integer num_of_guest;
    @NotBlank
    private String note;
    @Column(updatable=false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm a")
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User waiter;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_tables",
            joinColumns = @JoinColumn(name = "table_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    public Master() {
    }

    public Master(Long id, String name, Integer num_of_guest, String note, Date createdAt, Date updatedAt, User waiter, List<User> users) {
        this.id = id;
        this.name = name;
        this.num_of_guest = num_of_guest;
        this.note = note;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.waiter = waiter;
        this.users = users;
    }

    public User getWaiter() {
        return waiter;
    }

    public void setWaiter(User waiter) {
        this.waiter = waiter;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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

    public Integer getNum_of_guest() {
        return num_of_guest;
    }

    public void setNum_of_guest(Integer num_of_guest) {
        this.num_of_guest = num_of_guest;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
