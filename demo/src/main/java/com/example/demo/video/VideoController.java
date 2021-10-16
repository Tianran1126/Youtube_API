package com.example.demo.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
@RestController  //makes this class to service rest endpoint
@RequestMapping(path="api/v1/video")
public class VideoController {
    //resource for our API
    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        //this will be automatiicaly intillzed videoService=new VideoService()
        this.videoService = videoService;
    }

    @GetMapping
    public List<Video> getVideos(){
        return videoService.getVideos();
    }

}
