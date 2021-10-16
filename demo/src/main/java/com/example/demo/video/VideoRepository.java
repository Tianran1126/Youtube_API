package com.example.demo.video;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// this is reponsible for data layer
@Repository
public interface VideoRepository extends JpaRepository<Video,Long> {

}
