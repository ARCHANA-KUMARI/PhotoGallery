package com.robosoft.archanakumari.photogallery;

import com.google.gson.annotations.SerializedName;

/**
 * Created by archanakumari on 22/12/15.
 */
public class ModalClass {
    @SerializedName("Title")

    public String title;

    @SerializedName("Desc")

    public String desc;

    @SerializedName("images")

    public String[] images;

    public ModalClass(String title, String desc, String[] images) {

        this.title = title;

        this.desc = desc;

        this.images = images;

    }

    public String getTitle() {

        return title;

    }

    public void setTitle(String title) {

        this.title = title;

    }

    public String getDesc() {

        return desc;

    }

    public void setDesc(String desc) {

        this.desc = desc;

    }

    public String[] getImages() {

        return images;

    }

    public void setImages(String[] images) {

        this.images = images;

    }
}
