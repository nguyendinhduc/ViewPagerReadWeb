package com.ducnd.Item_common;

public class Item_GridView {
	private String name, link;
	private int idImageIcon;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getIdImageIcon() {
		return idImageIcon;
	}

	public void setIdImageIcon(int idImageIcon) {
		this.idImageIcon = idImageIcon;
	}

	public Item_GridView() {

	}

	public Item_GridView(int idImageIcon, String name, String link) {
		this.idImageIcon = idImageIcon;
		this.name = name;
		this.link = link;
	}
	public Item_GridView(int idImageIcon, String name ) {
		this.idImageIcon = idImageIcon;
		this.name = name;
		this.link = "";
	}
	public Item_GridView(String name) {
		this.name = name;
		this.idImageIcon = -1;
		this.link = "";
	}


}
