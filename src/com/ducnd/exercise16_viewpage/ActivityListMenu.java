package com.ducnd.exercise16_viewpage;

import java.util.ArrayList;

import com.ducnd.Item_common.ItemMenu;
import com.ducnd.custom.MyArrayList;
import com.ducnd.my_adapter.Adapter_ListMenu;
import com.ducnd.my_interface.GetterContex;
import com.ducnd.my_interface.MyOnAddAarrMenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ActivityListMenu extends Activity implements OnItemClickListener{
	private ArrayList<ItemMenu> arrMenu;
	private ListView listView;
	private Adapter_ListMenu adapter;
	private static MyOnAddAarrMenu mOnAddArrMenu;
	private static GetterContex getContex;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_list_menu);
		initActivityListMenu();
		listView.setOnItemClickListener(this);
	}
	public void initActivityListMenu() {
		listView = (ListView)findViewById(R.id.listView);
		arrMenu = new MyArrayList<ItemMenu>();
		arrMenu = this.mOnAddArrMenu.coppyArrMenu();
		adapter = new Adapter_ListMenu(this, arrMenu);
		listView.setAdapter(adapter);
		
		
	}
	public void addMyOnAddAarrMenu( MyOnAddAarrMenu  mOnAddArrMenu ) {
		this.mOnAddArrMenu = mOnAddArrMenu;
	}
	public void addGetContext( GetterContex getContext) {
		this.getContex = getContext;
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		String strPosisiton = String.valueOf(position);
		Intent i = new Intent();
		i.putExtra("ACTION", strPosisiton);
		setResult(Activity.RESULT_OK, i);
		finish();
	}
}
