package kr.ac.kopo.service;

import kr.ac.kopo.domain.User;

public interface UserService {
	User selectOne(long id);
	User selectOneByAuth(String auth);
	int createOne(User user);
}
