package com.example.tabel_master.repositories;

import com.example.tabel_master.models.Master;
import com.example.tabel_master.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MasterRepository extends CrudRepository<Master, Long> {
    List<Master> findAll();

    List<Master> findMasterByWaiterAndCreatedAt(User waiter, Date createdAt);
}

