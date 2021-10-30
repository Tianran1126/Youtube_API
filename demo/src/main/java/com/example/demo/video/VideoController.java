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

    /****
     * This is a response for get request for all the videos
     * @return return all the videos in the database
     */
    @GetMapping
    public List<Video> getVideos(){
        return videoService.getVideos();
    }

    /***
     * This a response for post request,It adds a video to the database
     * @param video this video is added to the database
     */
    @PostMapping
    public void registernewVideo(@RequestBody Video video){
        videoService.addVideo(video);
    }

    /**
     * This a response for post request,It deletes a video from the database
     * @param videoId ID for the video that you want to delete
     */
    @DeleteMapping(path="{videoID}")
    public void deleteStudent(@PathVariable("videoID") Long videoId){
        videoService.deleteVideo(videoId);
    }

    /**
     * this a response for put request,It updates a video from the database
     * @param videoID ID for the video that you want to delete
     * @param name the new name for the video
     * @param like new number of likes for the video
     */
    @PutMapping(path="{videoID}")
    public void updateStudent(@PathVariable("videoID") Long videoID,@RequestParam(required = false) String name,@RequestParam(required = false) Integer like){
        videoService.updateVideo(videoID,like,name);
    }









}
