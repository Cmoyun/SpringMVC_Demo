package com.sinaapp.moyun.util.Hibernate.HQLxUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moy on 五月28  028.
 */
public class HQLxCondition {
    private StringBuffer tmpCondition;
    // 存放条件的BOX
    List<StringBuffer> ConditionBox = new ArrayList<StringBuffer>();
    public static final String AND = " AND ";
    public static final String OR = " OR ";

    public enum CompareType {
        EQ,  //等于
        NEQ, //不等于
        LS,  //小于
        LEQ, //小等于
        TR,  //大于
        GEQ  //大等于
    }

    /**
     * 添加比较语句
     *
     * @param type 比较的类型
     * @param key  数据库字段
     */
    public void addCompare(CompareType type, String key) {
        tmpCondition = new StringBuffer();
        String symbol = null;
        switch (type) {
            case EQ:
                symbol = "=";
                break;
            case NEQ:
                symbol = "!=";
                break;
            case LS:
                symbol = "<";
                break;
            case LEQ:
                symbol = "<=";
                break;
            case TR:
                symbol = ">";
                break;
            case GEQ:
                symbol = ">=";
                break;
        }
        tmpCondition.append(key + symbol + ':' + key);
        ConditionBox.add(tmpCondition);
    }

    /**
     * 设置 字段不为null
     *
     * @param key 数据库字段
     */
    public void addNotNull(String key) {
        tmpCondition = new StringBuffer();
        tmpCondition.append(key + " is not null");
        ConditionBox.add(tmpCondition);
    }

    /**
     * 设置 字段为null
     *
     * @param key 数据库字段
     */
    public void addNull(String key) {
        tmpCondition = new StringBuffer();
        tmpCondition.append(key + " is null");
        ConditionBox.add(tmpCondition);
    }

    /**
     * 设置 In 在某个有限范围
     *
     * @param key 数据库字段
     */
    public void addIn(String key) {
        tmpCondition = new StringBuffer();
        tmpCondition.append(key + " in (:" + key + ")");
        ConditionBox.add(tmpCondition);
    }

    /**
     * 设置 In 不在某个有限范围
     *
     * @param key 数据库字段
     */
    public void addNotIn(String key) {
        tmpCondition = new StringBuffer();
        tmpCondition.append(key + " not in (:" + key + ")");
        ConditionBox.add(tmpCondition);
    }

    /**
     * 匹配 模式
     *
     * @param key 数据库字段
     */
    public void addLike(String key) {
        tmpCondition = new StringBuffer();
        tmpCondition.append(key + " like :" + key + "");
        ConditionBox.add(tmpCondition);
    }

    /**
     * 范围模式
     * 最大值 max 最小值 min
     *
     * @param key 数据库字段
     */
    public void addBetweenAnd(String key) {
        tmpCondition = new StringBuffer();
        tmpCondition.append(key + " between :min and :max");
        ConditionBox.add(tmpCondition);
    }

    /**
     * 生成 最终 where 部分hql
     */
    public StringBuffer produce() {
        StringBuffer rs = new StringBuffer();
        String likeSymbol = AND;
        int i=0; // 用于判断链接符号
        rs.append("(");
        for (StringBuffer ls : ConditionBox) {
            switch (ls.toString()) {
                case OR:
                    likeSymbol = OR;
                    continue;
                case AND:
                    likeSymbol = AND;
                    continue;
            }
            String tp = i++==0? "":likeSymbol;
            rs.append(tp);
            rs.append(ls);
        }
        rs.append(")");
        return rs;
    }

    public StringBuffer wXw(StringBuffer s1, StringBuffer s2, String likeSymbol) {
        return s1.append(likeSymbol).append(s2);
    }

    public void or() {
        ConditionBox.add(new StringBuffer(OR));
    }

    public void and() {
        ConditionBox.add(new StringBuffer(AND));
    }
}
