package com.picpay.desafio.android.ui

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableBoolean
import com.picpay.desafio.android.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("android:image", "android:progress", requireAll = true)
    fun setImage(imageView: CircleImageView, image: String, showProgress: ObservableBoolean) {
        Picasso.get()
            .load(image)
            .error(R.drawable.ic_round_account_circle)
            .into(imageView, object : Callback {
                override fun onSuccess() {
                   showProgress.set(false)
                }

                override fun onError(e: Exception?) {
                    showProgress.set(false)
                }
            })
    }

    @JvmStatic
    @BindingAdapter("android:visibility")
    fun setVisibility(view: View, showView: ObservableBoolean) {
        view.visibility = if (showView.get()) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

}