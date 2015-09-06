package com.ducnd.my_adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ducnd.Item_common.Item_Search;
import com.ducnd.custom.MyArrayList;
import com.ducnd.exercise16_viewpage.R;


public class Adapter_ListSearch extends BaseAdapter{
	private ArrayList<Item_Search> arrItemSearch;
	private Context mContext;
	private LayoutInflater mInflater;
	public Adapter_ListSearch( Context mContext, ArrayList<Item_Search> arrItemSearch ) {
		this.mContext = mContext;
		this.arrItemSearch = new MyArrayList<Item_Search>();
		this.arrItemSearch = arrItemSearch;
		this.mInflater = LayoutInflater.from(this.mContext);
	}
	@Override
	public int getCount() {
		return arrItemSearch.size();
	}

	@Override
	public Item_Search getItem(int position) {
		return arrItemSearch.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if ( convertView == null ) {
			convertView = mInflater.inflate(R.layout.item_search, parent, false);
		}
		((ImageView)convertView.findViewById(R.id.imageSearch)).setImageResource(arrItemSearch.get(position).getIdIcon());
//		ImageView image = (ImageView)convertView.findViewById(R.id.imageSearch);
//		Bitmap bm;
//		if (image.getDrawable() instanceof BitmapDrawable) {
//	        bm = ((BitmapDrawable) image.getDrawable()).getBitmap();
//	    } else {
//	        Drawable d = image.getDrawable();
//	        bm = Bitmap.createBitmap(d.getIntrinsicWidth(), d.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
//	        Canvas canvas = new Canvas(bm);
//	        d.draw(canvas);
//	    }
		
//		bm = AliasImage.applySmoothEffect(bm, 5);
//		image.setImageBitmap(bm); 
		((TextView)convertView.findViewById(R.id.textName)).setText(arrItemSearch.get(position).getName());
		((TextView)convertView.findViewById(R.id.textlink)).setText(arrItemSearch.get(position).getLink());
		return convertView;
	}

}
