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

    /**
     * It returns all the videos from the database
     * @return list of videos
     */
    @GetMapping
    public List<Video> getVideos(){
       return videoRepository.findAll();
    }

    /**
     * It adds a video to the database
     * @param video the video that you want to add to the database
     */
    public void addVideo(Video video) {
        Optional <Video> videoOptional=videoRepository.findVideoByname(video.getName());
        if(videoOptional.isPresent()){
            throw new IllegalStateException("name taken");
        }
        videoRepository.save(video);
    }

    /**
     * check if the video is in the database
     * @param videoID ID of the video
     * @return return true if video is in the database
     */
    private boolean videoExist(Long videoID){
       return videoRepository.existsById(videoID);
    }

    /**
     * delete the video is from the database
     * @param videoID ID of the video
     * @return return true if video is in the database
     */
    public void deleteVideo(Long videoID){
        if(!videoExist(videoID)){
            throw new IllegalStateException("video with ID "+videoID+" does not exist");
        }
        videoRepository.deleteById(videoID);
    }
    /**
     * It updates a video from the database
     * @param videoID ID for the video that you want to delete
     * @param name the new name for the video
     * @param like new number of likes for the video
     */
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
