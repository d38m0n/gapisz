package com.csbd.CSBD100.v.repository;

import com.csbd.CSBD100.v.model.entity.CustomerDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDateRepository extends JpaRepository<CustomerDataEntity, Long> {
}
