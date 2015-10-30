package com.example.lmj.work4;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;


public class MyContactsActivity extends Activity {
    private EditText nameEditText;//姓名输入框
    private EditText mobileEditText;//手机输入框
    private EditText qqEditText;//qq输入框
    private EditText danweiEditText;//单位输入框
    private EditText addressEditText;//地址输入框
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText=(EditText)findViewById(R.id.name);
        mobileEditText=(EditText)findViewById(R.id.mobile);
        qqEditText=(EditText)findViewById(R.id.qq);
        danweiEditText=(EditText)findViewById(R.id.danwei);
        addressEditText=(EditText)findViewById(R.id.address);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(Menu.NONE,1,Menu.NONE,"保存");
        menu.add(Menu.NONE,2,Menu.NONE,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()){
          case 1://保存
              if(!nameEditText.getText().toString().equals("")){
                  User user = new User();
                  user.setName(nameEditText.getText().toString());
                  user.setMobile(mobileEditText.getText().toString());
                  user.setDanwei(danweiEditText.getText().toString());
                  user.setQq(qqEditText.getText().toString());
                  user.setAddress(addressEditText.getText().toString());
                  ContactsTable ct = new ContactsTable(MyContactsActivity.this);
                  if(ct.addData(user)){
                      Toast.makeText(MyContactsActivity.this,"添加成功!",Toast.LENGTH_SHORT).show();
                  }else {
                      Toast.makeText(MyContactsActivity.this,"添加失败！",Toast.LENGTH_SHORT).show();
                  }
              }else {
                  Toast.makeText(MyContactsActivity.this,"请先输入数据！",Toast.LENGTH_SHORT).show();
              }
              break;
          case 2://返回
              finish();
              break;
          default:
              break;
      }
        return super.onOptionsItemSelected(item);
    }
}
