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
    private ItemTouchAdapterCallback callback;
    private RecycleAdapter adapter;

    public RecycleAdapter(List<MyEntity> list, ItemStartDragListener itemStartDragListener) {
        this.adapter = this;
        this.list = list;
        this.itemStartDragListener = itemStartDragListener;
    }

    @Override
    public MyViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, null);
        return new MyViewHold(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHold holder, final int position) {
        //绑定数据
        MyEntity myEntity = list.get(position);
        holder.content.setText(myEntity.getContent());
        holder.reorder.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                itemStartDragListener.onStartDrag(holder);
                return false;
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.onItemDelect(position);
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
        Collections.swap(list, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return false;
    }

    @Override
    public void onItemSwipe(int toPosition) {
        list.remove(toPosition);
        notifyItemRemoved(toPosition);
    }

    @Override
    public void onItemDelect(int toPosition) {
        list.remove(toPosition);
        notifyDataSetChanged();
    }

    class MyViewHold extends RecyclerView.ViewHolder {
        public ImageView icon;
        public TextView content;
        public TextView reorder;
        public TextView delete;

        public MyViewHold(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.textView);
            icon = (ImageView) itemView.findViewById(R.id.imageView);
            reorder = (TextView) itemView.findViewById(R.id.reorder);
            delete = (TextView) itemView.findViewById(R.id.delete);
        }
    }

}
