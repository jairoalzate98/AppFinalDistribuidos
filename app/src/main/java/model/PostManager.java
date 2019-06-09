package model;

import android.graphics.Bitmap;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PostManager {

    private ArrayList<Post> postList;

    public PostManager() {
        postList = new ArrayList<>();
    }

    public void loadPostOnPostList(JSONArray jsonArray){
        try {
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject o = jsonArray.getJSONObject(i);
                int studentId = Integer.parseInt(o.get("idUser").toString());
                String title = o.get("Titulo").toString();
                String postDesc = o.get("Descripcion").toString();
                //TODO Crear metodo que obtenga la imagen una vez tenga la direccion de la misma
                String img = o.get("imagenTitle").toString();
                Date postDate = parseDate(o.get("Fecha").toString());
                double latitude = Double.parseDouble(o.get("latitud").toString());
                double longitude = Double.parseDouble(o.get("longitud").toString());
                Post p = new Post(studentId, title, postDesc, img, postDate, latitude, longitude);
                postList.add(p);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private Date parseDate(String fecha) {
        try {
            Date d = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
            return d;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    //TODO
    public JSONObject convertPostToJSONObject(Post post){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Titulo", post.getPostTitle());
            jsonObject.put("Fecha", post.getPostDate());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Post> getPostList() {
        return postList;
    }
}
