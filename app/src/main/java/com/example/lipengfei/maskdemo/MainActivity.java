package com.example.lipengfei.maskdemo;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.lipengfei.maskdemo.adapter.MainDatasAdapter;
import com.example.lipengfei.maskdemo.model.bean.WriteData;
import com.example.lipengfei.maskdemo.widget.MyDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化recycleView
        RecyclerView rv = (RecyclerView) findViewById(R.id.recycleview);

        //设置分割线
        MyDecoration myDecoration = new MyDecoration(this, MyDecoration.VERTICAL_LIST);
        //设置分割线长度、高和线条颜色
        myDecoration.setInset((int) getResources().getDimension(R.dimen.item_height_main));
        myDecoration.setDividerHeight((int) getResources().getDimension(R.dimen.item_decoration));
        myDecoration.setDivider(ContextCompat.getDrawable(this, R.drawable.drawable_decoration));
        rv.addItemDecoration(myDecoration);

        //设置数据
        List<WriteData> datas = new ArrayList<WriteData>();
        for (int i = 1; i <= 100; i++) {
            WriteData writeData = new WriteData();
            writeData.setSaveTime(System.currentTimeMillis()+ i*24 * 3600 * 1000);//日期不断变换
            writeData.setContent("RecycleItem_" + i + "\n这是内容");
            datas.add(writeData);
        }

        //显示
        MainDatasAdapter adapter = new MainDatasAdapter(datas);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}
