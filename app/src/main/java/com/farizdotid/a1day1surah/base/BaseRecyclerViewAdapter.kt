package com.farizdotid.a1day1surah.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseRecyclerViewAdapter<T, VB : ViewBinding> :
    RecyclerView.Adapter<BaseRecyclerViewAdapter.Companion.BaseViewHolder<VB>>() {

    private var items = mutableListOf<T>()
    private var lastPosition = -1

    fun addItems(items: MutableList<T>) {
        this.items = items
        notifyDataSetChanged()
    }

    abstract fun setBinding(parent: ViewGroup): VB
    abstract fun onBindData(holder: BaseViewHolder<VB>, item: T, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VB> {
        return BaseViewHolder(setBinding(parent))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int) {
        onBindData(holder, items[position], position)
    }

    override fun getItemCount(): Int = items.size

    companion object {
        class BaseViewHolder<VB : ViewBinding>(val binding: VB) :
            RecyclerView.ViewHolder(binding.root)
    }

}