package com.sinaapp.moyun.util.Hibernate;

import com.sinaapp.moyun.model.po.User;
import com.sinaapp.moyun.util.Hibernate.HQLxUtil.HQLxHandle;
import com.sinaapp.moyun.util.Hibernate.HQLxUtil.HQLxHeader;
import org.junit.Test;

/**
 * Created by Moy on ÎåÔÂ28  028.
 */
public class HQLxUtilTest {

    @Test
    public void testGet() throws Exception {
        HQLxHeader sb = new HQLxHeader();
        sb.getSelect(new User(), "count(*)", "id");
//        System.out.println("  # --> " +sb.getHeader());
//        HQLxCondition where = new HQLxCondition();
//        where.or();
//        where.addLike("msg");
//        where.addNotNull("likss");
//        where.addIn("inii");
//        where.or();
//        where.addBetweenAnd("bein");
//
//        HQLxGroup hqLxGroup = new HQLxGroup();
//        hqLxGroup.addGroups("id","name");
//        System.out.println("  # --> " + where.wXw(sb.getHeader(), where.produce(), HQLxCondition.OR));
//        System.out.println("  # --> ");
        String hql="";
//        hql = HQLxHandle.ok(sb, where, hqLxGroup, where);
//        System.out.println("  # --> " +hql);
//        hql = HQLxHandle.ok(sb, where, hqLxGroup);
//        System.out.println("  # --> " +hql);
//        hql = HQLxHandle.ok(sb, where);
//        System.out.println("  # --> " +hql);
        hql = HQLxHandle.ok(sb);
        System.out.println("  # --> " +hql);
    }
}