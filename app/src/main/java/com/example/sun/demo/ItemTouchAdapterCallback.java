package com.example.sun.demo;

/**
 * Created by Sun on 2017/1/5.
 */

public interface ItemTouchAdapterCallback {
    /*
    *1.交换数据
    *2.刷新recycle
     */
    boolean onItemMove(int fromPosition, int toPosition);
}
