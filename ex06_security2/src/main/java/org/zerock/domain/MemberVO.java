package org.zerock.domain;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*userid varchar2(50) not null primary key,
userpw varchar2(100) not null,
username varchar2(100) not null,
regdate date default sysdate, 
updatedate date default sysdate,
enabled char(1) default '1');*/

@Data
public class MemberVO implements UserDetails{
	
	private String userid;
	private String userpw;
	private String name;
	private Date regdate;
	private Date updatedate;
	private boolean enabled;
	private List<AuthVO>authList;
	@Override
	//               
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//                                                              
		return authList.stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth()))
				.collect(Collectors.toList());
	}
	@Override
	public String getPassword() {
		return userpw;
	}
	@Override
	public String getUsername() {
		return userid;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return enabled;
		
	}

}
