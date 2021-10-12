package com.example.demo_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionModeView extends AppCompatActivity {

    //    这三个经常是同时出现的
    private List<Map<String,Object>> lists;
    private SimpleAdapter adapter;
    private ListView listView;

    //    定义数据
    private String[] theme = {"One", "Two", "Three", "Four", "Five"};
    private int[] imageViews = {R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionmode);
        setTitle("ActionModeTest");
        listView = (ListView) findViewById(R.id.list_view);
        // 数据源
        lists = new ArrayList<>();
        for(int i = 0; i<theme.length; i++){
            Map<String, Object> map = new HashMap<>();
            map.put("image", imageViews[i]);
            map.put("theme", theme[i]);
            lists.add(map);
        }

        adapter = new SimpleAdapter(ActionModeView.this, lists,
                R.layout.list_big_layout, new String[]{"image", "theme"},
                new int[]{R.id.image, R.id.text});
        listView.setAdapter(adapter);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        listView.setMultiChoiceModeListener(new ListView.MultiChoiceModeListener() {
            @Override
            /*
             * 参数：ActionMode是长按后出现的标题栏
             * 		positon是当前选中的item的序号
             *		id 是当前选中的item的id
             *		checked 如果是选中事件则为true，如果是取消事件则为false
             */
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                mode.setTitle(listView.getCheckedItemCount()+" selected");
                if(checked == true)
                {
                    System.out.println(adapter.getItem(position));
                }
                else{

                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.action_menu,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
            }
        });
    }



}