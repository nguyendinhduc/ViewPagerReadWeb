package com.ducnd.my_adapter;

import java.util.ArrayList;

import com.ducnd.Item_common.Item_GridView;
import com.ducnd.custom.MyArrayList;
import com.ducnd.exercise16_viewpage.R;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter_GridView extends BaseAdapter{
	private static final String TAG = "Adapter_GridView";
	private MyArrayList<Item_GridView> arrGridView;
	private Context mContext;
	private LayoutInflater mInflater;
	private int positionAdapter = -1;
	
	public Adapter_GridView( Context mContext, MyArrayList<Item_GridView> arrGridView) {
		this.arrGridView = arrGridView;
		this.mContext = mContext;
		this.mInflater = LayoutInflater.from(this.mContext);
	}
	@Override
	public int getCount() {
		return arrGridView.size();
	}

	@Override
	public Item_GridView getItem(int position) {
		return arrGridView.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if ( convertView == null ) {
			convertView = this.mInflater.inflate(R.layout.item_gridview, parent, false);
		}
		try {
			
		((ImageView)convertView.findViewById(R.id.imageIcon)).setImageResource(arrGridView.get(position).getIdImageIcon());
		} catch (Exception e) {
			Log.i(TAG, e.toString());
		}
		TextView textName = (TextView)convertView.findViewById(R.id.textName);
		textName.setText(arrGridView.get(position).getName());
		textName.setTypeface(Typeface.createFromAsset(this.mContext.getAssets(),"fonts/font_viet.ttf"));
		return convertView;
	}
	public int getPositionAdapter() {
		return positionAdapter;
	}
	public void setPositionAdapter(int positionAdapter) {
		this.positionAdapter = positionAdapter;
	}
	

}
