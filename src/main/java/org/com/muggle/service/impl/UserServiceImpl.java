package org.com.muggle.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

//import org.com.muggle.core.DatabaseContextHolder;
import org.com.muggle.dao.IUserDao;
import org.com.muggle.model.User;
import org.com.muggle.service.IUserService;
import org.springframework.stereotype.Service;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
	@Resource  
    private IUserDao userDao; 
	
	@Override
	public User getUserById(int userId) {
		return userDao.selectByPrimaryKey(userId);
	}

	@Override
	public void saveUser(User user) {
//		DatabaseContextHolder.setCustomerType(DatabaseContextHolder.DATA_SOURCE_MYSQL_U);
		this.userDao.insert(user);
		//throw new RuntimeException("test Transactional");
	}

}
