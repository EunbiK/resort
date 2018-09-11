package kr.ac.kopo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.domain.Room;

@Transactional
@Repository
public class RoomDaoImpl implements RoomDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {		//connection ÀçÈ°¿ë
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Room selectOne(long id) {
		String hql = "FROM Room WHERE id = " + id;
		Query query = getSession().createQuery(hql);
		return (Room) query.uniqueResult();
	}
	
	@Override
	public List<Room> selectAll() {
		String hql = "FROM Room";
		Query query = getSession().createQuery(hql);
		return query.list();
	}

	@Override
	public List<Room> selectRoomType(String type) {
		String hql = "FROM Room WHERE type = '" + type + "'";
		Query query = getSession().createQuery(hql);
		return query.list();
	}
	
	
	
}
