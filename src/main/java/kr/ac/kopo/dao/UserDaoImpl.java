package kr.ac.kopo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.domain.Reservation;
import kr.ac.kopo.domain.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {		//connection ÀçÈ°¿ë
		return sessionFactory.getCurrentSession();
	}

	@Override
	public User selectOne(long id) {
		String hql = "FROM User WHERE id = " + id;
		Query query = getSession().createQuery(hql);
		return (User) query.uniqueResult();
	}

	@Override
	public List<User> selectAll() {
		String hql = "FROM User";
		Query query = getSession().createQuery(hql);
		return query.list();
	}

	@Override
	public int createOne(User user) {
		return (int) getSession().save(user);
	}

	@Override
	public void updateOne(User user) {
		getSession().saveOrUpdate(user);
	}

	@Override
	public void deleteOne(User user) {
		getSession().delete(user);
	}

	
	
	
	
}
