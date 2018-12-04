package ir.heydarii.appupdater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.heydarii.appupdater.pojomodel.UpdaterStoreList
import kotlinx.android.synthetic.main.download_options_item.view.*

class StoresRecyclerAdapter(private val list: List<UpdaterStoreList>, val listener: (UpdaterStoreList) -> Unit) : RecyclerView.Adapter<StoresRecyclerAdapter.SoresViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoresViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.download_options_item, parent, false)
        return SoresViewHolder(view, listener)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: SoresViewHolder, position: Int) {
        holder.onBind(list[position])
    }


    class SoresViewHolder(val view: View, val listener: (UpdaterStoreList) -> Unit) : RecyclerView.ViewHolder(view) {
        fun onBind(item: UpdaterStoreList) {
            view.txtStoreTitle.text = item.title
            view.imgStore.setImageResource(item.icon)
            view.setOnClickListener { listener(item) }
        }

    }
}