package com.liaa.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.liaa.entity.UserRegister;

@Repository
public interface UserRegisterRepo extends JpaRepository<UserRegister, Long> {
    // You can add custom queries if needed
}

