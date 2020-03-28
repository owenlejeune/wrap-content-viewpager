package com.owenlejeune.wrapcontentviewpager

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.viewpager.widget.ViewPager

open class WrapContentViewPager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {

    companion object {
        private const val HEIGHT_FLAG = 1
        private const val WIDTH_FLAG = 2
    }

    protected var _wrapHeight: Boolean = false
    val wrapHeight: Boolean
        get() = _wrapHeight

    protected var _wrapWidth: Boolean = false
    val wrapWidth: Boolean
        get() = _wrapWidth

    init {
        val arr = context.obtainStyledAttributes(attrs, R.styleable.WrapContentViewPager)
        val wrapStyle = arr.getInt(R.styleable.WrapContentViewPager_wrap_method, 0)
        if (wrapStyle and HEIGHT_FLAG > 0) { _wrapHeight = true }
        if (wrapStyle and WIDTH_FLAG > 0) { _wrapWidth = true }
        arr.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var hMeasureSpec = heightMeasureSpec
        var wMeasureSpec = widthMeasureSpec

        if (_wrapHeight)
            hMeasureSpec = measureWrap(widthMeasureSpec, heightMeasureSpec) { v -> v.measuredHeight }

        if (_wrapWidth)
            wMeasureSpec = measureWrap(heightMeasureSpec, widthMeasureSpec) { v -> v.measuredWidth }

        super.onMeasure(wMeasureSpec, hMeasureSpec)
    }

    private fun measureWrap(nMeasureSpec: Int, measureSpec: Int, childDim: (View) -> Int): Int {
        var nSpec = measureSpec

        var dim = 0
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            child.measure(nMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED))
            val d = childDim(child)
            if (d > dim) { dim = d }
        }

        if (dim != 0) {
            nSpec = MeasureSpec.makeMeasureSpec(dim, MeasureSpec.EXACTLY)
        }

        return nSpec
    }

}