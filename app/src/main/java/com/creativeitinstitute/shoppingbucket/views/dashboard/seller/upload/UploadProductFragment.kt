package com.creativeitinstitute.shoppingbucket.views.dashboard.seller.upload

import android.Manifest
import android.app.Activity
import android.os.Build
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import com.creativeitinstitute.shoppingbucket.base.BaseFragment
import com.creativeitinstitute.shoppingbucket.core.areAllPermissionsGranted
import com.creativeitinstitute.shoppingbucket.core.extract
import com.creativeitinstitute.shoppingbucket.core.requestPermissions
import com.creativeitinstitute.shoppingbucket.data.models.Product
import com.creativeitinstitute.shoppingbucket.databinding.FragmentUploadProductBinding
import com.github.dhaval2404.imagepicker.ImagePicker
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UploadProductFragment : BaseFragment<FragmentUploadProductBinding>(
    FragmentUploadProductBinding::inflate
) {
    override fun setListener() {

        permissionsRequest = getPermissionsRequest()

        with(binding) {
            ivProduct.setOnClickListener {
                requestPermissions(permissionsRequest,permissionList)
            }


            btnUploadProduct.setOnClickListener {

                val name = etProductName.extract()
                val price = etProductPrice.extract()
                val description = etProductDescription.extract()
                val amount = etProductAmount.extract()


                val product = Product(
                    name = name,
                    description = description,
                    price = price.toDouble(),
                    amount = amount.toInt()
                )

                uploadProduct(product)

            }
        }

    }

    private fun getPermissionsRequest(): ActivityResultLauncher<Array<String>> {

        return registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){

            if (areAllPermissionsGranted(permissionList)){

                ImagePicker.with(this)
                    .compress(1024)         //Final image size will be less than 1 MB(Optional)
                    .maxResultSize(1080, 1080)  //Final image resolution will be less than 1080 x 1080(Optional)
                    .createIntent { intent ->
                        startForProfileImageResult.launch(intent)
                    }
                Toast.makeText(requireContext(), "Ase", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(requireContext(), "Nai", Toast.LENGTH_LONG).show()
            }


        }

    }

    private fun uploadProduct(product: Product) {

    }

    override fun allObserver() {

    }

    companion object{
        private val permissionList = if (Build.VERSION.SDK_INT >=33){
            arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.READ_MEDIA_IMAGES
            )
        }else{
            arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        }
    }
    private lateinit var permissionsRequest: ActivityResultLauncher<Array<String>>


    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            if (resultCode == Activity.RESULT_OK) {
                //Image Uri will not be null for RESULT_OK
                val fileUri = data?.data!!
                binding.ivProduct.setImageURI(fileUri)
            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                Toast.makeText(requireContext(), ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Task Cancelled", Toast.LENGTH_SHORT).show()
            }
        }

}