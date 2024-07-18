package com.kh.stream.terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.kh.stream.model.Student;

/*
 * 수집
 * - 최종 처리 기능으로 필터링 또는 매핑한 요ㅗ들을 새로운 컬렉션으로 담아서 리턴하는
 * 	 collect() 제공
 */
public class C_Collect {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("김현호", 20, "남자", 80, 50),
				new Student("우현성", 19, "남자", 75, 60),
				new Student("김경주", 18, "여자", 50, 100),
				new Student("주준영", 21, "남자", 60, 45),
				new Student("조창현", 20, "남자", 70, 90),
				new Student("김진주", 22, "여자", 80, 50)
				);
		
		// List 컬렉션으로 수집 -> 수학 점수가 80점 이상인 사람들만
		List<Student> list = students.stream().filter(s -> s.getMath()>=80)
						.collect(Collectors.toCollection(() -> new ArrayList<>()));
		System.out.println(list);
		// Set 컬렉션으로 수집 -> 고등학생인 사람들만, Hashset
		Set<Student> set = students.stream().filter(s -> s.getAge()<20 && s.getAge()>=17)
							.collect(Collectors.toCollection(() -> new HashSet<>()));
		System.out.println(set);
		// Map 컬렉션으로 수집 -> 키 : 이름, 값 : 나이(toMap)
		Map<String, Integer> map = students.stream()
				.collect(Collectors.toMap(s -> s.getName(), n->n.getAge()));
		System.out.println(map);
	}

}
