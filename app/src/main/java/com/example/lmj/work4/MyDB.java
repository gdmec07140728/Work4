package com.example.lmj.work4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2015/10/28.
 */
public class MyDB extends SQLiteOpenHelper {
    private static String DB_NAME="My_DB.db";   //数据库名称
    private static int DB_VERSION=2;    //版本号
    private SQLiteDatabase db;  //数据库操作对象

    public MyDB(Context context){
        //在子类的构造函数实现过程中，一般首先调用父类的构造函数
        super(context,DB_NAME,null,DB_VERSION);
        db=getWritableDatabase();
    }

    public SQLiteDatabase openConnection(){
        db=getWritableDatabase();
        return db;
    }

    public void closeConnection(){
        db.close();
    }

    public boolean creatTable(String createTableSql){
        try {
            openConnection();
            db.execSQL(createTableSql);
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;
    }

    public boolean save(String tableName,ContentValues values){
        try {
            openConnection();
            db.insert(tableName, null, values);
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;
    }

    public boolean update(String table,ContentValues values,String whereClause,String []whereArgs){
        try {
            openConnection();
            db.update(table, values, whereClause, whereArgs);
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;
    }

    public boolean delete(String table,String deleteSql,String obj[]){
        try {
            openConnection();
            db.delete(table, deleteSql, obj);
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;
    }

    public Cursor find(String findSql,String obj[]) {
        Cursor cursor=null;
        try {
            openConnection();
            cursor=db.rawQuery(findSql,obj);
        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            closeConnection();
        }

        return cursor;
    }

    public boolean isTableExits(String tablename){
        try {
            openConnection();
            String str = "select count(*)xcount from"+tablename;
            db.rawQuery(str,null).close();
        }catch (Exception ex){
            return false;
        }
        return true;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}




