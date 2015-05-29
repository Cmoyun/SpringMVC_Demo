package com.sinaapp.moyun.dao;

import com.sinaapp.moyun.util.Hibernate.HQLxUtil.HQLxCondition;
import com.sinaapp.moyun.util.Hibernate.HQLxUtil.HQLxHandle;
import com.sinaapp.moyun.util.Hibernate.HQLxUtil.HQLxHeader;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Moy on 五月24  024.
 */
public class BaseDao<T> {
    private
    @Autowired
    SessionFactory sessionFactory;

    protected String meTable = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();

    public boolean save(T obj) {
        getCurrentSession().saveOrUpdate(obj);
        return true;
    }

    public boolean delete(T obj) {
        getCurrentSession().delete(obj);
        return true;
    }

    public Query findAll() throws ClassNotFoundException {
        HQLxHeader hqLxHeader = new HQLxHeader();
        try {
            hqLxHeader.get(HQLxHeader.Type.QUERY, Class.forName(meTable).newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        String hql = HQLxHandle.ok(hqLxHeader);
        System.out.println("  # --> " +hql);
        return getCurrentSession().createQuery(hql);
    }

    public Query exec(String hql, Object... params) {

        Query query = getCurrentSession().createQuery(hql);

        int i = 0;
        for (Object param : params) {
            query.setParameter(i++, param);
        }

        return query;
    }

    public int delete(Integer id) throws ClassNotFoundException {
        HQLxHeader hqLxHeader = new HQLxHeader();
        try {
            hqLxHeader.get(HQLxHeader.Type.DELETE, Class.forName(meTable).newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        HQLxCondition where = new HQLxCondition();
        where.addCompare(HQLxCondition.CompareType.EQ, "id");

        String hql = HQLxHandle.ok(hqLxHeader, where);
        return getCurrentSession().createQuery(hql).setParameter("id", id).executeUpdate();
    }

    /**
     * 用于获得 Hibernate 会话
     *
     * @return
     */
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
