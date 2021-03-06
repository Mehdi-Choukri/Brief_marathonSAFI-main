package com.mobile.basicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    public SliderAdapter(Context context){
        this.context=context;
    }

    public  int[] slide_image={
            R.drawable.tajine,
            R.drawable.coureuse,
            R.drawable.plage
    };

    public String[] slide_headings = {
            "La ville de Safi",
            "Vous souhaite le bienvenue",
            "Rejoignez-nous ASAP"
    };


    public String[] slider_desc = {
            "Safi marathone vous souhaite le bienvenue",
            "Le marathone est une épreuve sportive individuelle de course à pied",
            "Introduisez vos informations personnelles dans ce formulaire"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==(RelativeLayout) object;
    }

    @Override
    public Object instantiateItem( ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_image[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slider_desc[position]);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

       container.removeView((RelativeLayout)object);
     }
}