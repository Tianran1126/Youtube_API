package com.example.demo.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class VideoService
{

private  final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @GetMapping
    public List<Video> getVideos(){
       return videoRepository.findAll();
    }

    public void addVideo(Video video) {
        Optional <Video> videoOptional=videoRepository.findVideoByname(video.getName());
        if(videoOptional.isPresent()){
            throw new IllegalStateException("name taken");
        }
        videoRepository.save(video);
    }
}
