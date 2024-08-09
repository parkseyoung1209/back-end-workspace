package com.semi.youtube.model.vo;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	private int commentCode;
	private String commentText;
	private LocalDateTime commenDate;
	private String id;
	private int videoCode;
	private int parentCode;
}
