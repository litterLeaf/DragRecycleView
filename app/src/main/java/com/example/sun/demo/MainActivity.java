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
//        itemTouchHelper.
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }

    private List<MyEntity> getDate() {
        List<MyEntity> list = new ArrayList<>();
        MyEntity myEntity1 = new MyEntity();
        myEntity1.setContent("A");
        MyEntity myEntity2 = new MyEntity();
        myEntity2.setContent("B");
        MyEntity myEntity3 = new MyEntity();
        myEntity3.setContent("C");
        MyEntity myEntity4 = new MyEntity();
        myEntity4.setContent("D");
        MyEntity myEntity5 = new MyEntity();
        myEntity5.setContent("E");
        MyEntity myEntity6 = new MyEntity();
        myEntity6.setContent("F");
        MyEntity myEntity7 = new MyEntity();
        myEntity7.setContent("G");
        MyEntity myEntity8 = new MyEntity();
        myEntity8.setContent("H");
        MyEntity myEntity9 = new MyEntity();
        myEntity9.setContent("I");
        MyEntity myEntity10 = new MyEntity();
        myEntity10.setContent("J");
        MyEntity myEntity11 = new MyEntity();
        myEntity11.setContent("K");
        MyEntity myEntity12 = new MyEntity();
        myEntity12.setContent("L");
        MyEntity myEntity13 = new MyEntity();
        myEntity13.setContent("M");
        MyEntity myEntity14 = new MyEntity();
        myEntity14.setContent("N");
        MyEntity myEntity15 = new MyEntity();
        myEntity15.setContent("O");


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
        return list;

    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder holder) {
        itemTouchHelper.startDrag(holder);
    }

    @Override
    public void onDeleteItem(RecyclerView.ViewHolder holder) {
        itemTouchHelper.startSwipe(holder);
    }
}
