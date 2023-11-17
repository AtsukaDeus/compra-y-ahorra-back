package com.comprayahorraback.marketplace.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comprayahorraback.marketplace.entity.Userca;

@Repository
public interface UsercaRepository extends JpaRepository<Userca, Long>{

    Optional<Userca> findByEmail(String email);

}
