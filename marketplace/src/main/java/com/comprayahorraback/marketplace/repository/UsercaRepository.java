package com.comprayahorraback.marketplace.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comprayahorraback.marketplace.entity.Userca;

public interface UsercaRepository extends JpaRepository<Userca, Long>{

    Optional<Userca> findByEmail(String email);

}
