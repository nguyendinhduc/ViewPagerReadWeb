package com.ducnd.exercise16_viewpage;

import java.util.ArrayList;

import com.ducnd.Item_common.Item_GridView;
import com.ducnd.custom.MyArrayList;
import com.ducnd.my_adapter.Adapter_ViewPage;
import com.lib.indicator.CirclePageIndicator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ViewPager viewPage;
	private ArrayList<MyArrayList<Item_GridView>> arrViewPage;
	private Adapter_ViewPage adapter;
	private CirclePageIndicator indicator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initMain();
	}

	public void initMain() {
		viewPage = (ViewPager) MainActivity.this.findViewById(R.id.viewPage);
		initArrViewPage();
		adapter = new Adapter_ViewPage(MainActivity.this, arrViewPage);
		viewPage.setAdapter(adapter);
		indicator = (CirclePageIndicator) findViewById(R.id.indicator);
		indicator.setViewPager(viewPage);
		viewPage.setPageTransformer(true, new ReaderViewPagerTransformer());

	}

	public void initArrViewPage() {
		arrViewPage = new ArrayList<MyArrayList<Item_GridView>>();

		MyArrayList<Item_GridView> arrTem0 = new MyArrayList<Item_GridView>();
		arrTem0.setTitile("Tin tức");
		arrTem0.add(new Item_GridView(R.drawable.vnexpress, "VnExpress", "http://m.vnexpress.net/"));
		arrTem0.add(new Item_GridView(R.drawable.dantri, "Dân Trí", "http://m.dantri.com.vn/"));
		arrTem0.add(new Item_GridView(R.drawable.baomoi, "Baomoi.com", "http://www.baomoi.com/"));
		arrTem0.add(new Item_GridView(R.drawable.vietnamnet, "Vietnamnet", "http://vietnamnet.vn/"));
		arrTem0.add(new Item_GridView(R.drawable.tuoitre, "Tuổi trẻ Online", "http://tuoitre.vn/"));
		arrTem0.add(new Item_GridView(R.drawable.thanhnien, "Thanh niên Online","http://www.thanhnien.com.vn/" ));

		MyArrayList<Item_GridView> arrTem1 = new MyArrayList<Item_GridView>();
		arrTem1.setTitile("Tin tức giải trí");
		arrTem1.add(new Item_GridView(R.drawable.zingnew, "Zing News", "http://news.zing.vn/"));
		arrTem1.add(new Item_GridView(R.drawable.kenh14, "Kênh 14", "http://kenh14.vn/"));
		arrTem1.add(new Item_GridView(R.drawable.a24h, "24H.com.vn", "http://24h.com.vn/"));
		arrTem1.add(new Item_GridView(R.drawable.ngoisao, "Ngoisao.net", "http://ngoisao.net/"));
		arrTem1.add(new Item_GridView(R.drawable.yan, "Yan", "http://www.yan.vn/"));
		arrTem1.add(new Item_GridView(R.drawable.tiin, "Tiin.vn", "http://tiin.vn/" ));

		MyArrayList<Item_GridView> arrTem2 = new MyArrayList<Item_GridView>();
		arrTem2.setTitile("Nghe nhạc");
		arrTem2.add(new Item_GridView(R.drawable.zingmp3, "Zing Mp3", "http://mp3.zing.vn/"));
		arrTem2.add(new Item_GridView(R.drawable.nhaccuatui_converted,
				"Nhạc Của Tui", "http://www.nhaccuatui.com/"));
		arrTem2.add(new Item_GridView(R.drawable.vui, "Vui.vn", "http://nhac.vui.vn/"));
		arrTem2.add(new Item_GridView(R.drawable.nhacso, "NhacSo.net", "http://nhacso.net/"));
		arrTem2.add(new Item_GridView(R.drawable.yeucahat, "Yêu Ca Hát", "http://www.yeucahat.com/" ));

		MyArrayList<Item_GridView> arrTem3 = new MyArrayList<Item_GridView>();
		arrTem3.setTitile("Video-Film_Clip");
		arrTem3.add(new Item_GridView(R.drawable.hdonline, "HDonline", "http://hdonline.vn/"));
		arrTem3.add(new Item_GridView(R.drawable.hdviet, "HD Việt", "http://movies.hdviet.com/"));
		arrTem3.add(new Item_GridView(R.drawable.phimdh, "Phim HD", "http://phimhd.vn/"));
		arrTem3.add(new Item_GridView(R.drawable.hayhaytv, "Hay Hay TV", "http://www.hayhaytv.vn/"));
		arrTem3.add(new Item_GridView(R.drawable.phimnhanh, "Phim Nhanh", "http://phimnhanh.net/" ));

		MyArrayList<Item_GridView> arrTem4 = new MyArrayList<Item_GridView>();
		arrTem4.setTitile("Mạng xã hội-diễn đàn");
		arrTem4.add(new Item_GridView(R.drawable.facebook, "Facebook", "http://m.facebook.com/"));
		arrTem4.add(new Item_GridView(R.drawable.ttvnol, "ttvnol", "http://ttvnol.com/"));
		arrTem4.add(new Item_GridView(R.drawable.truongton, "Trường tồn", "http://truongton.net/"));
		arrTem4.add(new Item_GridView(R.drawable.petalia, "Petalia", "http://forum.petalia.org/"));
		arrTem4.add(new Item_GridView(R.drawable.hallostar, "Hallo Star", "http://www.hallostar.vn/"));

		MyArrayList<Item_GridView> arrTem5 = new MyArrayList<Item_GridView>();
		arrTem5.setTitile("Phụ nữ-Gia đình");
		arrTem5.add(new Item_GridView(R.drawable.eva, "Eva"));
		arrTem5.add(new Item_GridView(R.drawable.phunutoday, "Phụ nữ Today"));
		arrTem5.add(new Item_GridView(R.drawable.afamily, "Afamily"));
		arrTem5.add(new Item_GridView(R.drawable.giadinh, "Gia đình"));
		arrTem5.add(new Item_GridView(R.drawable.tretho, "Web trẻ thơ"));
		arrTem5.add(new Item_GridView(R.drawable.lamchame, "Làm cha mẹ"));

		MyArrayList<Item_GridView> arrTem6 = new MyArrayList<Item_GridView>();
		arrTem6.setTitile("Du lịch");
		arrTem6.add(new Item_GridView(R.drawable.phuot, "Phượt", "http://www.phuot.vn/"));
		arrTem6.add(new Item_GridView(R.drawable.dulich, "Du lịc Việt Nam", "http://www.dulichvietnam.com.vn/"));
		arrTem6.add(new Item_GridView(R.drawable.dulichviet, "Du lich Việt", "http://dulichviet.com.vn/"));
		arrTem6.add(new Item_GridView(R.drawable.travel, "Travel", "https://travel.com.vn/"));
		arrTem6.add(new Item_GridView(R.drawable.abay, "Abay", "http://www.abay.vn/"));
		arrTem6.add(new Item_GridView(R.drawable.agoda, "Agoda", "http://www.agoda.vn/"));

		MyArrayList<Item_GridView> arrTem7 = new MyArrayList<Item_GridView>();
		arrTem7.setTitile("Nhiếp ảnh");
		arrTem7.add(new Item_GridView(R.drawable.vnphoto, "VnPhoto", "http://www.vnphoto.net/"));
		arrTem7.add(new Item_GridView(R.drawable.xomnhiepanh, "Xóm nhiếp ảnh", "http://xomnhiepanh.com/"));
		arrTem7.add(new Item_GridView(R.drawable.yeunhiepanh, "Yêu nhiếp ảnh", "http://yeunhiepanh.net/" ));
		arrTem7.add(new Item_GridView(R.drawable.picasa, "Picacsa", "http://picasaweb.google.com/"));
		arrTem7.add(new Item_GridView(R.drawable.flickr, "Flickr", "http://www.flickr.com/"));

		MyArrayList<Item_GridView> arrTem8 = new MyArrayList<Item_GridView>();
		arrTem8.setTitile("Thương mại điện tử");
		arrTem8.add(new Item_GridView(R.drawable.lazada, "Lazada", "http://www.lazada.vn/"));
		arrTem8.add(new Item_GridView(R.drawable.a5giay, "5 Giây", "https://www.5giay.vn/"));
		arrTem8.add(new Item_GridView(R.drawable.thegioididong,
				"Thế giới di động", "https://www.thegioididong.com/"));
		arrTem8.add(new Item_GridView(R.drawable.rongbay, "Rồng Bay", "http://rongbay.com/"));
		arrTem8.add(new Item_GridView(R.drawable.vatgia, "Vật Giá", "http://www.vatgia.com/"));
		arrTem8.add(new Item_GridView(R.drawable.chotot, "Chợ Tốt", "http://www.chotot.vn/"));

		MyArrayList<Item_GridView> arrTem9 = new MyArrayList<Item_GridView>();
		arrTem9.setTitile("Bất động sản");
		arrTem9.add(new Item_GridView(R.drawable.muabannhadat, "MuaBanNhaDat", "http://www.muabannhadat.vn/"));
		arrTem9.add(new Item_GridView(R.drawable.batdongsan,
				"Batdongsan.com.vn"));
		arrTem9.add(new Item_GridView(R.drawable.diaoconline, "Địa ốc Online", "http://www.diaoconline.vn/"));
		arrTem9.add(new Item_GridView(R.drawable.cafeland, "Cafe Land", "http://cafeland.vn/"));
		arrTem9.add(new Item_GridView(R.drawable.landtoday, "Land Today", "http://landtoday.net/"));
		arrTem9.add(new Item_GridView(R.drawable.dothi, "ĐồThị.net", "http://dothi.net/"));

		MyArrayList<Item_GridView> arrTem10 = new MyArrayList<Item_GridView>();
		arrTem10.setTitile("Việc làm");
		arrTem10.add(new Item_GridView(R.drawable.timviecnhanh,
				"Tìm Việc Nhanh", "http://www.timviecnhanh.com/"));
		arrTem10.add(new Item_GridView(R.drawable.vietnamworks,
				"VietNamWorks.com", "http://www.vietnamworks.com/"));
		arrTem10.add(new Item_GridView(R.drawable.careerlink, "Carrer Link", "https://www.careerlink.vn/"));
		arrTem10.add(new Item_GridView(R.drawable.hrchannal, "HRchannel", "http://hrchannels.com/"));
		arrTem10.add(new Item_GridView(R.drawable.jobcville, "jobsVile", "http://jobsville.vn/"));
		arrTem10.add(new Item_GridView(R.drawable.work, "MyWork.vn", "http://mywork.com.vn/"));

		MyArrayList<Item_GridView> arrTem11 = new MyArrayList<Item_GridView>();
		arrTem11.setTitile("Ô tô-Xe máy");
		arrTem11.add(new Item_GridView(R.drawable.otofun, "Oto Fun", "http://news.otofun.net/"));
		arrTem11.add(new Item_GridView(R.drawable.otosaigon, "Ôtô Sài Gòn", "https://www.otosaigon.com/"));
		arrTem11.add(new Item_GridView(R.drawable.bonbanh, "Bonbanh.com", "http://www.bonbanh.com/"));
		arrTem11.add(new Item_GridView(R.drawable.choxe, "Chợ Xe", "http://choxe.net/"));
		arrTem11.add(new Item_GridView(R.drawable.autopro, "Auto pro", "http://autopro.com.vn/"));
		arrTem11.add(new Item_GridView(R.drawable.bikervietnam,
				"Biker Việt Nam", "http://www.bikervietnam.com/"));

		MyArrayList<Item_GridView> arrTem12 = new MyArrayList<Item_GridView>();
		arrTem12.setTitile("Máy tính-Công nghệ");
		arrTem12.add(new Item_GridView(R.drawable.tinhte, "Tinh tế", "https://www.tinhte.vn"));
		arrTem12.add(new Item_GridView(R.drawable.genk, "GenK", "http://genk.vn/"));
		arrTem12.add(new Item_GridView(R.drawable.vnzoom, "VN-Zoom", "http://www.vn-zoom.com/"));
		arrTem12.add(new Item_GridView(R.drawable.vozforums, "vozForums", "http://vozforums.com/"));
		arrTem12.add(new Item_GridView(R.drawable.techz, "TechZ","http://www.techz.vn/" ));
		arrTem12.add(new Item_GridView(R.drawable.donwload, "download.com.vn"));

		MyArrayList<Item_GridView> arrTem13 = new MyArrayList<Item_GridView>();
		arrTem13.setTitile("Sức khỏe");
		arrTem13.add(new Item_GridView(R.drawable.suckheodoisong,
				"Sức khỏe đời sống", "http://suckhoedoisong.vn/"));
		arrTem13.add(new Item_GridView(R.drawable.thaythuoccuaban,
				"Thầy thuốc của bạn", "http://thaythuoccuaban.com/"));
		arrTem13.add(new Item_GridView(R.drawable.chuyengiasuckhoe,
				"Chuyên gia sức khỏe", "http://news.bacsi.com/"));
		arrTem13.add(new Item_GridView(R.drawable.suckheocondong,
				"Sức khỏe cộng đồng", "http://www.suckhoecongdong.com/"));
		arrTem13.add(new Item_GridView(R.drawable.bacsigiadinh,
				"Bác sĩ gia đình", "http://www.bacsigiadinh.com/"));
		arrTem13.add(new Item_GridView(R.drawable.camnangthuoc,
				"Cẩm nang thuốc", "http://www.camnangthuoc.vn/"));

		MyArrayList<Item_GridView> arrTem14 = new MyArrayList<Item_GridView>();
		arrTem14.setTitile("Học tập-tài liệu");
		arrTem14.add(new Item_GridView(R.drawable.violet, "Thư viện Violet", "http://tailieu.vn/"));
		arrTem14.add(new Item_GridView(R.drawable.violet,
				"Violet", "http://violet.vn/main/"));
		arrTem14.add(new Item_GridView(R.drawable.ioe, "IOE", "http://ioe.go.vn/"));
		arrTem14.add(new Item_GridView(R.drawable.tienganh123, "Học tiếng Anh", "http://www.tienganh123.com/"));
		arrTem14.add(new Item_GridView(R.drawable.hocmai, "hocjmai.vn", "http://hocmai.vn/"));
		arrTem14.add(new Item_GridView(R.drawable.googledich, "Google Dịch", "https://translate.google.com.vn/"));

		MyArrayList<Item_GridView> arrTem15 = new MyArrayList<Item_GridView>();
		arrTem15.setTitile("Đọc truyện");
		arrTem15.add(new Item_GridView(R.drawable.vechai, "Ve chai", "http://vechai.info/"));
		arrTem15.add(new Item_GridView(R.drawable.truyentranhonline,
				"Truyện Tranh Online", "http://truyentranhtuan.com/"));
		arrTem15.add(new Item_GridView(R.drawable.blogtruyen, "Blog Truyện", "http://blogtruyen.com/"));
		arrTem15.add(new Item_GridView(R.drawable.truyentranhonline,
				"Truyện Hixx", "http://truyen2.hixx.info/"));
		arrTem15.add(new Item_GridView(R.drawable.itruyen, "iTruyện", "http://www.itruyen.net/"));
		arrTem15.add(new Item_GridView(R.drawable.vnthuquan, "Vn Thư quán", "http://vnthuquan.net/"));

		MyArrayList<Item_GridView> arrTem16 = new MyArrayList<Item_GridView>();
		arrTem16.setTitile("Dịch vụ tiện ích");
		arrTem16.add(new Item_GridView(R.drawable.googlemap, "Bản đồ Google", "https://www.google.com/maps/"));
		arrTem16.add(new Item_GridView(R.drawable.ketquasoso, "Kết quả sổ số", "http://ketqua.net/"));
		arrTem16.add(new Item_GridView(R.drawable.dubaothoitiet,
				"Dự báo thời tiết", "http://www.nchmf.gov.vn/"));
		arrTem16.add(new Item_GridView(R.drawable.lichphatsong,
				"Lịch phát sóng", "http://vtv.vn/"));
		arrTem16.add(new Item_GridView(R.drawable.blogphuthuy,
				"Blog phong thủy", "http://www.blogphongthuy.com/"));
		arrTem16.add(new Item_GridView(R.drawable.diemdatatm, "Diểm dặt ATM", "http://www.24h.com.vn/ttcb/atm/"));

		MyArrayList<Item_GridView> arrTem17 = new MyArrayList<Item_GridView>();
		arrTem17.setTitile("Games");
		arrTem17.add(new Item_GridView(R.drawable.gamk, "GameK", "http://m.gamek.vn/"));
		arrTem17.add(new Item_GridView(R.drawable.infogame, "Ingoforgame", "http://infogame.vn/"));
		arrTem17.add(new Item_GridView(R.drawable.gamevn, "GameVN", "http://forum.gamevn.com/"));
		arrTem17.add(new Item_GridView(R.drawable.vuigame, "vuigame.vn", "http://vuigame.vn/"));
		arrTem17.add(new Item_GridView(R.drawable.game52la, "Game 52la.vn", "http://www.52la.vn/"));
		arrTem17.add(new Item_GridView(R.drawable.vuongquocgame,
				"Vương quốc game", "http://www.vuongquocgame.com/"));

		MyArrayList<Item_GridView> arrTem18 = new MyArrayList<Item_GridView>();
		arrTem18.setTitile("Thể thao");
		arrTem18.add(new Item_GridView(R.drawable.bongdaplus, "Bóng đá plus +","http://bongdaplus.vn/" ));
		arrTem18.add(new Item_GridView(R.drawable.bongda, "Bongda.com.vn","http://bongda.com.vn/" ));
		arrTem18.add(new Item_GridView(R.drawable.bongdaso, "Bóng đá số", "http://bongdaso.com/"));
		arrTem18.add(new Item_GridView(R.drawable.livescore, "LiveScores", "http://livescores.com/"));
		arrTem18.add(new Item_GridView(R.drawable.tructiepbongda,
				"Trực tiếp bóng đá", "http://tructiepbongda.com/"));
		arrTem18.add(new Item_GridView(R.drawable.linksopcast_converted,
				"Link Sopcast", "http://www.8bongda.com/"));

		MyArrayList<Item_GridView> arrTem19 = new MyArrayList<Item_GridView>();
		arrTem19.setTitile("Tài chính kinh doanh");
		arrTem19.add(new Item_GridView(R.drawable.cafef, "Cafe F", "http://cafef.vn/"));
		arrTem19.add(new Item_GridView(R.drawable.vneconomy, "VnEconomy", "http://vneconomy.vn/"));
		arrTem19.add(new Item_GridView(R.drawable.stockbiz, "StockBiz", "http://www.stockbiz.vn/"));
		arrTem19.add(new Item_GridView(R.drawable.vietstock, "VietStock", "http://vietstock.vn/"));
		arrTem19.add(new Item_GridView(R.drawable.giavang, "Giá vàng", "http://www.giavang.net/"));
		arrTem19.add(new Item_GridView(R.drawable.a24h, "Ngoại tệ", "http://www.24h.com.vn/ttcb/"));

		arrViewPage.add(arrTem0);
		arrViewPage.add(arrTem1);
		arrViewPage.add(arrTem2);
		arrViewPage.add(arrTem3);
		arrViewPage.add(arrTem4);
		arrViewPage.add(arrTem5);
		arrViewPage.add(arrTem6);
		arrViewPage.add(arrTem7);
		arrViewPage.add(arrTem8);
		arrViewPage.add(arrTem9);
		arrViewPage.add(arrTem10);
		arrViewPage.add(arrTem11);
		arrViewPage.add(arrTem12);
		arrViewPage.add(arrTem13);
		arrViewPage.add(arrTem14);
		arrViewPage.add(arrTem15);
		arrViewPage.add(arrTem16);
		arrViewPage.add(arrTem17);
		arrViewPage.add(arrTem18);
		arrViewPage.add(arrTem19);

	}

	private class ReaderViewPagerTransformer implements
			ViewPager.PageTransformer {
//		static enum TransformType {
//			FLOW, 
//			DEPTH, 
//			ZOOM, 
//			SLIDE_OVER 
//		};
//		
//		private final TransformType mTransformType;
//
//		ReaderViewPagerTransformer(TransformType transformType) {
//			mTransformType = transformType;
//		}

		private static final float MIN_SCALE_DEPTH = 0.75f;
		private static final float MIN_SCALE_ZOOM = 0.85f;
		private static final float MIN_ALPHA_ZOOM = 0.5f;
		private static final float SCALE_FACTOR_SLIDE = 0.85f;
		private static final float MIN_ALPHA_SLIDE = 0.35f;
		@Override
		public void transformPage(View page, float position) {
			final float alpha;
			final float scale;
			final float translationX;

//			switch (mTransformType) {
//			case FLOW:
//				page.setRotationY(position * -30f);
//				return;
//
//			case SLIDE_OVER:
//				if (position < 0 && position > -1) {
//					// this is the page to the left
//					scale = Math.abs(Math.abs(position) - 1)
//							* (1.0f - SCALE_FACTOR_SLIDE) + SCALE_FACTOR_SLIDE;
//					alpha = Math.max(MIN_ALPHA_SLIDE, 1 - Math.abs(position));
//					int pageWidth = page.getWidth();
//					float translateValue = position * -pageWidth;
//					if (translateValue > -pageWidth) {
//						translationX = translateValue;
//					} else {
//						translationX = 0;
//					}
//				} else {
//					alpha = 1;
//					scale = 1;
//					translationX = 0;
//				}
//				break;
//
//			case DEPTH:
				if (position > 0 && position < 1) {
					// moving to the right
					alpha = (1 - position);
					scale = MIN_SCALE_DEPTH + (1 - MIN_SCALE_DEPTH)
							* (1 - Math.abs(position));
					translationX = (page.getWidth() * -position);
				} else {
					// use default for all other cases
					alpha = 1;
					scale = 1;
					translationX = 0;
				}
////				break;
//
//			case ZOOM:
//				if (position >= -1 && position <= 1) {
//					scale = Math.max(MIN_SCALE_ZOOM, 1 - Math.abs(position));
//					alpha = MIN_ALPHA_ZOOM + (scale - MIN_SCALE_ZOOM)
//							/ (1 - MIN_SCALE_ZOOM) * (1 - MIN_ALPHA_ZOOM);
//					float vMargin = page.getHeight() * (1 - scale) / 2;
//					float hMargin = page.getWidth() * (1 - scale) / 2;
//					if (position < 0) {
//						translationX = (hMargin - vMargin / 2);
//					} else {
//						translationX = (-hMargin + vMargin / 2);
//					}
//				} else {
//					alpha = 1;
//					scale = 1;
//					translationX = 0;
//				}
//				break;
//
//			default:
//				return;
//			}

			page.setAlpha(alpha);
			page.setTranslationX(translationX);
			page.setScaleX(scale);
			page.setScaleY(scale);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
   @Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	super.onActivityResult(requestCode, resultCode, data);
	if ( requestCode == Dialog_Menu.RESULT_SET_POSISION && resultCode == Activity.RESULT_OK) {
		
		viewPage.setCurrentItem(Integer.parseInt(data.getStringExtra("ACTION")));
	}
}
}
