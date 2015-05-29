package com.sinaapp.moyun.dao.imp;

import com.sinaapp.moyun.dao.BaseDao;
import com.sinaapp.moyun.dao.UserDao;
import com.sinaapp.moyun.model.po.User;
import com.sinaapp.moyun.util.Hibernate.HQLxUtil.HQLxCondition;
import com.sinaapp.moyun.util.Hibernate.HQLxUtil.HQLxHandle;
import com.sinaapp.moyun.util.Hibernate.HQLxUtil.HQLxHeader;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Moy on ÎåÔÂ27  027.
 */
@Repository
public class UserDaoImp extends BaseDao<User> implements UserDao {

    @Override
    public List<User> findByName(String name) {
        HQLxHeader hqLxHeader = new HQLxHeader();
        hqLxHeader.get(HQLxHeader.Type.QUERY, new User());

        HQLxCondition where = new HQLxCondition();
        where.addCompare(HQLxCondition.CompareType.EQ, "name");

        String hql = HQLxHandle.ok(hqLxHeader, where);
        return getCurrentSession().createQuery(hql).setParameter("name", name).list();
    }

}
