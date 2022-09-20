package com.example.app31;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ToyAdapter extends ArrayAdapter<Toy> {

    Context context;
    List<Toy> objects;

    public ToyAdapter(Context context, int resource, int textViewResourceId, List<Toy> objects) {
        super(context, resource, textViewResourceId, objects);
        this.context=context;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.custom_layout, parent, false);
        TextView title = view.findViewById(R.id.tvTitle);
        TextView subTitle = view.findViewById(R.id.tvSubTitle);
        TextView price = view.findViewById(R.id.tvPrice);
        Toy temp = objects.get(position);

        title.setText(temp.getTitle());
        subTitle.setText(temp.getSubTitle());
        price.setText(String.valueOf(temp.getPrice()));
        return view;
    }
}
