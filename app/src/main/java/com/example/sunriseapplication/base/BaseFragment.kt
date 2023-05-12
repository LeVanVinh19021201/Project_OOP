package com.example.sunriseapplication.base

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding>(private val bindingInflater: (layoutInflater: LayoutInflater) -> T) :
    Fragment(), View.OnClickListener {
    protected var isConnected: Boolean = false
    var _binding: T? = null
    protected val binding get() = _binding!!
    var TAG: String = this.javaClass.simpleName
    var isClickAble = true

    // child
    var tabPosition: Int = -1


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initArgs()
    }

    open fun initArgs() {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObserver()
        if (isInitGetData())
            getData()
    }

    open fun isInitGetData(): Boolean = true
    abstract fun initView()
    abstract fun initObserver()
    abstract fun getData()

    open fun onReselectTab() {
        if (isClickAble) {
            Handler(Looper.getMainLooper()).postDelayed({
                isClickAble = true
            }, 1000)
            isClickAble = false
            if (isTopPosition())
                getData()
            else
                scrollToTop()
        }
    }

    open fun getScrollAbleView(): View? = null
    private fun isTopPosition(): Boolean {
        when (val view = getScrollAbleView()) {
            is NestedScrollView -> {
                return view.scrollY == 0
            }

            is RecyclerView -> {
                return (view.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition() == 0
            }
        }
        return false
    }

    private fun scrollToTop() {
        when (val view = getScrollAbleView()) {
            is NestedScrollView -> {
                view.smoothScrollTo(0, 0)
            }

            is RecyclerView -> {
                view.smoothScrollToPosition(0)
            }
        }
    }

    abstract fun onViewClicked(view: View?)
}