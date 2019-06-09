package com.example.appfinaldistribuidos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AllPost extends Fragment {

    private TextView tvPrueba;

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
        tvPrueba.setText("Holo, esto es un texto programatico");

        return v;
    }
}
