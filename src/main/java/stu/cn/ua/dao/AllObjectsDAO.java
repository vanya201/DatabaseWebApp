package stu.cn.ua.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class AllObjectsDAO<T> {

    private Class<T> entityClass;

    /**
     * This method creates a new entity.
     */
    public T createEntity(T obj) {
        Session session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(obj);
        transaction.commit();
        return obj;
    }

    public AllObjectsDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * This method updates an existing entity.
     */
    public T updateEntity(T entity) {
        Session session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.merge(entity);
        transaction.commit();
        return entity;
    }

    /**
     * This method deletes an existing entity.
     */
    public void deleteEntity(T entity) {
        Session session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
    }


    /**
     * This method removes an entity by id.
     */
    public void deleteEntityById(Long id) {
        Session session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        T entity = (T) session.get(entityClass, id);
        session.delete(entity);
        transaction.commit();
    }
    public T getEntityById(Long id) {
        if(id == null)
            return null;
        Session session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        T entity = (T) session.get(entityClass, id);
        transaction.commit();
        return entity;
    }
    /**
     * This method returns all entities.
     */
    public List<T> getAllEntities() {
        Session session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(entityClass);
        List<T> list =  criteria.list();
        transaction.commit();
        return list;
    }

    /**
     * This method returns entities by a specific field value.
     */
    public List<T> getEntitiesByField(String fieldName, Object value) {
        Session session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(entityClass)
                .add(Restrictions.eq(fieldName, value));
        List<T> list =  criteria.list();
        transaction.commit();
        return list;
    }
}
