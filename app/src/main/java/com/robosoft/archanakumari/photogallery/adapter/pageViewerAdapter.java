package com.robosoft.archanakumari.photogallery.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.robosoft.archanakumari.photogallery.Modal.MySingleton;
import com.robosoft.archanakumari.photogallery.Modal.PictureList;
import com.robosoft.archanakumari.photogallery.R;

/**
 * Created by archanakumari on 23/12/15.
 */
public class pageViewerAdapter extends PagerAdapter {

    private int mImageResource[] = {R.drawable.eight,R.drawable.eleven,R.drawable.five,R.drawable.eleven,R.drawable.one,R.drawable.nine,R.drawable.three };
    View view;
    LayoutInflater layoutInflater;
    Context context;
    PictureList pictureList;
    ImageView imageView;

    public pageViewerAdapter(Context context, PictureList pictureList) {
        this.context = context;
        this.pictureList = pictureList;

    }

    @Override
    public int getCount() {
        return mImageResource.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==(LinearLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view =  layoutInflater.inflate(R.layout.pagevieweradapter, container, false);
        TextView  mText = (TextView) view.findViewById(R.id.text);

        final ImageView imageView = (ImageView) view.findViewById(R.id.img);
        String imagers[] = pictureList.getmImages();
        if(position == 0)
        {

        }
        else {
            String[] url = pictureList.getmImages();
            String imageUrl = url[position];
            ImageRequest imageRequest = new ImageRequest(imageUrl, new Response.Listener<Bitmap>() {
                @Override
                public void onResponse(Bitmap response) {
                   imageView.setImageBitmap(response);

                }
            }, 0, 0, null, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    imageView.setImageResource(R.drawable.eight);
                }

            });

            //Access the request queue through your singleton class
            MySingleton.getInstance(context).addToRequestQueue(imageRequest);
        }
        mText.setText(pictureList.getmTitle());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(view);

    }
}
