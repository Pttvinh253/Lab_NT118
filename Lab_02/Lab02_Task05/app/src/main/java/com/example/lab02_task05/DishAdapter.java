package com.example.lab02_task05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DishAdapter extends BaseAdapter {
    private Context context=null;
    private int layout;
    private ArrayList<Dish> dishList=null;


    public DishAdapter(Context context, int layout, ArrayList<Dish> dishList) {
        this.context = context;
        this.layout = layout;
        this.dishList = dishList;
    }
    @Override
    public int getCount(){
        return dishList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent)
    {
        if (convertView == null) {
            convertView =
                    LayoutInflater.from(context).inflate(R.layout.item_dish, null,
                            false);
        }

        Dish dish = dishList.get(position);
        ImageView imgDish = (ImageView) convertView.findViewById(R.id.imgDish);
        TextView txtDish= (TextView) convertView.findViewById(R.id.txtDish);

        ImageView icnStar = (ImageView) convertView.findViewById(R.id.icnStar);

        imgDish.setImageResource(dish.getThumbnail());
        txtDish.setText(dish.getName());

        txtDish.setSelected(true);

        if (dish.isPromotion())
        {
            icnStar.setVisibility(View.VISIBLE);

        }
        else
        {
            icnStar.setVisibility(View.GONE);
        }

        return convertView;
    }
}
