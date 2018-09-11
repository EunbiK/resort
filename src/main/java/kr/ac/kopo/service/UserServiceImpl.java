package kr.ac.kopo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.dao.UserDao;
import kr.ac.kopo.domain.User;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User selectOne(long id) {
		return userDao.selectOne(id);
	}
	
	@Override
	public User selectOneByAuth(String auth) {
		return userDao.selectOneByAuth(auth);
	}


	@Override
	public int createOne(User user) {
		return userDao.createOne(user);
	}

	
}
