package com.sinaapp.moyun.util.Hibernate.HQLxUtil;

/**
 * Created by Moy on ÎåÔÂ28  028.
 */
public class HQLxGroup {
    StringBuffer groupArea;

    public void addGroups(String... groups) {
        groupArea = new StringBuffer(" group by ");
        int i=0;
        for (String group : groups) {
            String tmp = i++==0? group:","+group;
            groupArea.append(tmp);
        }
        groupArea.append(" having 1=1 ");
    }

    public StringBuffer getGroupArea() {
        return groupArea;
    }
}
