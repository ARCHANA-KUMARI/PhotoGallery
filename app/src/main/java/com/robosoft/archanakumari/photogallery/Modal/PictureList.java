package com.robosoft.archanakumari.photogallery.Modal;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by archanakumari on 22/12/15.
 */
public class PictureList implements Serializable{
    @SerializedName("Title")
    private String mTitle;
    @SerializedName("Desc")
    private String mDesc;
    @SerializedName("images")
    private  String mImages[];

    public PictureList(String mTitle, String mDesc, String[] mImages) {
        this.mTitle = mTitle;
        this.mDesc = mDesc;
        this.mImages = mImages;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDesc() {
        return mDesc;
    }

    public String[] getmImages() {
        return mImages;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }

    public void setmImages(String[] mImages) {
        this.mImages = mImages;
    }
}
