package com.jsp.LibraryManagement_System.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jsp.LibraryManagement_System.entity.UserInfo;

import lombok.AllArgsConstructor;
@AllArgsConstructor
// To take username,password and role from database for authentication
public class UserInfoUserDetails implements UserDetails {
	
	private UserInfo userInfo;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = userInfo.getRole();
		List<SimpleGrantedAuthority> grantedAuthorities =
				new ArrayList<SimpleGrantedAuthority>();
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
		grantedAuthorities.add(authority);
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userInfo.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userInfo.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
