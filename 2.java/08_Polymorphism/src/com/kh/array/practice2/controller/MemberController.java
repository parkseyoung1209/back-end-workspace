package com.kh.array.practice2.controller;



import com.kh.array.practice2.model.Member;

public class MemberController{
	
	public int count = 0;
	private Member[] arr = new Member[3];
	
	
	public void MemberController(Member m) {
		arr[count++] = new Member(m.getId(), m.getName(),m.getPwd(),m.getEmail(),m.getGender(),m.getAge());
		
	}

	
	public int checkId(String id) {
		// 멤버의 index 찾기
		for(int i = 0; i <arr.length; i++) {
			if(arr[i]!=null && arr[i].getId().equals(id)) {
				return i;
			}
		}return -1;
	}
	public void updateMember(String id, String name, String pwd, String email) {
		int index = checkId(id);
		arr[index].setName(name);
		arr[index].setPwd(pwd);
		arr[index].setEmail(email);
	}
	
	public Member[] printAll() {
		return arr;
	}
	
	
}
