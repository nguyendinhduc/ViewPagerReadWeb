package com.ducnd.Item_common;

public class ItemMenu {
	private String iconTitle;
	private String title;
	private int position;
	public ItemMenu(String iconTitle, String title, int position ) {
		this.position = position;
		this.title = title;
		this.iconTitle = iconTitle;
	}
	public ItemMenu(String title, int position ) {
		this.position = position;
		this.title = "";
		this.iconTitle = "";
	}
	public ItemMenu(String title ) {
		this.position = -1;
		this.title = title;
		this.iconTitle = null;
	}
	public ItemMenu(int position ) {
		this.position = position;
		this.title = "";
		this.iconTitle = "";
	}
	public String getIconTitle() {
		return iconTitle;
	}
	public void setIconTitle(String iconTitle) {
		this.iconTitle = iconTitle;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	
}
