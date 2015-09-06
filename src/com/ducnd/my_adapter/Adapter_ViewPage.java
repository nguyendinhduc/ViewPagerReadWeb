package com.ducnd.my_adapter;

import java.util.ArrayList;

import com.ducnd.Item_common.ItemMenu;
import com.ducnd.Item_common.Item_GridView;
import com.ducnd.Item_common.Item_Search;
import com.ducnd.custom.MyArrayList;
import com.ducnd.custom.MyGridView;
import com.ducnd.exercise16_viewpage.ActivityWeb;
import com.ducnd.exercise16_viewpage.Activity_Property;
import com.ducnd.exercise16_viewpage.Dialog_Menu;
import com.ducnd.exercise16_viewpage.Dialog_Search;
import com.ducnd.exercise16_viewpage.R;
import com.ducnd.my_interface.GetterArrItemSearch;
import com.ducnd.my_interface.GetterContex;
import com.ducnd.my_interface.MyOnAddAarrMenu;
import com.ducnd.my_interface.MyOnlistener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Adapter_ViewPage extends PagerAdapter implements OnClickListener,
		MyOnlistener, MyOnAddAarrMenu, GetterContex, GetterArrItemSearch {
	private static final String TAG = "Adapter_ViewPage";
	public static final String GENGRE = "GENGRE";
	public static final String NAME = "NAME";
	public static final String ID_ICON = "ID_ICON";
	public static final String LINK = "LINK";
	public static final int HOME = 3534;
	private ArrayList<MyArrayList<Item_GridView>> arrViewPage;
	private LayoutInflater mInflater;
	private Context mContext;
	private int positionGr = -1;

	public Adapter_ViewPage(Context mContext,
			ArrayList<MyArrayList<Item_GridView>> arrViewPage) {
		this.mContext = mContext;
		this.mInflater = LayoutInflater.from(this.mContext);
		this.arrViewPage = arrViewPage;

	}

	@Override
	public int getCount() {
		return arrViewPage.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return ((LinearLayout) arg0).equals((LinearLayout) arg1);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return arrViewPage.get(position).getTitile();
	}

	@Override
	public void destroyItem(View container, int position, Object object) {
		Log.i(TAG, "destroyItem_position: " + position);
		((ViewPager) container).removeView((LinearLayout) object);
	}

	@Override
	public LinearLayout instantiateItem(View container, int position) {
		Log.i(TAG, "instantiateItem: position: " + position);
		LinearLayout re = (LinearLayout) mInflater.inflate(
				R.layout.item_viewpage, (ViewGroup) container, false);

		TextView title = (TextView) re.findViewById(R.id.textTitle);
		title.setText(arrViewPage.get(position).getTitile());
		title.setTypeface(Typeface.createFromAsset(this.mContext.getAssets(),
				"fonts/font_viet1.ttf"));

		Adapter_GridView adapter = new Adapter_GridView(this.mContext,
				arrViewPage.get(position));
		adapter.setPositionAdapter(position);
		this.positionGr = position;
		MyGridView mGridview = ((MyGridView) re.findViewById(R.id.gridView));
		mGridview.setAdapter(adapter);
		ImageButton btnList = (ImageButton) re.findViewById(R.id.btnList);
		ImageButton btnSearch = (ImageButton) re.findViewById(R.id.btnSearch);

		btnList.setOnClickListener(this);
		btnSearch.setOnClickListener(this);
		mGridview.setAdapter(adapter);
		mGridview.setPosition(position);

		CustomOnItemClick mCustomOnItemClick = new CustomOnItemClick(position);
		mGridview.setOnItemClickListener(mCustomOnItemClick);
		mGridview.setOnItemLongClickListener(mCustomOnItemClick);

		((ViewPager) container).addView(re);
		return re;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnList:
			Intent inten = new Intent();
			Dialog_Menu menu = new Dialog_Menu();
			menu.addOnlisetner(this);
			menu.addMyOnAddAarrMenu(this);
			menu.addGetContext(this);
			inten.setClass(mContext, Dialog_Menu.class);
			((Activity) this.mContext).startActivity(inten);
			break;
		case R.id.btnSearch:
			Dialog_Search dialogSearch = new Dialog_Search(this.mContext);
			dialogSearch.addGetterArrItemSearch(this);
			dialogSearch.show();
		default:
			break;
		}
	}

	@Override
	public void exitApp() {
		((Activity) this.mContext).finish();
	}

	@Override
	public ArrayList<ItemMenu> coppyArrMenu() {
		String title;
		String tem;
		ArrayList<ItemMenu> arrMemu = new MyArrayList<ItemMenu>();
		for (int i = 0; i < arrViewPage.size(); i++) {
			tem = this.arrViewPage.get(i).getTitile();
			tem = tem.trim();
			title = tem.substring(0, 1);
			arrMemu.add(new ItemMenu(title, tem, i));
		}
		return arrMemu;

	}

	@Override
	public Context getContex() {
		return this.mContext;
	}

	private ArrayList<Item_Search> returnArrItemSearch(String name) {
		String nameEqual;
		ArrayList<Item_Search> arrItemSearch = new MyArrayList<Item_Search>();
		for (ArrayList<Item_GridView> i : this.arrViewPage) {
			for (Item_GridView j : i) {
				nameEqual = j.getName().toUpperCase();
				if (nameEqual.contains(name.toUpperCase())) {
					arrItemSearch.add(new Item_Search(j.getIdImageIcon(), j
							.getName(), j.getLink()));
				}
			}
		}
		return arrItemSearch;
	}

	@Override
	public ArrayList<Item_Search> getArrItemSearch(String name) {
		return returnArrItemSearch(name);
	}

	private class CustomOnItemClick implements OnItemClickListener,
			OnItemLongClickListener {
		private int mPosition = -1;

		public CustomOnItemClick(int mPosition) {
			this.mPosition = mPosition;
		}

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			if (this.mPosition < 0)
				return;

			String link = arrViewPage.get(this.mPosition).get(position)
					.getLink();
			if (link != null) {
				Log.i(TAG, "onItemClick_positionGr= : " + this.mPosition);
				Intent intent = new Intent();
				intent.setClass(mContext, ActivityWeb.class);
				intent.putExtra(LINK, link);
				mContext.startActivity(intent);
				((Activity) mContext).overridePendingTransition(
						R.anim.translate_right, R.anim.scale_left);
			} else {
				Toast.makeText(mContext, "Empty Link!!!", Toast.LENGTH_SHORT)
						.show();
			}
		}

		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view,
				int position, long id) {
			if (this.mPosition < 0)
				return false;
			Intent intent = new Intent();
			intent.setClass(mContext, Activity_Property.class);
			intent.putExtra(GENGRE, arrViewPage.get(this.mPosition).getTitile());
			intent.putExtra(NAME, arrViewPage.get(this.mPosition).get(position)
					.getName());
			intent.putExtra(ID_ICON,
					arrViewPage.get(this.mPosition).get(position)
							.getIdImageIcon());
			intent.putExtra(LINK, arrViewPage.get(this.mPosition).get(position)
					.getLink());
			mContext.startActivity(intent);
			return true;
		}

	}
}
