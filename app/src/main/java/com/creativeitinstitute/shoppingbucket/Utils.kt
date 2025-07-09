package com.creativeitinstitute.shoppingbucket

import android.widget.EditText

fun EditText.isEmpty(): Boolean{

    return if (this.text.toString().isEmpty()){
        this.error = "This place need to be fill up!"
        true
    }else{
        false
    }
}