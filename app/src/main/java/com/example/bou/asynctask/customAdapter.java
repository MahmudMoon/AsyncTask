package com.example.bou.asynctask;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;

public class customAdapter extends BaseAdapter {

    LayoutInflater inflater;
    Context mContext;
    ArrayList<MovieObject> mArrayList;

    TextView movie_name,year,duration,director,actor,story,tagline;
    ImageView image_;
    ProgressBar progressBar;
    RatingBar ratingBar;
    DisplayImageOptions defaultOptions;


    public customAdapter(Context mContext, ArrayList<MovieObject> mArrayList) {
        this.mContext = mContext;
        this.mArrayList = mArrayList;
        inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(MainActivity.mContext).defaultDisplayImageOptions(defaultOptions).build();
        ImageLoader.getInstance().init(config);

    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        view = inflater.inflate(R.layout.adapter,null);
        movie_name = (TextView)view.findViewById(R.id.movie_name);
        year = (TextView)view.findViewById(R.id.tv_year);
        duration = (TextView)view.findViewById(R.id.textView3);
        director = (TextView)view.findViewById(R.id.director);
        tagline = (TextView)view.findViewById(R.id.tagline);
        story = (TextView)view.findViewById(R.id.story);
        ratingBar = (RatingBar)view.findViewById(R.id.ratingBar);
        image_ = (ImageView)view.findViewById(R.id.imageView);
        actor = (TextView)view.findViewById(R.id.textView6);
        progressBar = (ProgressBar)view.findViewById(R.id.progressBar);


        movie_name.setText(mArrayList.get(position).getMovie());
        year.setText(Integer.toString(mArrayList.get(position).getYear()));
        duration.setText(mArrayList.get(position).getDuration());
        director.setText(mArrayList.get(position).getDirector());
        tagline.setText(mArrayList.get(position).getTagline());
        story.setText(mArrayList.get(position).getStory());
        actor.setText(mArrayList.get(position).getStory());
        ratingBar.setRating((float) mArrayList.get(position).getRating());


        ImageLoader.getInstance().displayImage(mArrayList.get(position).getImage_(), image_, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });
        //MainActivity.textView.setText(s);

        return view;
    }
}
