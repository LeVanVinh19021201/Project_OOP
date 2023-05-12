package com.example.sunriseapplication.presentation.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.sunriseapplication.R

class CustomTab(context: Context, attributeSet: AttributeSet? = null) :
    LinearLayout(context, attributeSet) {
    var text: TextView

    init {
        inflate(getContext(), R.layout.custom_tab_viewpager, this)
        text = findViewById(R.id.tv_title)
    }

    override fun setSelected(selected: Boolean) {
        super.setSelected(selected)
        val color = if(selected){
            R.color.active

        } else {
            R.color.gray_666
        }
        text.setTextColor(ContextCompat.getColor(context,color))
    }
}