package model;

import android.graphics.Bitmap;
import android.location.Location;

import java.util.Date;

public class Post {

    private int studentId;
    private String postTitle;
    private String postDescription;
    private Bitmap postImage;
    private Date postDate;
    private Location postLocation;
    private double postLatitude;
    private double postLongitude;

    public Post(int studentId, String postTitle, String postDescription,
                Bitmap postImage, Date postDate, Location postLocation,
                double postLatitude, double postLongitude) {
        this.studentId = studentId;
        this.postTitle = postTitle;
        this.postDescription = postDescription;
        this.postImage = postImage;
        this.postDate = postDate;
        this.postLocation = postLocation;
        this.postLatitude = postLatitude;
        this.postLongitude = postLongitude;
    }

    public Post(int studentId, String postTitle, String postDescription, Bitmap postImage, Date postDate) {
        this.studentId = studentId;
        this.postTitle = postTitle;
        this.postDescription = postDescription;
        this.postImage = postImage;
        this.postDate = postDate;
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

    public Bitmap getPostImage() {
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
                ", postDescription='" + postDescription.length() + '\'' +
                ", postImage=" + postImage.getHeight() +
                ", postDate=" + postDate.toString() +
                ", postLocation=" + postLocation.toString() +
                '}';
    }
}
