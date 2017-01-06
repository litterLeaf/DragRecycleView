package com.example.sun.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemStartDragListener {
    private RecyclerView recyclerView;
    private ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecycleAdapter adapter = new RecycleAdapter(getDate(), this);
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new RecycleViewItemTouchCallback(adapter);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }

    private List<MyEntity> getDate() {
        List<MyEntity> list = new ArrayList<>();
        MyEntity myEntity1 = new MyEntity();
        myEntity1.setContent("这是第");
        MyEntity myEntity2 = new MyEntity();
        myEntity2.setContent("这是第");
        MyEntity myEntity3 = new MyEntity();
        myEntity3.setContent("这是第");
        MyEntity myEntity4 = new MyEntity();
        myEntity4.setContent("这是第");
        MyEntity myEntity5 = new MyEntity();
        myEntity5.setContent("这是第");
        MyEntity myEntity6 = new MyEntity();
        myEntity6.setContent("这是第");
        MyEntity myEntity7 = new MyEntity();
        myEntity7.setContent("这是第");
        MyEntity myEntity8 = new MyEntity();
        myEntity8.setContent("这是第");
        MyEntity myEntity9 = new MyEntity();
        myEntity9.setContent("这是第");
        MyEntity myEntity10 = new MyEntity();
        myEntity10.setContent("这是第");
        MyEntity myEntity11 = new MyEntity();
        myEntity11.setContent("这是第");
        MyEntity myEntity12 = new MyEntity();
        myEntity12.setContent("这是第");
        MyEntity myEntity13 = new MyEntity();
        myEntity13.setContent("这是第");
        MyEntity myEntity14 = new MyEntity();
        myEntity14.setContent("这是第");
        MyEntity myEntity15 = new MyEntity();
        myEntity15.setContent("这是第");
        MyEntity myEntity16 = new MyEntity();
        myEntity16.setContent("这是第");
        MyEntity myEntity17 = new MyEntity();
        myEntity17.setContent("这是第");
        MyEntity myEntity18 = new MyEntity();
        myEntity18.setContent("这是第");
        MyEntity myEntity19 = new MyEntity();
        myEntity19.setContent("这是第");
        MyEntity myEntity20 = new MyEntity();
        myEntity20.setContent("这是第");

        list.add(myEntity1);
        list.add(myEntity2);
        list.add(myEntity3);
        list.add(myEntity4);
        list.add(myEntity5);
        list.add(myEntity6);
        list.add(myEntity7);
        list.add(myEntity8);
        list.add(myEntity9);
        list.add(myEntity10);
        list.add(myEntity11);
        list.add(myEntity12);
        list.add(myEntity13);
        list.add(myEntity14);
        list.add(myEntity15);
        list.add(myEntity16);
        list.add(myEntity17);
        list.add(myEntity18);
        list.add(myEntity19);
        list.add(myEntity20);
        return list;

    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder holder) {
        itemTouchHelper.startDrag(holder);
    }
}
