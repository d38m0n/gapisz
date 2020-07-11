package com.csbd.CSBD100.v.repository;

import com.csbd.CSBD100.v.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}

