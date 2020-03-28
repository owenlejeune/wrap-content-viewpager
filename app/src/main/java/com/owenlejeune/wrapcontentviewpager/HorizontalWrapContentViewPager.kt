package com.owenlejeune.wrapcontentviewpager

import android.content.Context
import android.util.AttributeSet

class HorizontalWrapContentViewPager(context: Context, attrs: AttributeSet): WrapContentViewPager(context, attrs) {

    init {
        _wrapWidth = true
        _wrapHeight = false
    }

}