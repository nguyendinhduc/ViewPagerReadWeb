package com.ducnd.exercise16_viewpage;

import java.util.ArrayList;

import com.ducnd.Item_common.Item_Search;
import com.ducnd.my_adapter.Adapter_ListSearch;
import com.ducnd.my_adapter.Adapter_ViewPage;
import com.ducnd.my_interface.GetterArrItemSearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class Activity_Search extends Activity implements OnItemClickListener{
	private Intent intent;
	private ListView listViewSearch;
	private ArrayList<Item_Search> arrItemSearch = new ArrayList<Item_Search>();
	private Adapter_ListSearch adapter;
	private static GetterArrItemSearch gettergetterArrItemSearch;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_search);
		initActivity_Search();
		listViewSearch.setOnItemClickListener(this);
	}
	public void initActivity_Search() {
		this.intent = getIntent();
		String name = this.intent.getStringExtra("NAME");
		listViewSearch = (ListView)findViewById(R.id.listViewSearch);
		arrItemSearch = gettergetterArrItemSearch.getArrItemSearch(name);
		
		adapter = new Adapter_ListSearch(this, arrItemSearch);
		listViewSearch.setAdapter(adapter);
	}
	public static void addGettergetterArrItemSearch( GetterArrItemSearch gettergetterArrItemSearch ) {
		Activity_Search.gettergetterArrItemSearch = gettergetterArrItemSearch;
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		String link = arrItemSearch.get(position).getLink();
		if ( !link.equals("") ) {
			Intent i = new Intent();
			i.setClass(this, ActivityWeb.class);
			i.putExtra(Adapter_ViewPage.LINK, link);
			startActivity(i);
			finish();
		}
		else {
			Toast.makeText(this, "haven't link", Toast.LENGTH_SHORT).show();
		}
		
	}
}
