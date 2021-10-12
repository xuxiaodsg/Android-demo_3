package com.example.demo_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MainMenu");

        Button btn_1 = (Button) findViewById(R.id.button_1);
        btn_1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                showListTest();
            }
        });
        Button btn_2 = (Button) findViewById(R.id.button_2);
        btn_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showAlertTest();
            }
        });
        Button btn_3 = (Button) findViewById(R.id.button_3);
        btn_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showXmlTest();
            }
        });
        Button btn_4 = (Button) findViewById(R.id.button_4);
        btn_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showActionTest();
            }
        });



        
    }

    public void showListTest(){
        Intent intent = new Intent();
        intent.setClass(this,ListTestView.class);
        startActivity(intent);
    }

    public void showAlertTest(){
        Intent intent = new Intent(this,AlertdialogView.class);
        startActivity(intent);
    }

    public void showXmlTest(){
        Intent intent = new Intent();
        intent.setClass(this,XmlfontView.class);
//        intent.setClassName(this,"com.example.demo_3.XmlfontView");
        startActivity(intent);
    }

    public void showActionTest(){
        Intent intent = new Intent();
        intent.setClass(this,ActionModeView.class);
        startActivity(intent);
    }








}


