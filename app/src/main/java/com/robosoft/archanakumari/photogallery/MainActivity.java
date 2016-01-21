package com.robosoft.archanakumari.photogallery;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.robosoft.archanakumari.photogallery.Modal.Communicators;
import com.robosoft.archanakumari.photogallery.Modal.PictureList;
import com.robosoft.archanakumari.photogallery.adapter.PhotoGalleryAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Communicators{

    Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private StringBuffer postList;
    PhotoGalleryAdapter recyclerViewAdapter;
    List<PictureList> picList;
    GridLayoutManager manager;
    private final String TAG = "parser";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
         mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //    getSupportActionBar().setIcon(R.drawable.toolimage);
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Void doInBackground(Void... voids) {
                JsonParser parser = new JsonParser();
                JsonObject rootObejct = parser.parse(loadJSONFromAsset()).getAsJsonObject();
                JsonElement projectElement = rootObejct.get("Albums");
                Gson gson = new Gson();
                picList = new ArrayList<>();
                //Check if "project" element is an array or an object and parse accordingly...
                if (projectElement.isJsonObject()) {
                    //The returned list has only 1 element
                    PictureList project = gson.fromJson(projectElement, PictureList.class);
                    picList.add(project);
                    Log.i(TAG, "Inside activity");
                    for (int i = 0; i < picList.size(); i++) {
                        PictureList project1 = picList.get(i);
                        Log.i(TAG, "Inside loop");
                    }

                } else if (projectElement.isJsonArray()) {
                    //The returned list has >1 elements
                    Type projectListType = new TypeToken<List<PictureList>>() {
                    }.getType();
                    picList = gson.fromJson(projectElement, projectListType);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                for (int i = 0; i < picList.size(); i++) {
                    PictureList project1 = picList.get(i);
                    Log.i(TAG, "Inside loop");
                    //Toast.makeText(SecondActivity,"Inside context",Toast.LENGTH_LONG).show();
                    Log.i("Parser:Title", project1.getmTitle());
                    Log.i("Parser:Name", project1.getmDesc());
                    String[] images = project1.getmImages();
                    for (int j = 0; j < images.length; j++)
                        Log.i("Parser:Image", images[j]);
                }
                recyclerViewAdapter = new PhotoGalleryAdapter(MainActivity.this,picList);
                manager = new GridLayoutManager(MainActivity.this,2);
                mRecyclerView.setLayoutManager(manager);
                mRecyclerView.setAdapter(recyclerViewAdapter);
            }
        }.execute();

    }


    public String loadJSONFromAsset() {

        String json = null;
        try {

            AssetManager assetManager = getAssets();
            InputStream inputStream = assetManager.open("albums.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @Override
    public void toCommunicate(PictureList pictureList) {
        Intent intent = new Intent(MainActivity.this,AlbumList.class);
        intent.putExtra("Data",pictureList);
        startActivity(intent);

    }
}



