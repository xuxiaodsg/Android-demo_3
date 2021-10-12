package com.example.demo_3;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class XmlfontView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmltest);
        setTitle("XMLTest");
    }

    //调用菜单资源
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    //菜单点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        TextView testview = (TextView) findViewById(R.id.textView);
        switch (item.getItemId()) {
            case R.id.bigitem:
                testview.setTextSize(TypedValue.COMPLEX_UNIT_SP , 50);
                break;
            case R.id.middleitem:
                testview.setTextSize(TypedValue.COMPLEX_UNIT_SP , 30);
                break;
            case R.id.smallitem:
                testview.setTextSize(TypedValue.COMPLEX_UNIT_SP , 10);
                break;
            case R.id.item2:
                Toast.makeText(this, "普通菜单栏被点击", Toast.LENGTH_SHORT).show();
                break;
            case R.id.red:
                testview.setTextColor(Color.rgb(255, 0, 0));
                break;
            case R.id.black:
                testview.setTextColor(Color.rgb(0, 0, 0));
                break;
        }
        return true;
    }
}
