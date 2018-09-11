package kr.ac.kopo.dao;

import java.util.List;

import kr.ac.kopo.domain.User;

public interface UserDao {
	
	User selectOne(long id);
	User selectOneByAuth(String auth);
	List<User> selectAll();
	
	int createOne(User user);
	void updateOne(User user);
	void deleteOne(User user);
			
}
