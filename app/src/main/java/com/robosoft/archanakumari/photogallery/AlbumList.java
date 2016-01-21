package com.robosoft.archanakumari.photogallery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.robosoft.archanakumari.photogallery.Modal.PictureList;
import com.robosoft.archanakumari.photogallery.adapter.AlbumListAdapter;

public class AlbumList extends AppCompatActivity {

     Toolbar toolbar;
     RecyclerView recyclerView;
     AlbumListAdapter albumListAdapter;
    GridLayoutManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_album_list);
         toolbar = (Toolbar) findViewById(R.id.appbar);
         setSupportActionBar(toolbar);
         getSupportActionBar().setHomeButtonEnabled(true);
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         Intent intent = getIntent();

         PictureList pictureList = (PictureList) intent.getSerializableExtra("Data");
         String title = pictureList.getmTitle();
         Log.i("Title", title);
        Toast.makeText(getApplication(),"Hi i am in Second Activity", Toast.LENGTH_LONG).show();
        Log.i("Hi", "I am in 2nd activity");
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        albumListAdapter = new AlbumListAdapter(AlbumList.this,pictureList);
        manager = new GridLayoutManager(AlbumList.this,3);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(albumListAdapter);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if(id==android.R.id.home){
            onBackPressed();
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

}
