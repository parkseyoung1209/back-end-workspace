package com.kh.practice.exam.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import com.kh.practice.exam.model.Song;

public class SongController{
	private ArrayList<Song> list = new ArrayList();
	private Song song = new Song();
	
	public void playlist(String title, String singer) {
		song.setTitle(title);
		song.setSinger(singer);
	}
	public void songlistF(String title, String singer) {
		song.setTitle(title);
		song.setSinger(singer);
		list.add(list.size() ,new Song(song.getTitle(),song.getSinger()));
	}
	public void songlistL(String title, String singer) {
		song.setTitle(title);
		song.setSinger(singer);
		list.add(0 ,new Song(song.getTitle(),song.getSinger()));
	}
	public void titleSearch(String titleSearch) {
		song.setTitleSearch(titleSearch);
		for(int i = 0; i<list.size(); i++) {
			StringTokenizer st = new StringTokenizer(list.get(i).getTitle(), " ");
			if(st.nextToken().equals(song.getTitleSearch())) {
				System.out.println(list.get(i) + "을 검색했습니다.");
			}
			else {
				System.out.println("찾지 못했습니다");
			}
			
		}
	}
	public void titleDelete(String titleSearch) {
		song.setTitleSearch(titleSearch);
		for(int i = 0; i<list.size(); i++) {
			if(titleSearch.equals(list.get(i).getTitle())) {
				list.remove(i);
				System.out.println(list.get(i) +"을 삭제 했습니다.");
			}else {
				System.out.println("삭제할 곡이 없습니다.");
			}
		}
	}
	public void titleReplace(String titleSearch, String title, String singer) {
		song.setTitle(title);
		song.setSinger(singer);
		song.setTitleSearch(titleSearch);
		for(int i = 0; i<list.size(); i++) {
			if(titleSearch.equals(list.get(i).getTitle())) {
				list.get(i);
				list.set(i, new Song(song.getTitle(), song.getSinger()));
			}else {
				System.out.println("수정할 곡을 찾지 못했습니다.");
			}
		}
	}
	public void sort(int menu) {
		song.setMenu(menu);
        Collections.sort(list, new Comparator<Song>() {
            @Override
            public int compare(Song s1, Song s2) {
            	if(song.getMenu() == 7) {
                return s2.getSinger().compareTo(s1.getSinger());
            	}else if(song.getMenu() == 8) {
            	return s1.getSinger().compareTo(s2.getSinger());	
            	}
            	return 0;
            }
        }); // 직접 구현은 못함
    }
	public ArrayList<Song> info() {
		return list;
	}
}
