package com.example.sun.demo;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by Sun on 2017/1/5.
 */

public class RecycleViewItemTouchCallback extends ItemTouchHelper.Callback{
    private  ItemTouchAdapterCallback adapterCallback;

    public RecycleViewItemTouchCallback(ItemTouchAdapterCallback adapterCallback) {
        this.adapterCallback=adapterCallback;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //callback的回调监听 判断有哪些动作  判断手指移动的方向 (left|right   up |down)
        int dragFlags = ItemTouchHelper.UP|ItemTouchHelper.DOWN;
        int swipeFlags=ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlags,swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        //移动
        adapterCallback.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        //侧滑
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }
}
