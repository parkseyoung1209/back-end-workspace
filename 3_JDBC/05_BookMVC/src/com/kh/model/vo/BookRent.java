package com.kh.model.vo;



import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRent {
	// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한 조회
	private int rentNo;
	private String bkTitle;
	private String bkAuthor;
	private Date rentDate;
	private Date enrollDate;
}
