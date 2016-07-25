package com.codepath.nytimessearch;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by HENRY on 7/20/2016.
 */
public class ArticleArrayAdapter extends ArrayAdapter<Article> {

    public ArticleArrayAdapter(Context context, List<Article> articles){
        super(context, android.R.layout.simple_list_item_1, articles );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get data item for position
        Article article = this.getItem(position);

        //chechk to see if existing view  being reused
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_article_result, parent, false);
        }

        //find the imageView
        ImageView imageView = (ImageView) convertView.findViewById(R.id.ivImage);
        //clear out recycle image from convertView for last time
        imageView.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        tvTitle.setText(article.getHeadLine());

        //populate the thumbnail image
        //remote download the image in the background
        String thumbNail = article.getThumbNail();

        if(!TextUtils.isEmpty(thumbNail))
        {
            Picasso.with(getContext()).load(thumbNail).into(imageView);
        }
        return convertView;
    }
}
