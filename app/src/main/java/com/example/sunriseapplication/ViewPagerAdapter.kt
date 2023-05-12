package com.example.sunriseapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sunriseapplication.presentation.login.M00SignUpFragment
import com.example.sunriseapplication.presentation.login.M00SigninFragment

class ViewPagerAdapter(
    fm: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fm, lifecycle) {
    val listFragment = ArrayList<Fragment?>(listOf(null, null, null, null, null))
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        val fragment : Fragment? = if(listFragment[position] != null){
            listFragment[position]
        } else {
            listFragment[position] = when(position){
                0 -> M00SigninFragment()
                1 -> M00SignUpFragment()
                else -> null
            }
            listFragment[position]
        }
        return fragment ?: Fragment()
    }
    fun getFragment(index: Int) : Fragment?{
        return listFragment.getOrNull(index)
    }
}