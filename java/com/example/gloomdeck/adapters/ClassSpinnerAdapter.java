package com.example.gloomdeck.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gloomdeck.R;
import com.example.gloomdeck.perk.GloomClass;

import java.util.Objects;

public class ClassSpinnerAdapter extends ArrayAdapter<GloomClass> {

	Context context;
	int layoutResourceId;
	GloomClass[] classes;

	public ClassSpinnerAdapter(@NonNull Context context, int resource, @NonNull GloomClass[] objects) {
		super(context, resource, objects);
		this.context = context;
		this.layoutResourceId = resource;
		this.classes = objects;
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

		TextView label = (TextView) super.getView(position, convertView, parent);
		label.setText(classes[position].getClassName());
		return label;

//		View row = convertView;
//		ClassHolder holder = null;
//
//		if (row == null) {
//			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
//			row = inflater.inflate(layoutResourceId, parent, false);
//
//			holder = new ClassHolder();
//			holder.classname = (TextView) row.findViewById(android.R.id.text1);
//
//			row.setTag(holder);
//		} else {
//			holder = (ClassHolder) row.getTag();
//		}
//
//		GloomClass thisClass = objects[position];
//		holder.classname.setText(thisClass.getClassName());
//
//		return row;
	}

//	private class ClassHolder {
//		public TextView classname;
//	}


	@Override
	public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		TextView label = (TextView) super.getDropDownView(position, convertView, parent);
		label.setText(classes[position].getClassName());
		return label;
	}
}
