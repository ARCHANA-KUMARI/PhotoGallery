package com.robosoft.archanakumari.photogallery.Modal;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.robosoft.archanakumari.photogallery.R;

/**
 * Created by archanakumari on 22/12/15.
 */
public class ViewHolderClass extends RecyclerView.ViewHolder {

        public TextView titletextView;
        public  TextView noofItemstextView;
        public ImageView imagesimageView;
        Communicators communicators;

        public ViewHolderClass(View itemView) {
                super(itemView);
                titletextView = (TextView) itemView.findViewById(R.id.titletext);
                noofItemstextView = (TextView) itemView.findViewById(R.id.noofitems);
                imagesimageView = (ImageView) itemView.findViewById(R.id.albus_url);

        }

}
