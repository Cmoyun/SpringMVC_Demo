package com.sinaapp.moyun.util.Hibernate.HQLxUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moy on ����28  028.
 */
public class HQLxCondition {
    private StringBuffer tmpCondition;
    // ���������BOX
    List<StringBuffer> ConditionBox = new ArrayList<StringBuffer>();
    public static final String AND = " AND ";
    public static final String OR = " OR ";

    public enum CompareType {
        EQ,  //����
        NEQ, //������
        LS,  //С��
        LEQ, //С����
        TR,  //����
        GEQ  //�����
    }

    /**
     * ��ӱȽ����
     *
     * @param type �Ƚϵ�����
     * @param key  ���ݿ��ֶ�
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
     * ���� �ֶβ�Ϊnull
     *
     * @param key ���ݿ��ֶ�
     */
    public void addNotNull(String key) {
        tmpCondition = new StringBuffer();
        tmpCondition.append(key + " is not null");
        ConditionBox.add(tmpCondition);
    }

    /**
     * ���� �ֶ�Ϊnull
     *
     * @param key ���ݿ��ֶ�
     */
    public void addNull(String key) {
        tmpCondition = new StringBuffer();
        tmpCondition.append(key + " is null");
        ConditionBox.add(tmpCondition);
    }

    /**
     * ���� In ��ĳ�����޷�Χ
     *
     * @param key ���ݿ��ֶ�
     */
    public void addIn(String key) {
        tmpCondition = new StringBuffer();
        tmpCondition.append(key + " in (:" + key + ")");
        ConditionBox.add(tmpCondition);
    }

    /**
     * ���� In ����ĳ�����޷�Χ
     *
     * @param key ���ݿ��ֶ�
     */
    public void addNotIn(String key) {
        tmpCondition = new StringBuffer();
        tmpCondition.append(key + " not in (:" + key + ")");
        ConditionBox.add(tmpCondition);
    }

    /**
     * ƥ�� ģʽ
     *
     * @param key ���ݿ��ֶ�
     */
    public void addLike(String key) {
        tmpCondition = new StringBuffer();
        tmpCondition.append(key + " like :" + key + "");
        ConditionBox.add(tmpCondition);
    }

    /**
     * ��Χģʽ
     * ���ֵ max ��Сֵ min
     *
     * @param key ���ݿ��ֶ�
     */
    public void addBetweenAnd(String key) {
        tmpCondition = new StringBuffer();
        tmpCondition.append(key + " between :min and :max");
        ConditionBox.add(tmpCondition);
    }

    /**
     * ���� ���� where ����hql
     */
    public StringBuffer produce() {
        StringBuffer rs = new StringBuffer();
        String likeSymbol = AND;
        int i=0; // �����ж����ӷ���
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
