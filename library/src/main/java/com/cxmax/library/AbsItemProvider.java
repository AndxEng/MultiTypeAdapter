package com.cxmax.library;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;


/**
 * @describe :  this abstract class provides the same methods to hook {@link android.support.v7.widget.RecyclerView.Adapter}'s lifecycle.
 *               and it stands for a single specific item view
 * @usage :
 * <p>
 * <p>
 * Created by cxmax on 2017/3/26.
 */

public abstract class AbsItemProvider<T, VH extends RecyclerView.ViewHolder> {

    private T data;

    public T getData() {
        return data;
    }

    /**
     * determine whether this is the responsible for the given data element.
     * @param items
     * @param position
     * @return
     */
    protected abstract boolean isForViewType(@NonNull T items, int position);

    /**
     * this method don't need int viewtype param
     * @param parent
     * @return
     */
    @NonNull
    abstract protected VH onCreateViewHolder(ViewGroup parent);

    /**
     *
     * @param items data source
     * @param position The position in the datasource
     * @param holder ViewHolder
     */
    protected abstract void onBindViewHolder(@NonNull T items, int position, @NonNull VH holder);

    /**
     * when adapter has been recycled , this method will be called
     * @param holder
     */
    protected void onViewRecycled(@NonNull VH holder) {

    }

    /**
     * when ItemView created by RecyclerView can not be recycled due to its own transient state, this method will be called
     * @param holder
     * @return
     */
    protected boolean onFailedToRecycleView(VH holder) {
        return false;
    }

    /**
     * the ItemView has been attached to window , this method will be called
     * @param holder
     */
    protected void onViewAttachedToWindow(VH holder) {

    }

    /**
     * the ItemView has been detached to window , this method will be called
     * @param holder
     */
    protected void onViewDetachedFromWindow(VH holder) {

    }
}
