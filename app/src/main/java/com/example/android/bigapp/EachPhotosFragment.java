package com.example.android.bigapp;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.bigapp.Activities.PhotoActivity;
import com.squareup.picasso.Picasso;


public class EachPhotosFragment extends Fragment {
    ImageView img;
    TextView tv;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String imageUrl;
    private String title;




    public EachPhotosFragment() {
        // Required empty public constructor
    }


    public static EachPhotosFragment newInstance(String imageUrl, String title) {
        EachPhotosFragment fragment = new EachPhotosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, imageUrl);
        args.putString(ARG_PARAM2, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imageUrl = getArguments().getString(ARG_PARAM1);
            title = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_each_photos, container, false);
        img=(ImageView)v.findViewById(R.id.imageView);
        tv=(TextView)v.findViewById(R.id.title);

        tv.setText(title);
        Picasso.with(getActivity().getApplicationContext()).load(imageUrl).into(img);

        return v;
    }

}
