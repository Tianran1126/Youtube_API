package com.example.demo.video;
import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name="videos")
public class Video {

    @Id
    @SequenceGenerator(name="video_sequence",sequenceName ="video_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="video_sequence")
    private Long id;
    private String name;
    private LocalDate dob;
    private Integer like;

    public Video() {
    }

    public Video(Long id, String name, LocalDate dob, Integer like) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.like = like;
    }

    public Video(String name, LocalDate dob, Integer like) {
        this.name = name;
        this.dob = dob;
        this.like = like;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", like=" + like +
                '}';
    }
}
