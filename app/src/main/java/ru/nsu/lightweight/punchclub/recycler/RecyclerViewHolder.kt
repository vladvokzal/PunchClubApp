package ru.nsu.lightweight.punchclub.recycler

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.lightweight.punchclub.utils.RouterUtil

class RecyclerViewHolder<T, B : ViewDataBinding>(
    private val binding: B,
    private val binder: (T, B) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        element: T,
        listener: ((T, Int) -> Unit)?,
        position: Int
    ) {
        RouterUtil.onceClickListener(binding.root) {
            listener?.invoke(element, position)
        }
        binder.invoke(element, binding)
    }
}