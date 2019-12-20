package ru.nsu.lightweight.punchclub.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class RecyclerAdapter<T, B : ViewDataBinding>(
    private val layoutRes: Int,
    private val binder: (T, B) -> Unit,
    private val listener: ((T, Int) -> Unit)? = null
) : RecyclerView.Adapter<RecyclerViewHolder<T, B>>() {

    private var elements = mutableListOf<T>()

    fun setElements(elements: List<T>) {
        this.elements = elements.toMutableList()
        notifyDataSetChanged()
    }

    fun changeElementByPosition(element: T, position: Int) {
        this.elements[position] = element
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder<T, B> {
        val binding = DataBindingUtil.inflate<B>(
            LayoutInflater.from(parent.context),
            layoutRes,
            parent,
            false
        )
        return RecyclerViewHolder(binding, binder)
    }

    override fun getItemCount() = elements.size

    override fun onBindViewHolder(holder: RecyclerViewHolder<T, B>, position: Int) {
        holder.bind(elements[position], listener, position)
    }
}