package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Recus;

@Repository
public interface RecuRepositorie extends JpaRepository<Recus, String> {

}
