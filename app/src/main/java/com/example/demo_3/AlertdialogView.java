package com.example.demo_3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AlertdialogView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertdialog);
        setTitle("AlertDialog");
        Button button = (Button) findViewById(R.id.alertbtn);
        button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlertdialogView.this);
                final AlertDialog dialog = builder.create();
                View dialogView = View.inflate(AlertdialogView.this, R.layout.login, null);
                dialog.setView(dialogView);
                dialog.show();
            }
        });
//        Button dialog_button = (Button) findViewById(R.id.button5);
//        dialog_button.setOnClickListener(new Button.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                final AlertDialog dialog = builder.create();
//                View dialogView = View.inflate(MainActivity.this, R.layout.login, null);
//                dialog.setView(dialogView);
//                dialog.show();
//            }
//        });

    }

    public void showDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(AlertdialogView.this);
        final AlertDialog dialog = builder.create();
        View dialogView = View.inflate(AlertdialogView.this, R.layout.login, null);
        dialog.setView(dialogView);
        dialog.show();
    }
}
