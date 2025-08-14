package com.creativeitinstitute.shoppingbucket.data.service

import android.net.Uri
import com.creativeitinstitute.shoppingbucket.data.models.Product
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.storage.UploadTask

interface SellerService {

    fun uploadProductImage(productImageUri: Uri): UploadTask

    fun uploadProduct(product: Product): Task<Void>

    fun getAllProductByUserID(userID: String): Task<QuerySnapshot>


}