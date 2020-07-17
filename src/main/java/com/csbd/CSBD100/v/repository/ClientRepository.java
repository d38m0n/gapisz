package com.csbd.CSBD100.v.repository;

import com.csbd.CSBD100.v.model.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<ClientEntity,Long> {
}
