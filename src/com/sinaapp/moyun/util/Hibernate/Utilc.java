package com.sinaapp.moyun.util.Hibernate;

import javax.persistence.Id;
import java.lang.reflect.Field;

/**
 * Created by Moy on ����27  027.
 */
public class Utilc {

    /**
     * ��� ǰ̨�����װ�� ��������ֵ
     * @param obj
     * @return
     */
    public static Object getFiledId(Object obj) {
        Class<? extends Object> clazz = obj.getClass();
        Object id = null;
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class)) {
                field.setAccessible(true);
                try {
                    id = field.get(obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return id;
    }
}
