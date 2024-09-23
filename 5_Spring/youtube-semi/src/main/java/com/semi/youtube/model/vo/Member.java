package com.semi.youtube.model.vo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member implements UserDetails{
	private String id;
	private String password;
	private String email;
	private String phone;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> authList = new ArrayList<>();
		authList.add(new SimpleGrantedAuthority(phone));
		return authList;
	}
	@Override
	public String getUsername() {
		return id;
	}
}
