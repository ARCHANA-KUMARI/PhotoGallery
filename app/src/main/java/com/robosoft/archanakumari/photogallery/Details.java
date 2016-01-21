package com.robosoft.archanakumari.photogallery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.robosoft.archanakumari.photogallery.Modal.PictureList;
import com.robosoft.archanakumari.photogallery.adapter.pageViewerAdapter;

public class Details extends AppCompatActivity {

    Toolbar toolbar;
    PictureList pictureList;
    ViewPager viewPager;
    pageViewerAdapter mPageViewerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //toolbar = (Toolbar) findViewById(R.id.appbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

         Intent intent =getIntent();
         pictureList = (PictureList) intent.getSerializableExtra("Details");
         Toast.makeText(getBaseContext(),"Hi i am in Third Activity",Toast.LENGTH_LONG).show();
         //Toast.makeText(getBaseContext()," "+intent.)
         viewPager = (ViewPager) findViewById(R.id.pager);
         mPageViewerAdapter = new  pageViewerAdapter(this,pictureList);
         viewPager.setAdapter(mPageViewerAdapter);



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
