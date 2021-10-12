package com.example.demo_3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListTestView extends AppCompatActivity {
    //    这三个经常是同时出现的
    private List<Map<String,Object>> lists;
    private SimpleAdapter adapter;
    private ListView listView;

    //    定义数据
    private String[] theme = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
    private int[] imageViews = {R.drawable.lion, R.drawable.tiger, R.drawable.monkey, R.drawable.dog, R.drawable.cat, R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listtest);
        setTitle("SimpleAdpater");
        listView = (ListView) findViewById(R.id.list_view);
        // 数据源
        lists = new ArrayList<>();
        for(int i = 0; i<theme.length; i++){
            Map<String, Object>map = new HashMap<>();
            map.put("image", imageViews[i]);
            map.put("theme", theme[i]);
            lists.add(map);
        }

        adapter = new SimpleAdapter(ListTestView.this, lists,
                R.layout.list_layout, new String[]{"image", "theme"},
                new int[]{R.id.image, R.id.text});
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(ListTestView.this, theme[position],Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    // ArrayAdapter测试
    private void listTest(){
        String[] data = { "Apple", "Banana", "Orange", "Watermelon",
                "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                ListTestView.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
//        （1）、在这里我运用了系统包含的一个TextView的布局文件：android.R.layout.simple_expandable_list_item_1,调用这个比较方便，
//
//        （2）、ArrayAdapter<String> adapter = new ArrayAdapter<String>(  MainActivity.this, android.R.layout.simple_list_item_1, data);
//          的意思是：创建一个数组适配器的代码，里面有三个参数，第一个参数是上下文，就是当前的Activity,
//          第二个参数是android sdk中自己内置的一个布局，它里面只有一个TextView，
//          这个参数是表明我们数组中每一条数据的布局是这个view，就是将每一条数据都显示在这个 view上面；
//          第三个参数就是我们要显示的数据。listView会根据这三个参数，遍历data里面的每一条数据，读出一条，
//          显示到第二 个参数对应的布局中，这样就形成了我们看到的listView.
//
//        （3）、ArrayAdapter是BaseAdapter的子类
    }
}
