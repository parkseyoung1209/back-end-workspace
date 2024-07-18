package person.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import person.model.Person;

public class PersonController {
	Scanner sc = new Scanner(System.in);
	Person person = new Person();
	ArrayList<Person> list = new ArrayList<>();
	// 리턴 타입이나 매개변수(파라미터) 자유롭게 변경 가능!
	// 메서드 추가 가능
		/*
		 * 1. 드라이버 로딩
		 * 2. DB 연결
		 * 3. PreparedStatement - 쿼리
		 * 4. 쿼리 실행
		 */
		
		// person 테이블에 데이터 추가 - INSERT
		
		public PersonController() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		}
		public Connection getConnect() throws SQLException {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "qwer1234");
		}
		public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
			ps.close();
			conn.close();
		}
		public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
			rs.close();
			closeAll(ps,conn);
		}
		public void addPerson() {
			try {
				System.out.print("이름을 입력해주세요 : ");
				String name = sc.nextLine();
				person.setName(name);
				System.out.print("나이를 입력해주세요 : ");
				int age = Integer.parseInt(sc.nextLine());
				person.setAge(age);
				System.out.print("주소를 입력해주세요 : ");
				String addr = sc.nextLine();
				person.setAddr(addr);
				System.out.println(name + "님 회원가입 완료!");
				Connection conn = getConnect();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO person(name, age, addr) VALUES(?,?,?)");
				ps.setString(1, person.getName());
				ps.setInt(2, person.getAge());
				ps.setString(3, person.getAddr());
				ps.execute();
				closeAll(ps,conn);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		// person 테이블에 데이터 수정 - UPDATE
		public void updatePerson() {
			try {
				String userName = "";
				System.out.print("바꿀 회원의 아이디를 입력해주세요 : ");
				int id = Integer.parseInt(sc.nextLine());
				person.setId(id);
				System.out.println("바꾸 실 항목을 골라주세요");
				System.out.println("1.이름");
				System.out.println("2.나이");
				System.out.println("3.주소");
				int num = Integer.parseInt(sc.nextLine());
				switch(num) {
				case 1 :
					System.out.print("새롭게 바꾸실 이름을 입력해주세요 : ");
					String name = sc.nextLine();
					userName = name;
					person.setName(name);
					System.out.println(userName +"님 정보 수정 완료!");
					break;
				case 2 :
					System.out.print("새롭게 바꾸실 나이를 입력해주세요 : ");
					int age = Integer.parseInt(sc.nextLine());
					person.setAge(age);
					System.out.println(userName +"님 정보 수정 완료!");
					break;
				case 3 :
					System.out.print("새롭게 바꾸실 나이를 입력해주세요 : ");
					String addr = sc.nextLine();
					person.setAddr(addr);
					System.out.println(userName +"님 정보 수정 완료!");
					break;
				}
				Connection conn = getConnect();
				if(num == 1) {
					PreparedStatement ps = conn.prepareStatement("UPDATE person SET name = ? WHERE id = ?");
					ps.setString(1, person.getName());
					ps.setInt(2, person.getId());
					ps.execute();
					closeAll(ps,conn);
				}else if(num == 2) {
					PreparedStatement ps = conn.prepareStatement("UPDATE person SET age = ? WHERE id = ?");
					ps.setInt(1, person.getAge());
					ps.setInt(2, person.getId());
					ps.execute();
					closeAll(ps,conn);
				}else if(num == 3) {
					PreparedStatement ps = conn.prepareStatement("UPDATE person SET addr = ? WHERE id = ?");
					ps.setString(1, person.getAddr());
					ps.setInt(2, person.getId());
					ps.execute();
					closeAll(ps,conn);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		// person 테이블에 데이터 삭제 - DELETE
		public void removePerson() {
			try {
				String name = "";
				System.out.print("탈퇴 시킬 회원의 아이디를 입력해주세요 : ");
				int id = Integer.parseInt(sc.nextLine());
				person.setId(id);
				for(int i = 0; i<list.size(); i++) {
					if(list.get(i).getId() == person.getId()) {
						name = list.get(i).getName();
					}
				}
				System.out.println(name+"님, 회원 탈퇴 완료!");
				Connection conn = getConnect();
				PreparedStatement ps = conn.prepareStatement("DELETE FROM person WHERE id = ? ");
				ps.setInt(1, person.getId());
				ps.execute();
				closeAll(ps,conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		// person 테이블에 있는 전체 보여주기 - SELECT
		public ArrayList<Person> searchAllPerson() {
			try {
				Connection conn = getConnect();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM person ");
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Person person = new Person();
					person.setId(rs.getInt("id"));
					person.setName(rs.getString("name"));
					person.setAge(rs.getInt("age"));
					person.setAddr(rs.getString("addr"));
					list.add(person);
				}
				closeAll(rs ,ps,conn);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return list;
		}
		
		// person 테이블에서 데이터 한개만 가져오기 - SELECT
		public void searchPerson() {
			try {
				System.out.print("조회할 회원의 아이디를 입력해주세요 : ");
				int id = Integer.parseInt(sc.nextLine());
				person.setId(id);
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "qwer1234");
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM person WHERE id = ? ");
				ps.setInt(1, person.getId());
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					int userid= rs.getInt("id");
					String name = rs.getString("name");
					int age = rs.getInt("age");
					String addr = rs.getString("addr");
					System.out.println(userid+ "/ " + name + " / " + age + " / " + addr);
					closeAll(rs,ps,conn);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		}
		
}
