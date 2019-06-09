package model;

import android.graphics.Bitmap;
import android.location.Location;

import java.util.Date;

public class Post {

    private int studentId;
    private String postTitle;
    private String postDescription;
    private String postImage;
    private Bitmap finalPhoto;
    private Date postDate;
    private Location postLocation;
    private double postLatitude;
    private double postLongitude;


    //Constructor para crear los post desde JSONObject
    public Post(int studentId, String postTitle, String postDescription, String postImage, Date postDate, double postLatitude, double postLongitude) {
        this.studentId = studentId;
        this.postTitle = postTitle;
        this.postDescription = postDescription;
        this.postImage = postImage;
        this.postDate = postDate;
        this.postLatitude = postLatitude;
        this.postLongitude = postLongitude;
    }

    //Constructor para crear los post y enviarlos
    public Post(int studentId, String postTitle, String postDescription, Bitmap finalPhoto, Date postDate, double postLatitude, double postLongitude) {
        this.studentId = studentId;
        this.postTitle = postTitle;
        this.postDescription = postDescription;
        this.finalPhoto = finalPhoto;
        this.postDate = postDate;
        this.postLatitude = postLatitude;
        this.postLongitude = postLongitude;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public String getPostImage() {
        return postImage;
    }

    public Date getPostDate() {
        return postDate;
    }

    public Location getPostLocation() {
        return postLocation;
    }

    public double getPostLatitude() {
        return postLatitude;
    }

    public double getPostLongitude() {
        return postLongitude;
    }

    @Override
    public String toString() {
        return "Post{" +
                "studentId=" + studentId +
                ", postTitle='" + postTitle + '\'' +
                ", postDescription='" + postDescription + '\'' +
                ", postImage='" + postImage + '\'' +
                ", postDate=" + postDate +
                ", postLatitude=" + postLatitude +
                ", postLongitude=" + postLongitude +
                '}';
    }
}
