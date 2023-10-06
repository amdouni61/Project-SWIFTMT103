package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.TagRecus;

@Repository
public interface TagRepositories extends JpaRepository<TagRecus, String> {

}
