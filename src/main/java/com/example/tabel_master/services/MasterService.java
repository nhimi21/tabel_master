package com.example.tabel_master.services;

import com.example.tabel_master.models.Master;
import com.example.tabel_master.models.User;
import com.example.tabel_master.repositories.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MasterService {
    @Autowired
    private MasterRepository masterRepository;

    public List<Master> findAllTable(){
        return this.masterRepository.findAll();
    }

    public List<Master> findOnlyWaiter(User waiter , Date createdAt){
        return this.masterRepository.findMasterByWaiterAndCreatedAt(waiter, createdAt);
    }
    public void createAnEditTable(Master master){
        this.masterRepository.save(master);
    }

    public Master findTableById(Long id){
        return this.masterRepository.findById(id).orElse(null);
    }

    public void deleteTable(Long id) {
        boolean exists = masterRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Table with id" + id + "does not exists");
        }
        this.masterRepository.deleteById(id);
    }
    public void addTable(User user, Master master){
        List<User> userList = master.getUsers();
        userList.add(user);
        this.masterRepository.save(master);
    }
    public void removeTable(User user, Master master){
        List<User> userList = master.getUsers();
        userList.remove(user);
        this.masterRepository.save(master);
    }
}
