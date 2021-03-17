package com.example.staggeredgridrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Picture> pictureList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPictures();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        PictureAdapter adapter = new PictureAdapter(pictureList);
        recyclerView.setAdapter(adapter);
    }

    private void initPictures(){
        for(int i = 0; i < 5; i++){
            Picture pic1 = new Picture(getRandomLengthName("Pic1"), R.drawable.timg3);
            pictureList.add(pic1);

            Picture pic2 = new Picture(getRandomLengthName("Pic2"), R.drawable.timg14);
            pictureList.add(pic2);

            Picture pic3 = new Picture(getRandomLengthName("Pic3"), R.drawable.timg22);
            pictureList.add(pic3);
        }
    }

    private String getRandomLengthName(String name){
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for(int i = 2; i < length; i++){
            builder.append(name);
        }
        return builder.toString();
    }


}
