package com.example.demo.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
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

    private boolean videoExist(Long videoID){
       return videoRepository.existsById(videoID);
    }


    public void deleteVideo(Long videoID){
        if(!videoExist(videoID)){
            throw new IllegalStateException("video with ID "+videoID+" does not exist");
        }
        videoRepository.deleteById(videoID);
    }
    @Transactional
    public void updateVideo(Long videoID,Integer like,String name) {
        if (!videoExist(videoID)) {
            throw new IllegalStateException("video with ID " + videoID + " does not exist");
        } else {
            Video video = videoRepository.getOne(videoID);
            if (like != null && !Objects.equals(like, video.getLike())) {
                video.setLike(like);
            } else if (name != null && !Objects.equals(name, video.getName()) && name.length() > 0) {
                Optional<Video> findname = videoRepository.findVideoByname(name);
                if (findname.isPresent()) {
                    throw new IllegalStateException("name already exist");
                }
                video.setName(name);
            }
        }
    }




}
