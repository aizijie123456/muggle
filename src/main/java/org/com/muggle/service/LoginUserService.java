package org.com.muggle.service;

import javax.annotation.Resource;

import org.com.muggle.dao.IUserDao;
import org.com.muggle.model.User;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class LoginUserService implements UserDetailsService {

	@Resource
	private IUserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		UserDetails details = null;
		try {
			User user = userDao.selectByPrimaryKey(1);

			details = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
					AuthorityUtils.createAuthorityList("ROLE_USER"));

		} catch (UsernameNotFoundException usernameNotFoundException) {
			usernameNotFoundException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return details;
	}

}
