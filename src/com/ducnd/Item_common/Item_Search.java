package com.ducnd.Item_common;

public class Item_Search {
	private String name;
	private  int idIcon;
	private String link;
	public Item_Search( int idIcon, String name, String link ) {
		this.idIcon = idIcon;
		this.name = name;
		this.link = link;
	}
	public Item_Search( int idIcon, String name ) {
		this.idIcon = idIcon;
		this.name = name;
		this.link = "";
	}
	public Item_Search( String name) {
		this.idIcon = -1;
		this.name = name;
	}
	public Item_Search() {
		this.idIcon = -1;
		this.name = "";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdIcon() {
		return idIcon;
	}
	public void setIdIcon(int idIcon) {
		this.idIcon = idIcon;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
}
