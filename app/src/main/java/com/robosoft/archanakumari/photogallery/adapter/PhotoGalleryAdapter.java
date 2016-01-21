package com.robosoft.archanakumari.photogallery.adapter;

import android.content.Context;
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
import com.robosoft.archanakumari.photogallery.Modal.Communicators;
import com.robosoft.archanakumari.photogallery.Modal.MySingleton;
import com.robosoft.archanakumari.photogallery.Modal.PictureList;
import com.robosoft.archanakumari.photogallery.Modal.ViewHolderClass;
import com.robosoft.archanakumari.photogallery.R;

import java.util.List;

/**
 * Created by archanakumari on 22/12/15.
 */
public class PhotoGalleryAdapter extends RecyclerView.Adapter<ViewHolderClass> implements View.OnClickListener {

    private View  mOneRow ;
    private Context mContext;
    private ImageLoader mImageLoader;
    //DisplayImageOptions options;
    List<PictureList> list;
    Communicators communicators;
    int adapterpositon;

    public PhotoGalleryAdapter(Context mContext, List<PictureList> list){
        communicators = (Communicators) mContext;
        this. mContext = mContext;
        this.list = list;

    }

    @Override
    public ViewHolderClass onCreateViewHolder(ViewGroup parent, int viewType) {

        mOneRow = LayoutInflater.from( mContext).inflate(R.layout.album,parent,false);
        ViewHolderClass viewHolder = new ViewHolderClass( mOneRow);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolderClass holder, int position) {
        // Initially we want the progress indicator visible, and the image invisible
        adapterpositon = position;
        final PictureList pictureList = list.get(position);
        holder.titletextView.setText(pictureList.getmTitle());
        String listofimages[] = pictureList.getmImages();
        int noofimages = listofimages.length;
        String url = listofimages[1];
        holder.noofItemstextView.setText(String.valueOf(noofimages));

        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                holder.imagesimageView.setImageBitmap(response);

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
        return list.size();
    }

    @Override
    public void onClick(View v) {
        communicators.toCommunicate(list.get(adapterpositon));
    }
}
