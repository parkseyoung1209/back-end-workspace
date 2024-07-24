package com.kh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookJoin {
	private String bkTitle;
	private String bkAuthor;
	private int bkNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private int rentNo;
	private String rentDate;
	
}
