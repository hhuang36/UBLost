package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;


public class ImageAdapter extends PagerAdapter {
    private Context mContext;

    //private int[] mImageIds = new int[] {R.mipmap.capen_floor_2, R.mipmap.capen_floor_3, R.mipmap.capen_floor_4};
    private ArrayList mImageIds = new ArrayList();

    ImageAdapter(Context context) {
        mContext = context;
    }

    public ArrayList getmImageIds() { return mImageIds; }

    @Override
    public int getCount() {
        return mImageIds.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        PhotoView photoView = new PhotoView(mContext);
        photoView.setScaleType(PhotoView.ScaleType.FIT_CENTER);
        photoView.setImageResource((Integer) mImageIds.get(position));
        container.addView(photoView, 0);
        return photoView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }

}
