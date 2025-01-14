package com.example.android.marsphotos.view.detail

import com.example.android.marsphotos.view.base.BaseActivity
import com.example.android.marsphotos.view.bindImage
import com.example.android.marsphotos.databinding.ActivityDetailBinding
import com.example.android.marsphotos.network.MarsPhoto

class DetailActivity : BaseActivity<ActivityDetailBinding>() {
    companion object {
        const val INTENT_KEY_DATA = "DATA"
    }

    override fun initView() {
        val photo = intent.getSerializableExtra(INTENT_KEY_DATA) as MarsPhoto

        binding.tvID.text = photo.id
        binding.tvUrl.text = photo.imgSrcUrl
        bindImage(binding.marsImage, photo.imgSrcUrl)
    }
}
