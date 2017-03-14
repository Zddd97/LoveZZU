package com.gjf.lovezzu;

import android.content.Intent;

/**
 * Created by zhaox on 2017/3/11.
 */

public class SchoolMid {
    private int imageId;
    private Intent intent;

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public SchoolMid(int imageId, Intent intent) {
        this.imageId = imageId;
        this.intent = intent;
    }

    public int getImageId() {
        return imageId;
    }

    public Intent getIntent() {
        return intent;
    }
}
