package com.owenlejeune.wrapcontentviewpager

import android.content.Context
import android.util.AttributeSet

class VerticalWrapContentViewPager(context: Context, attrs: AttributeSet) : WrapContentViewPager(context, attrs) {

    init {
        _wrapWidth = false
        _wrapHeight = true
    }

}