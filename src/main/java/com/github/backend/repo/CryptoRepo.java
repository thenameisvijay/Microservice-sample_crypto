package com.github.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.backend.entity.CryptoEntity;

public interface CryptoRepo extends JpaRepository<CryptoEntity, Long> {

}
