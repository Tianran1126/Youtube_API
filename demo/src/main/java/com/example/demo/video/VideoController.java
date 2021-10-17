package com.example.demo.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping
    public void registernewVideo(@RequestBody Video video){
        videoService.addVideo(video);
    }

    @DeleteMapping(path="{videoID}")
    public void deleteStudent(@PathVariable("videoID") Long videoId){
        videoService.deleteVideo(videoId);
    }

    @PutMapping(path="{videoID}")
    public void updateStudent(@PathVariable("videoID") Long videoID,@RequestParam(required = false) String name,@RequestParam(required = false) Integer like){
        videoService.updateVideo(videoID,like,name);
    }









}
