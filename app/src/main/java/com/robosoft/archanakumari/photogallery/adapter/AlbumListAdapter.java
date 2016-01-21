package com.robosoft.archanakumari.photogallery.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.robosoft.archanakumari.photogallery.Details;
import com.robosoft.archanakumari.photogallery.Modal.Communicators;
import com.robosoft.archanakumari.photogallery.Modal.MySingleton;
import com.robosoft.archanakumari.photogallery.Modal.PictureList;
import com.robosoft.archanakumari.photogallery.Modal.ViewHolderOfAlbumListAdapter;
import com.robosoft.archanakumari.photogallery.R;

import java.util.List;

/**
 * Created by archanakumari on 22/12/15.
 */
public class AlbumListAdapter extends RecyclerView.Adapter<ViewHolderOfAlbumListAdapter> implements View.OnClickListener {

    Communicators communicators;
    PictureList pictureList;
    private View mOneRow ;
    private Context mContext;
    private ImageLoader mImageLoader;
    List<PictureList> list;
    int noOfImages;
    public AlbumListAdapter(Context mContext,PictureList pictureList) {
        this.mContext = mContext;
        this.pictureList = pictureList;

    }

    @Override
    public ViewHolderOfAlbumListAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        mOneRow = LayoutInflater.from( mContext).inflate(R.layout.albumlist,parent,false);
        ViewHolderOfAlbumListAdapter viewHolderOfAlbumListAdapter = new ViewHolderOfAlbumListAdapter(mOneRow);
        return  viewHolderOfAlbumListAdapter;
    }

    @Override
    public void onBindViewHolder(final ViewHolderOfAlbumListAdapter holder, int position) {

       //
       // holder.titletextview.setText(pictureList.getmTitle());
        Log.i("Hi i am",pictureList.getmTitle());
        String images[] = pictureList.getmImages();
         noOfImages = images.length;
        if(position==0)
             position = position +1;
        String url = images[position];
        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                holder.imageImageVIew.setImageBitmap(response);

            }
        }, 0, 0, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("HI ", "error has occur in image downloading");
            }

        });
        MySingleton.getInstance(mContext).addToRequestQueue(imageRequest);
        mOneRow.setOnClickListener(this);

    }

    @Override
    public int getItemCount() {
        return pictureList.getmImages().length;
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mContext, Details.class);
        intent.putExtra("Details",pictureList);
        mContext.startActivity(intent);
    }


}
