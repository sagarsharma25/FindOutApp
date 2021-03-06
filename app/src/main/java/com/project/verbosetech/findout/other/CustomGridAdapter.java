package com.project.verbosetech.findout.other;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.project.verbosetech.findout.model.GridCardModel;
import com.project.verbosetech.findout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by this pc on 06-06-17.
 */

public class CustomGridAdapter extends BaseAdapter {
    private Context mContext;
    List<GridCardModel> dataSet;

    public CustomGridAdapter(Context mContext, List<GridCardModel> dataSet) {
        this.mContext = mContext;
        this.dataSet = dataSet;
    }

    @Override
    public int getCount() {

        return dataSet.size();
    }

    @Override
    public Object getItem(int position) {

        return null;
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = inflater.inflate(R.layout.places_card_layout, null);
            TextView tplace = (TextView) grid.findViewById(R.id.place);
            TextView tnumber = (TextView) grid.findViewById(R.id.number);
            ImageView imageView = (ImageView) grid.findViewById(R.id.image);
            tplace.setText(dataSet.get(position).getName());
            tnumber.setText(dataSet.get(position).getNumber());

            //uploading image in image holder using glide library

            Glide.with(mContext).load(dataSet.get(position).getImage())
                    .dontAnimate()
                    .placeholder(R.drawable.cast_album_art_placeholder)
                    .bitmapTransform(new RoundedCornersTransformation(mContext, 50, 0, RoundedCornersTransformation.CornerType.TOP))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);
        } else {

            grid = (View) convertView;
        }

        return grid;
    }

    public void setFilter(List<GridCardModel> Model) {
        dataSet = new ArrayList<>();
        dataSet.addAll(Model);
        notifyDataSetChanged();
    }
}
