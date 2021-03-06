package com.example.appfinaldistribuidos;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import model.Post;
import model.PostManager;

public class AllPost extends Fragment {

    private static final String SERVER = "http://192.168.1.151:3001/Prueba";

    private JSONArray JSONAllPost;
    private TextView tvPrueba;
    private String json;
    private PostManager postManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_all_post, container, false);

        tvPrueba = v.findViewById(R.id.tv_Prueba);

        //requestServer(v);
        loadPost();

        return v;
    }

    private void loadPost(JSONArray jsonAllPost) {
        postManager = new PostManager();
        postManager.loadPostOnPostList(jsonAllPost);
        for (Post post: postManager.getPostList()) {
            Log.d("Posts: ", post.toString());
        }
    }

    private void loadPost() {
        HttpGetRequest request = new HttpGetRequest();
        request.execute();
    }

    public class HttpGetRequest extends AsyncTask<Void, Void, String> {

        static final String REQUEST_METHOD = "GET";
        static final int READ_TIMEOUT = 15000;
        static final int CONNECTION_TIMEOUT = 15000;

        @Override
        protected String doInBackground(Void... params){
            String result;
            String inputLine;

            try {
                // connect to the server
                URL myUrl = new URL(SERVER);
                HttpURLConnection connection =(HttpURLConnection) myUrl.openConnection();
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);
                connection.connect();

                // get the string from the input stream
                InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder stringBuilder = new StringBuilder();
                while((inputLine = reader.readLine()) != null){
                    stringBuilder.append(inputLine);
                }
                reader.close();
                streamReader.close();
                result = stringBuilder.toString();

            } catch(IOException e) {
                e.printStackTrace();
                result = "error";
            }

            return result;
        }

        protected void onPostExecute(String result){
            super.onPostExecute(result);
            tvPrueba.setText(result.toString());
            convertResultToJSon(result);
        }
    }

    private void convertResultToJSon(String result) {
        try {
            JSONAllPost = new JSONArray(result);
            loadPost(JSONAllPost);
        } catch (JSONException e) {
            Log.d("JSON", "JSON Malformado xdxd");
        }
    }


}