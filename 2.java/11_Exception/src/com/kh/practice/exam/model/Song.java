package com.kh.practice.exam.model;

public class Song implements Comparable<Song>{
	private String title;
	private String singer;
	private String titleSearch;
	private int menu;
	
	public int getMenu() {
		return menu;
	}
	public void setMenu(int menu) {
		this.menu = menu;
	}
	public Song() {
		
	}
	public Song(String title, String singer) {
		this.title = title;
		this.singer = singer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	public String getTitleSearch() {
		return titleSearch;
	}
	public void setTitleSearch(String titleSearch) {
		this.titleSearch = titleSearch;
	}
	@Override
	public String toString() {
		return singer + "-" + title;
	}
	
	@Override
	public int compareTo(Song s) {
		return this.title.compareTo(s.title);
	}
	
	
}
