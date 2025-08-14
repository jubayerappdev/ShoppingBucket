package com.creativeitinstitute.shoppingbucket.views.dashboard.seller.products

import android.net.Uri
import androidx.core.net.toUri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.creativeitinstitute.shoppingbucket.core.DataState
import com.creativeitinstitute.shoppingbucket.data.models.Product
import com.creativeitinstitute.shoppingbucket.data.repository.SellerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repo: SellerRepository
): ViewModel(){

   private val _productResponse = MutableLiveData<DataState<List<Product>>>()

    val productResponse: LiveData<DataState<List<Product>>> = _productResponse



    fun getProductByID(userID: String){

        _productResponse.postValue(DataState.Loading())

        repo.getAllProductByUserID(userID).addOnSuccessListener { documents->

            val productList = mutableListOf<Product>()

            documents.documents.forEach { doc->
                doc.toObject(Product::class.java)?.let {
                    productList.add(it)
                }
            }
            _productResponse.postValue(DataState.Success(productList))

        }.addOnFailureListener {
            _productResponse.postValue(DataState.Error("${it.message}"))
        }




    }
}