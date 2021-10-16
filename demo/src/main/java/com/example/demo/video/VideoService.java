package com.example.demo.video;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service
public class VideoService
{


    @GetMapping
    public List<Video> getVideos(){
        return List.of(new Video(1L,"Prank", LocalDate.of(2000, Month.DECEMBER,26),5));
    }
}
