package cn.edu.gdmec.s07150831.mycontacts;

import android.content.ContentValues;
import android.content.Context;

public class ContactsTable {
    //数据表名常量
    private final static String TABLENAME = "contactsTable";
    //声明数据库对象
    private MyDB db;
    //构造方法
    public ContactsTable(Context context)
    {
        //创建MyDB对象，context很很重要
        db = new MyDB(context);
        //如果数据表不存在就新建数据表
        if (!db.isTableExits(TABLENAME)){
            String createTableSql = "create table if not exits " + TABLENAME +
                    "(id_DB integer " + "primary key AUTOINCREMENT,"+
                    User.NAME + " VARCHAR," +
                    User.MOBILE + " VARCHAR," +
                    User.QQ + " VARCHAR," +
                    User.DANWEI + " VARCHAR," +
                    User.ADDRESS + " VARCHAR)";
            db.createTable(createTableSql);
        }
    }
    //增加数据
    public boolean addData(User user)
    {
        //创建ContenValues对象用于保存数据
        ContentValues values = new ContentValues();
        //contentvalue 赋值
        values.put(User.NAME, user.getName());
        values.put(User.MOBILE, user.getMobile());
        values.put(User.DANWEI, user.getQq());
        values.put(User.ADDRESS, user.getAddress());
        //保存数据
        return db.save(TABLENAME,values);
    }
}
