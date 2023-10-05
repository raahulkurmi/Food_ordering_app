import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.car.ui.toolbar.MenuItem.OnClickListener
import com.example.foodorderingapp.databinding.MennurecyclerviewBinding
import com.example.foodorderingapp.detailactivity
import com.example.foodorderingapp.modelclass.recyclerviewmodelclas

class menuadapterrecycler(
    private var itemList:ArrayList<recyclerviewmodelclas>,
    private val context: Context,

) : RecyclerView.Adapter<menuadapterrecycler.mycustomadapter>() {
    private var isFiltering = false
    private val originalList = ArrayList(itemList)
    private val itemClickListener:OnClickListener?=null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mycustomadapter {
        val binding = MennurecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return mycustomadapter(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
    inner class mycustomadapter(val binding: MennurecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root){

    }

    override fun onBindViewHolder(holder: mycustomadapter, position: Int) {
        val position1 = itemList[position]
        holder.binding.imageView6.setImageResource(position1.image)
        holder.binding.textView15.text = itemList[position].foodname
        holder.binding.textView16.text = itemList[position].price







    }
//    fun filter(query: String) {
//        if (query.isBlank()) {
//            itemList = ArrayList(originalList)
//            isFiltering = false
//        } else {
//            val lowerCaseQuery = query.lowercase()
//            itemList = originalList.filter {
//                it.foodname.lowercase().contains(lowerCaseQuery)
//            } as ArrayList<recyclerviewmodelclas>
//            isFiltering = true
//        }
//        notifyDataSetChanged()
//    }
}
