package caiofa.com.beersmvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import caiofa.com.beersmvvm.databinding.ItemBeerBinding
import caiofa.com.beersmvvm.model.Beer

class BeerListAdapter : RecyclerView.Adapter<BeerListAdapter.ViewHolder>() {
    private lateinit var beerList:List<Beer>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerListAdapter.ViewHolder {
        val binding: ItemBeerBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_beer, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BeerListAdapter.ViewHolder, position: Int) {
        holder.bind(beerList[position])
    }

    override fun getItemCount(): Int {
        return if(::beerList.isInitialized) beerList.size else 0
    }

    fun updateBeerList(beerList:List<Beer>){
        this.beerList = beerList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemBeerBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = BeerViewModel()

        fun bind(beer: Beer){
            viewModel.bind(beer)
            binding.viewModel = viewModel
        }
    }
}