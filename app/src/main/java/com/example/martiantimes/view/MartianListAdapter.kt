package com.example.martiantimes.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.martiantimes.R
import com.example.martiantimes.databinding.ItemViewBinding
import com.example.martiantimes.model.MartianResponse
import com.example.martiantimes.util.ClickListener

class MartianListAdapter(val martianList: ArrayList<MartianResponse>) :
    RecyclerView.Adapter<MartianListAdapter.MartianViewHolder>(), ClickListener {

    fun updateMartianList(newMartianList: List<MartianResponse>) {
        martianList.clear()
        martianList.addAll(newMartianList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MartianViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemViewBinding>(
            inflater,
            R.layout.item_view, parent, false
        )
        return MartianViewHolder(view)
    }

    override fun onBindViewHolder(holder: MartianViewHolder, position: Int) {
        holder.view.artical = martianList[position]
//            holder.view.clickListener = this
    }

    override fun getItemCount(): Int {
        return martianList.size
    }

    override fun onClick(view: View) {
        for (martian: MartianResponse in martianList) {
            if (view.tag == martian.title) {
                val action =
                    ArticleListFragmentDirections
                        .actionArticleListFragmentToDetailArticleFragment(martian)
                Navigation.findNavController(view).navigate(action)


            }
        }
    }

    class MartianViewHolder(var view: ItemViewBinding) : RecyclerView.ViewHolder(view.root)


}