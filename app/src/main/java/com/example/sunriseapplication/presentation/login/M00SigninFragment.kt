package com.example.sunriseapplication.presentation.login

import android.view.View
import com.example.sunriseapplication.base.BaseFragment
import com.example.sunriseapplication.databinding.M00FragmentSigninBinding
import com.example.sunriseapplication.presentation.helper.NavigationManager
import com.example.sunriseapplication.presentation.main.M01HomeFragment

class M00SigninFragment :
    BaseFragment<M00FragmentSigninBinding>(M00FragmentSigninBinding::inflate) {
    override fun initView() {
        binding.btnSignIn.setOnClickListener{
            NavigationManager.getInstance().openFragment(M01HomeFragment.newInstance())
        }
    }

    override fun initObserver() {

    }

    override fun getData() {

    }

    override fun onClick(view: View?) {

    }
}