package com.kh.time;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
/*
 * java.time 패키지
 * - Date와 Calendar의 단점을 개선한 새로운 클래스들을 제공(JDK 1.8)
 * 
 */

public class B_Time {
	Scanner sc = new Scanner(System.in);
	public void method1() {
		/*
		 * LocalDateTime
		 * - 날짜와 시간 정보를 모두 저장
		 * 
		 * 
		 */
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		// 날짜 지정
		LocalDateTime when = LocalDateTime.of(2024, 7, 11, 14, 6, 0);
		System.out.println(when);
		
		//	ZoneDateTime : LocalDateTime + 시간대까지
		System.out.println("ZoneDateTime : " + ZonedDateTime.now());
		
		// 년, 월, 일, 요일, 시, 분, 초
		System.out.println(now.getYear() + "년");
		System.out.println(now.getMonth());
		System.out.println(now.getMonthValue());
		System.out.println(now.getDayOfMonth());
		System.out.println(now.getDayOfWeek()); // 요일을 알려줌
		System.out.println(now.getHour());
		System.out.println(now.getMinute());
		System.out.println(now.getSecond());
		
		System.out.println();
		// 날짜 조작
		LocalDateTime plusDays = now.plusDays(1).plusMonths(2);
		System.out.println("plus : " + plusDays);
		
		LocalDateTime minusDays = now.minusYears(1).minusMonths(1).minusDays(1);
		System.out.println(minusDays);
		
		LocalDateTime withDays = now.withYear(2025).withMonth(8).withDayOfMonth(10);
		System.out.println(withDays);
		
		System.out.println(now.isAfter(withDays)); // 오늘이 해당 날짜보다 이후인가?
		System.out.println(now.isBefore(withDays)); // true
		
		//LocalDate : 날짜 정보를 저장
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		localDate = LocalDate.of(2024, 11, 13);
		System.out.println(localDate);
		
		//LocalTime : 시간 정보만 저장
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		localTime = LocalTime.of(17, 49, 59);
		System.out.println(localTime);
	}
	/*
	 * Period와 Duration
	 * - 날짜와 시간 간격을 표현하기 위한 클래스
	 * - Period : 두 날짜 간의 차이
	 * - Duration : 시간의 차이
	 */
	public void method2() {
		
		LocalDate date1 = LocalDate.of(2024, 1, 1);
		LocalDate date2 = LocalDate.of(2025, 12, 31);
		
		Period pe = Period.between(date1, date2);
		System.out.println(pe);
		
		System.out.println("yers : " + pe.getYears());
		System.out.println("months : " + pe.getMonths());
		System.out.println("days : " + pe.getDays());
		
		System.out.println("yers : " + pe.get(ChronoUnit.YEARS));
		System.out.println("months : " + pe.get(ChronoUnit.MONTHS));
		System.out.println("days : " + pe.get(ChronoUnit.DAYS));
		
		LocalTime time1 = LocalTime.of(1, 2, 3);
		LocalTime time2 = LocalTime.of(11, 59, 59);
		
		Duration du = Duration.between(time1, time2);
		System.out.println(du);
		
		System.out.println("hours : " + du.toHours());
		System.out.println("minutes : " + du.toMinutes());
		System.out.println("seconds : " + du.toSeconds());
		System.out.println(du.toMinutesPart());
		
		// 문자열을 LocalDate 객체로 파싱
		LocalDate date = LocalDate.parse("2024-11-13");
		System.out.println(date);
		
		// DateTimeFormatter
		// 날짜와 시간을 포맷팅(Formatting)된 문자열로 변환하는 메서드를 제공하는 클래스
		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		String formatDate = today.format(dtf);
		System.out.println(formatDate);
	}
	/*
	 * D-Day 계산기 : 년월일(각각 입력)을 입력하여 디데이 계산
	 * chronounit.DAYS.between(날짜,날짜)
	 * 또는 날짜.until(날짜, ChronoUnit.DAYS)
	 */
	public void method3() {
		System.out.print("연도 입력 : ");
		int years = Integer.parseInt(sc.nextLine());
		System.out.print("해당 월 입력 : ");
		int months = Integer.parseInt(sc.nextLine());
		System.out.print("해당 일 입력 : ");
		int days = Integer.parseInt(sc.nextLine());
		
		try {
			LocalDate date1 = LocalDate.of(years, months, days);
			LocalDate today = LocalDate.now();
			long ch = ChronoUnit.DAYS.between(date1, today);
			if(ch == 0) {
				System.out.println("D-Day");
			}else if (ch < 0) {
				System.out.println("D"+ch);
			}else {
				System.out.println("D+"+ch);
			}

			
		}catch(DateTimeException e) {
			System.out.println("잘못 입력했습니다.");
			method3();
		}
		
	}
	public static void main(String[] args) {
		B_Time b = new B_Time();
//		b.method1();
//		b.method2();
		b.method3();
	}

}
