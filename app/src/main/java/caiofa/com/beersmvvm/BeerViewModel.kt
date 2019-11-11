package caiofa.com.beersmvvm

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import caiofa.com.beersmvvm.base.BaseViewModel
import caiofa.com.beersmvvm.databinding.BeerDetailsDialogBinding
import caiofa.com.beersmvvm.databinding.ItemBeerBinding
import caiofa.com.beersmvvm.model.Beer
import androidx.lifecycle.ViewModel





class BeerViewModel : BaseViewModel() {
    private val beerName = MutableLiveData<String>()
    private val beerDescription = MutableLiveData<String>()
    private val beerTagLine = MutableLiveData<String>()
    private val beerImageUrl = MutableLiveData<String>()
    private val beerFirstBrewed = MutableLiveData<String>()
    private lateinit var beer: Beer
    private lateinit var context: Context

    fun bind(beer: Beer, context: Context){
        beerName.value = beer.name
        beerDescription.value = beer.description
        beerTagLine.value = beer.tagline
        beerImageUrl.value = beer.image_url
        beerFirstBrewed .value = beer.first_brewed
        this.beer = beer
        this.context = context
    }

    fun getBeerName():MutableLiveData<String>{
        return beerName
    }

    fun getBeerDescription():MutableLiveData<String>{
        return beerDescription
    }

    fun getBeerTagLine():MutableLiveData<String>{
        return beerTagLine
    }

    fun getBeerImageUrl():MutableLiveData<String>{
        return beerImageUrl
    }

    fun getBeerFirstBrewed():MutableLiveData<String>{
        return beerFirstBrewed
    }

    fun getBeer():Beer{
        return beer
    }

    fun onClickBeer(): View.OnClickListener {
        return object : View.OnClickListener {
            override fun onClick(v: View) {

                val binding: BeerDetailsDialogBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(context),
                    R.layout.beer_details_dialog,
                    null,
                    false
                )
                val viewModel = BeerViewModel()
                viewModel.bind(beer, context)
                binding.viewModel = viewModel

                val dialog = Dialog(context)
                dialog.setContentView(binding.getRoot())

                if ( dialog.window != null ) dialog.show()

            }
        }
    }
}