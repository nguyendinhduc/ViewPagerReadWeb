package com.ducnd.exercise16_viewpage;

import java.util.ArrayList;

import com.ducnd.Item_common.ItemMenu;
import com.ducnd.my_interface.GetterContex;
import com.ducnd.my_interface.MyOnAddAarrMenu;
import com.ducnd.my_interface.MyOnlistener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.TextView;

public class Dialog_Menu extends Activity implements OnClickListener, MyOnAddAarrMenu {
	public static final int RESULT_SET_POSISION = 98345;
	private TextView textThoat, textMenu;
	private ListView list;
	private ArrayList<String> arr;
	private static MyOnlistener mOnListner;
	private static MyOnAddAarrMenu mOnArrMenu;
	private static GetterContex getContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_menu);
		setPositionDislay(Gravity.TOP, Gravity.RIGHT);
	
		initDialog_Menu();
	}

	public void setPositionDislay(int position0, int position1) {
		Window window = getWindow();
		WindowManager.LayoutParams wlp = window.getAttributes();
		wlp.gravity = position0 | position1;
		wlp.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
		window.setAttributes(wlp);
		
	}

	public void initDialog_Menu() {
		textMenu = (TextView) findViewById(R.id.textMenu);
		textThoat = (TextView) findViewById(R.id.textThoat);
		textThoat.setOnClickListener(this);
		textMenu.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.textThoat:
			this.mOnListner.exitApp();
			finish();
			break;
		case R.id.textMenu:
			Intent intent = new Intent();
			intent.setClass(this, ActivityListMenu.class);
			ActivityListMenu a =  new ActivityListMenu();
			a.addMyOnAddAarrMenu(this);
			a.addGetContext(this.getContext);
			((Activity)this.getContext.getContex()).startActivityForResult(intent, RESULT_SET_POSISION);
			finish();
			break;
		default:
			break;
		}

	}
    public void addOnlisetner( MyOnlistener mOnListner ) {
    	this.mOnListner = mOnListner;
    }
    public void addMyOnAddAarrMenu( MyOnAddAarrMenu mOnAddArrMenu ) {
    	this.mOnArrMenu = mOnAddArrMenu;
    }
    public void addGetContext( GetterContex getContext) {
    	this.getContext = getContext;
    }

	@Override
	public ArrayList<ItemMenu> coppyArrMenu() {
		return this.mOnArrMenu.coppyArrMenu();
	}
}
