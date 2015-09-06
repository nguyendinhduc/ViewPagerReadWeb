package com.ducnd.exercise16_viewpage;

import com.ducnd.my_adapter.Adapter_ViewPage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

public class ActivityWeb extends Activity {
	private static final String TAG = "ActivityWeb";
	private Intent intent;
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_web);
		initAcitvityWeb();
	}

	public void initAcitvityWeb() {
		try {
		intent = getIntent();
		String link = intent.getStringExtra(Adapter_ViewPage.LINK);
		webView = (WebView) this.findViewById(R.id.webView);
		webView.getSettings().setLoadsImagesAutomatically(true);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		webView.loadUrl(link);
		} catch (Exception e) {
			Log.i(TAG, "initAcitvityWeb:_ERRO: " +e.toString());
		}
	}
}
