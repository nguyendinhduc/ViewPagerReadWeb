package com.ducnd.exercise16_viewpage;

import com.ducnd.my_adapter.Adapter_ViewPage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_Property extends Activity{
	private Intent intent;
	private TextView textTL, textLink,textTen;
	private ImageView  imageIcon;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_property);
		initPropery();
	}
	public void initPropery() {
		intent = this.getIntent();
		String tl = intent.getStringExtra(Adapter_ViewPage.GENGRE);
		((TextView)this.findViewById(R.id.textTL)).setText(tl);
		String ten = intent.getStringExtra(Adapter_ViewPage.NAME);
		((TextView)this.findViewById(R.id.textTen)).setText(ten);
		int icon = intent.getIntExtra(Adapter_ViewPage.LINK, -1);
		((ImageView)this.findViewById(R.id.imageIcon)).setImageResource(icon);
		String link = intent.getStringExtra(Adapter_ViewPage.LINK);
		((TextView)this.findViewById(R.id.textlink)).setText(link);
	}
	public void actionOk( View v ) {
		finish();
	}
}
