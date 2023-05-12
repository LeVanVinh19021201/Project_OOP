package com.example.sunriseapplication.presentation.login

import android.view.View
import com.example.sunriseapplication.ViewPagerAdapter
import com.example.sunriseapplication.base.BaseFragment
import com.example.sunriseapplication.databinding.M00FragmentAuthBinding
import com.example.sunriseapplication.presentation.widget.CustomTab
import com.google.android.material.tabs.TabLayoutMediator

class M00AuthFragment : BaseFragment<M00FragmentAuthBinding>(M00FragmentAuthBinding::inflate) {
    private lateinit var pagerAdapter: ViewPagerAdapter
    private val listText = listOf(
        "Đăng nhập",
        "Đăng ký"
    )

    override fun initView() {
        pagerAdapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        binding.viewPager.adapter=pagerAdapter
        binding.viewPager.offscreenPageLimit = 1
        TabLayoutMediator(binding.tabLayout, binding.viewPager, false, false) { tab, position ->
            tab.customView = getCustomViewTab(listText[position])
        }.attach()
    }

    override fun initObserver() {

    }

    override fun getData() {

    }

    override fun onViewClicked(view: View?) {

    }

    override fun onClick(p0: View?) {

    }

    private fun getCustomViewTab(
        text: String,
    ): CustomTab {
        val tab = CustomTab(requireContext())
        tab.text.text = text
        return tab
    }
}