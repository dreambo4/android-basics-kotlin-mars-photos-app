/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.marsphotos.view.overview

import android.content.Intent
import androidx.fragment.app.viewModels
import com.example.android.marsphotos.view.base.BaseFragment
import com.example.android.marsphotos.databinding.FragmentOverviewBinding
import com.example.android.marsphotos.view.detail.DetailActivity

/**
 * This fragment shows the the status of the Mars photos web services transaction.
 */
class OverviewFragment : BaseFragment<FragmentOverviewBinding>() {

    private val viewModel: OverviewViewModel by viewModels()

    override fun initView() {
        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        // Sets the adapter of the photosGrid RecyclerView
        binding.photosGrid.adapter = PhotoGridAdapter {
            var intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.INTENT_KEY_DATA, it)
            startActivity(intent)
        }

        binding.ivRenew.setOnClickListener {
            viewModel.getMarsPhotos()
        }
    }
}
