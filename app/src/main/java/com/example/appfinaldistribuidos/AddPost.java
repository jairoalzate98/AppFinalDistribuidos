package com.example.appfinaldistribuidos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import model.Post;

import static android.os.Environment.getExternalStoragePublicDirectory;

public class AddPost extends AppCompatActivity {

    private FusedLocationProviderClient client;

    private ImageView ivPhoto;
    private EditText etTitle;
    private EditText etDescription;

    private int studentId;
    private Date currentTime;
    private String pathToFile;
    private Bitmap finalPhoto;
    private Location postLocation;
    private Post finalPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        ivPhoto = findViewById(R.id.iv_Photo);
        etTitle =findViewById(R.id.et_title);
        etDescription = findViewById(R.id.et_description);

        client = LocationServices.getFusedLocationProviderClient(this);

        requestPermissions();
        getLocation();
    }

    public void sendPost(View view){
        if (validateEmptyFields()){
            if (validateNoPhoto()){
                if (postLocation != null){
                    finalPost = new Post(studentId, etTitle.getText().toString(), etDescription.getText().toString(), finalPhoto, currentTime, postLocation, postLocation.getLatitude(), postLocation.getLongitude());
                }else{
                    finalPost = new Post(studentId, etTitle.getText().toString(), etDescription.getText().toString(), finalPhoto, currentTime);
                }
            }
        }
    }

    private boolean validateNoPhoto() {
        if (finalPhoto != null){
            return true;
        }
        Toast t = Toast.makeText(getBaseContext(), "Por favor agrega una foto", Toast.LENGTH_SHORT);
        t.show();
        return false;
    }

    public void takePhotoFromCamera(View view){
        Intent takePhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePhoto.resolveActivity(getPackageManager()) != null){
            File photoFile = null;
            photoFile = createPhotoFile();

            if (photoFile != null) {
                pathToFile = photoFile.getAbsolutePath();
                Uri photoURI = FileProvider.getUriForFile(AddPost.this, "com.example.appfinaldistribuidos.fileprovider", photoFile);
                takePhoto.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePhoto, 1);
            }
        }
    }

    public void getLocation() {
        if (ActivityCompat.checkSelfPermission(
                AddPost.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        client.getLastLocation().addOnSuccessListener(AddPost.this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null){
                    postLocation = location;
                }else {
                    postLocation = null;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == 1){
                finalPhoto = BitmapFactory.decodeFile(pathToFile);
                ivPhoto.setImageBitmap(finalPhoto);
            }
        }
    }

    private void requestPermissions() {
        if (Build.VERSION.SDK_INT >= 23){
            requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        }
    }

    private File createPhotoFile() {
        currentTime = Calendar.getInstance().getTime();
        String name = studentId + "-" + etTitle.getText().toString();
        File storageDir = getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = null;
        try {
            image = File.createTempFile(name, ".jpg", storageDir);
        } catch (IOException e) {
            Log.d("MyLog", "Except:" + e.toString());
        }
        return image;
    }

    public boolean validateEmptyFields(){
        if(etTitle.getText().toString().isEmpty() && etDescription.getText().toString().isEmpty()){
            etTitle.setError("Titulo no puede estar en blanco");
            etDescription.setError("Descripcion no puede estar en blanco");
            return false;
        }else if(etTitle.getText().toString().isEmpty()){
            etTitle.setError("Titulo no puede estar en blanco");
            return false;
        }else if(etDescription.getText().toString().isEmpty()){
            etDescription.setError("Descripcion no puede estar en blanco");
            return false;
        }
        return true;
    }
}