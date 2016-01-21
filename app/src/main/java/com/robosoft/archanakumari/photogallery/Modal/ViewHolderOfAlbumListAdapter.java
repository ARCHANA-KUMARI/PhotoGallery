package com.robosoft.archanakumari.photogallery.Modal;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.robosoft.archanakumari.photogallery.R;

/**
 * Created by archanakumari on 22/12/15.
 */
public class ViewHolderOfAlbumListAdapter extends RecyclerView.ViewHolder {

    public TextView titletextview;
    public ImageView imageImageVIew;
    public ViewHolderOfAlbumListAdapter(View itemView) {
        super(itemView);
        titletextview = (TextView) itemView.findViewById(R.id.title);
        imageImageVIew= (ImageView) itemView.findViewById(R.id.images);


    }
}
