package com.example.sun.demo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Sun on 2017/1/5.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHold> implements ItemTouchAdapterCallback {
   private List<MyEntity> list;
    private ItemStartDragListener itemStartDragListener;

    public RecycleAdapter(List<MyEntity> list, ItemStartDragListener itemStartDragListener) {
        this.list= list;
        this.itemStartDragListener = itemStartDragListener;
    }

    @Override
    public MyViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, null);
        return new MyViewHold(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHold holder, int position) {
//绑定数据
        MyEntity myEntity= list.get(position);
        holder.content.setText(myEntity.getContent()+position);
        holder.item.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                itemStartDragListener.onStartDrag(holder);
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        /*
        *1.数据交换
        * 2.刷新RecycleView
         */
        Collections.swap(list,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
        return false;
    }

    class MyViewHold extends RecyclerView.ViewHolder {
        public ImageView icon;
        public TextView content;
        public LinearLayout item;

        public MyViewHold(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.textView);
            icon = (ImageView)itemView.findViewById(R.id.imageView);
            item = (LinearLayout)itemView.findViewById(R.id.linear_item);
        }
    }

}
