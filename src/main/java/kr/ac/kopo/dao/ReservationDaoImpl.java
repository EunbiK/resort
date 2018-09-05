package kr.ac.kopo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.domain.Reservation;
import kr.ac.kopo.domain.Room;

@Transactional
@Repository
public class ReservationDaoImpl implements ReservationDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {		//connection ÀçÈ°¿ë
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Reservation selectOne(long id) {
		String hql = "FROM Reservation WHERE id = " + id;
		Query query = getSession().createQuery(hql);
		return (Reservation) query.uniqueResult();
	}
	
	@Override
	public List<Reservation> selectAll() {
		String hql = "FROM Reservation";
		Query query = getSession().createQuery(hql);
		return query.list();
	}
	
	@Override
	public List<Room> selectRoomType(String type) {
		String hql = "FROM Room WHERE type = '" + type + "'";
		Query query = getSession().createQuery(hql);
		return query.list();
	}
	

	@Override
	public int createOne(Reservation reservation) {
		return (int) getSession().save(reservation);
	}

	@Override
	public void updateOne(Reservation reservation) {
		getSession().saveOrUpdate(reservation);
	}

	@Override
	public void deleteOne(Reservation reservation) {
		getSession().delete(reservation);
	}
	
}
