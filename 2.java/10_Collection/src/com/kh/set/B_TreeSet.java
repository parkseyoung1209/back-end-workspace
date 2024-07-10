package com.kh.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.kh.set.model.Person;

/*
 * Set의 특징
 * - 중복 없음
 * - 순서 없음
 * - interface로 취급
 * 
 * 
 * TreeSet
 * - 저장과 동시에 자동 오름차순 정렬 (HashSet + 정렬)
 * - HashSet보다 데이터 추가, 삭제에 시간이 더 걸림
 */
// HashSet : Set 인터페이스를 구현한 대표적인 컬렉션 클래스
public class B_TreeSet {
	
	public void method1() {
		HashSet<String> set = new HashSet();
		
		set.add("이제훈");
		set.add("구교환");
		set.add("홍사빈");
		set.add("이제훈");
		set.add("이제훈");
		
		System.out.println(set); // 중복된 데이터는 제거시키고 순서가 무질서하게 출력된다.
		System.out.println(set.size());//size 역시 중복된 데이터들을 취급하지 않고 계산되어서 3이 뜬다
		System.out.println(set.contains("구교환"));
		
		set.remove("홍사빈");
		System.out.println(set);
		
		set.clear();
		System.out.println("비어있는지? " + set.isEmpty());
	}
	public void method2() {
		TreeSet<Person> set = new TreeSet<>();
		
		set.add(new Person("이제훈",40));
		set.add(new Person("구교환",41));
		set.add(new Person("홍사빈",27));
		set.add(new Person("구교환",41));
		set.add(new Person("구교환",41));
		// 객체의 주소값을 가지고 비교하기 때문에 모두 다른 객체로 인식해서 중복 제거 X
		// --> 객체에 hashCode, equals 매서드 재정의 자동 생성
		System.out.println(set);
		
		for(Person p : set) {
			System.out.println(p);
		}
		
		/*
		 * 	Iterator
		 * - 컬렉션에 저장된 요소를 접근하는데 사용하는 인터페이스
		 * - iterator()를 호출해서 Iterator를 구현한 객체를 얻어서 사용
		 */
		Iterator<Person> it = set.iterator();
		while(it.hasNext()) { // 읽어올 요소가 있는지 확인
			System.out.println(it.next()); // 다음 요소를 읽어옴
		}
	}
	public static void main(String[] args) {
		B_TreeSet a = new B_TreeSet();
//		a.method1();
		a.method2();
	}

}
