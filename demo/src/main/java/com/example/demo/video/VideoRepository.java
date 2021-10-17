package com.example.demo.video;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// this is reponsible for data layer
@Repository
public interface VideoRepository extends JpaRepository<Video,Long> {

    // Return a null optioal if program can't find same name in the database
    @Query ("SELECT v FROM Video v WHERE v.name=?1")
    Optional<Video> findVideoByname(String name);


}
