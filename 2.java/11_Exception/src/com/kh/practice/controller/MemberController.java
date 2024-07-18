package com.kh.practice.controller;



import com.kh.practice.exception.DuplicateNameException;
import com.kh.practice.exception.RecordNotFoundException;
import com.kh.practice.model.Member;

public class MemberController{
	
	public int count = 0;
	private Member[] arr = new Member[3];
	
	
	public void MemberController(Member m) throws DuplicateNameException {
		
		int index = checkId(m.getId());
		
		if(index == -1) {
			arr[count++] = new Member(m.getId(), m.getName(),m.getPwd(),m.getEmail(),
					m.getGender(),m.getAge());
		}else {
			// 회원이 기존에 있는 경우
			throw new DuplicateNameException();
		}
	}

	
	public int checkId(String id) {
		// 멤버의 index 찾기
		for(int i = 0; i <arr.length; i++) {
			if(arr[i]!=null && arr[i].getId().equals(id)) {
				return i;
			}
		}return -1;
	}
	public int checkUpdateId(String id) throws RecordNotFoundException {
		// 멤버의 index 찾기
		for(int i = 0; i <arr.length; i++) {
			if(arr[i]!=null && arr[i].getId().equals(id)) {
				return i;
			}else {
				throw new RecordNotFoundException();
			}
		}return -1;
	}
	public void updateMember(String id, String name, String pwd, String email) throws RecordNotFoundException {
		int index = checkUpdateId(id);
		arr[index].setName(name);
		arr[index].setPwd(pwd);
		arr[index].setEmail(email);
	}
	
	public Member[] printAll() {
		return arr;
	}
	
	
}
