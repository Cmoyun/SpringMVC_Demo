package com.sinaapp.moyun.util.Hibernate.HQLxUtil;

/**
 * Created by Moy on ÎåÔÂ28  028.
 */
public class HQLxHandle {

    private static boolean isShowHQL=true;

    public static String ok(HQLxHeader hqlxHeader, HQLxCondition whereCondition, HQLxGroup hqlxGroup, HQLxCondition havingCondition) {
        StringBuffer pre = whereCondition.wXw(hqlxHeader.getHeader(), whereCondition.produce(), HQLxCondition.AND);
        StringBuffer lat = havingCondition.wXw(hqlxGroup.getGroupArea(), havingCondition.produce(), HQLxCondition.AND);
        String hql=pre.append(lat).toString();
        if (isShowHQL) System.out.println("  #HQL:: " +hql);
        return hql;
    }

    public static String ok(HQLxHeader hqlxHeader, HQLxCondition whereCondition, HQLxGroup hqlxGroup) {
        StringBuffer pre = whereCondition.wXw(hqlxHeader.getHeader(), whereCondition.produce(), HQLxCondition.AND);
        String hql=pre.append(hqlxGroup.getGroupArea()).toString();
        if (isShowHQL) System.out.println("  #HQL:: " +hql);
        return hql;
    }

    public static String ok(HQLxHeader hqlxHeader, HQLxCondition whereCondition) {
        String hql=whereCondition.wXw(hqlxHeader.getHeader(), whereCondition.produce(), HQLxCondition.AND).toString();
        if (isShowHQL) System.out.println("  #HQL:: " +hql);
        return hql;
    }

    public static String ok(HQLxHeader hqlxHeader) {
        String hql=hqlxHeader.getHeader().toString();
        if (isShowHQL) System.out.println("  #HQL:: " +hql);
        return hql;
    }

}
