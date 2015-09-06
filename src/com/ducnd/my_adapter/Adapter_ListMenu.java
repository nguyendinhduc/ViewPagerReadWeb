package com.ducnd.my_adapter;

import java.util.ArrayList;

import com.ducnd.Item_common.ItemMenu;
import com.ducnd.exercise16_viewpage.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adapter_ListMenu extends BaseAdapter{
	private ArrayList<ItemMenu> arrListMenu;
	private Context mContext;
	private LayoutInflater mInflater;
	public Adapter_ListMenu( Context mContext, ArrayList<ItemMenu> arrListMenu) {
		this.mContext = mContext;
		this.mInflater = LayoutInflater.from(this.mContext);
		this.arrListMenu = arrListMenu;
	}
	@Override
	public int getCount() {
		return arrListMenu.size();
	}

	@Override
	public ItemMenu getItem(int position) {
		// TODO Auto-generated method stub
		return arrListMenu.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if ( convertView == null ) {
			convertView = this.mInflater.inflate(R.layout.item_menu, parent, false);
		}
		((TextView)convertView.findViewById(R.id.iconTitile)).setText(arrListMenu.get(position).getIconTitle());
		((TextView)convertView.findViewById(R.id.textTitle)).setText(arrListMenu.get(position).getTitle());
		return convertView;
	}

}
