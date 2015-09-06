package com.ducnd.exercise16_viewpage;

import com.ducnd.my_interface.GetterArrItemSearch;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dialog_Search extends Dialog implements android.view.View.OnClickListener{
	private Button btnCancelSearch, btnOkSearch;
	private Context mContext;
	private GetterArrItemSearch getterArrItemSearch;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	    	super.onCreate(savedInstanceState);
	    	requestWindowFeature(Window.FEATURE_NO_TITLE);
	    	setContentView(R.layout.dialog_search);
	    	btnCancelSearch = (Button)findViewById(R.id.btnCancelSearch);
	    	btnCancelSearch.setOnClickListener(this);
	    	btnOkSearch = (Button)findViewById(R.id.btnOkNewSearch);
	    	btnOkSearch.setOnClickListener(this);
	    }
	public Dialog_Search(Context context, boolean cancelable,
			OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
		this.mContext = context;
	}

	public Dialog_Search(Context context, int theme) {
		super(context, theme);
		this.mContext = context;
	}

	public Dialog_Search(Context context) {
		super(context);
		this.mContext = context;
	}
	public void addGetterArrItemSearch ( GetterArrItemSearch getterArrItemSearch ) {
		this.getterArrItemSearch = getterArrItemSearch;
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnCancelSearch:
			dismiss();
			break;
		case R.id.btnOkNewSearch:
			String name = ((EditText)findViewById(R.id.editNamSearch)).getText().toString();
			name = name.trim();
			if ( !name.equals("") ) {
				Intent intent = new Intent();
				intent.setClass(this.mContext, Activity_Search.class);
				intent.putExtra("NAME", name);
				Activity_Search.addGettergetterArrItemSearch(this.getterArrItemSearch);
				this.mContext.startActivity(intent);
				dismiss();
			}
			else {
				Toast.makeText(mContext, "Please input name need to search!!", Toast.LENGTH_SHORT).show();
			}
			
			break;
		default:
			break;
		}
	}
   
}
