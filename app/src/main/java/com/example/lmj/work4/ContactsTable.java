package com.example.lmj.work4;

import android.content.ContentValues;
import android.content.Context;

/**
 * Created by Administrator on 2015/10/28.
 */
public class ContactsTable {
    private final static String TABLENAME="contactsTable";//表名
    private MyDB db;//定义SQLiteOpenHelper数据库管理对象
    public ContactsTable(Context context){
        db=new MyDB(context);
        if(!db.isTableExits(TABLENAME)){
            //定义SQL语句
            String createTableSql="CREATE TABLE IF NOT EXISTS"+TABLENAME+"(id_DB integer "
                    +"primary key AUTOINCREMENT,"+User.NAME+
                    " VARCHAR,"+User.MOBILE+" VARCHAR,"+User.QQ+" VARCHAR,"+User.DANWEI +" VARCHAR,"
                    +User.ADDRESS+" VARCHAR)";
            //创建表
            db.creatTable(createTableSql);
        }
    }

    public boolean addData(User user){
        ContentValues values = new ContentValues();
        values.put(User.NAME,user.getName());
        values.put(User.MOBILE,user.getMobile());
        values.put(User.DANWEI,user.getDanwei());
        values.put(User.QQ,user.getQq());
        values.put(User.ADDRESS,user.getAddress());
        return db.save(TABLENAME,values);

    }


}
