package person.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
// @AllArgsConstructor - 모든 필드값 피라미터를 받는 생성자
// @NoArgsConstructor - 기본 생성자
// @Data : 기본 생성자와 AllArgsConstructor를 제외 나머지들 한꺼번에 만들어주는 어노테이션
// @RequiredArgsConstructor - 필드값에 final이 붙어있거나 @NoNnull이 붚어있는 필드들을 파라미터로 받는 생성자
// @AllArgsConstructor - 모든 필드값 파라미터로 받는 생성자
// @Setter - Setter
// @Getter - Getter
// @ToString - toString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
	
	private int id;
	private String name;
	private int age;
	private String addr;

}
