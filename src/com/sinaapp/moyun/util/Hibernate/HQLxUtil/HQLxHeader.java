package com.sinaapp.moyun.util.Hibernate.HQLxUtil;

/**
 * Created by Moy on 五月28  028.
 */
public class HQLxHeader {

    private StringBuffer header;
    private String tableSimpleName;


    public enum Type {
        DELETE, UPDATE, QUERY, SELECT
    }

    /**
     * 生成 目标头
     * @param type 指定生成类型
     * @param tableObj 实体对象
     */
    public void get(Type type, Object tableObj) {
        switch (type) {
            case DELETE:
                header = new StringBuffer("delete ");
                break;
            case UPDATE:
                header = new StringBuffer("update ");
                break;
            case QUERY:
                header = new StringBuffer("from ");
                break;
        }
        Class tableClazz = tableObj.getClass();
        setTableSimpleName(tableClazz.getSimpleName());
        header.append(tableClazz.getTypeName() + " " + getTableSimpleName() + " where 1=1");
    }

    public void getSelect(Object tableObj, String... selectParams) {
        header = new StringBuffer("select ");

        int i=0;
        for (String selectParam : selectParams) {
            header.append(i++==0? selectParam : ","+selectParam);
        }
        header.append(" from ");
        Class tableClazz = tableObj.getClass();
        setTableSimpleName(tableClazz.getSimpleName());
        header.append(tableClazz.getTypeName() + " " + getTableSimpleName() + " where 1=1");
    }

    public StringBuffer getHeader() {
        return header;
    }

    public String getTableSimpleName() {
        return tableSimpleName;
    }

    public void setTableSimpleName(String tableSimpleName) {
        this.tableSimpleName = tableSimpleName;
    }
}
