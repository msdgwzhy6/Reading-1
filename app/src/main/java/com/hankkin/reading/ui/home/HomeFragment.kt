package com.hankkin.reading.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import com.hankkin.reading.R
import com.hankkin.reading.adapter.HomeFragmentPagerAdapter
import com.hankkin.reading.adapter.MainFragmentAdapter
import com.hankkin.reading.base.BaseFragment
import com.hankkin.reading.ui.home.blog.BlogFragment
import com.hankkin.reading.ui.home.news.NewsFragment
import com.hankkin.reading.ui.home.post.PostFragment
import com.hankkin.reading.ui.person.PersonFragment
import com.hankkin.reading.ui.translate.TranslateFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_post.*

/**
 * Created by huanghaijie on 2018/5/15.
 */
class HomeFragment : BaseFragment() {

    private val mFgList = listOf<Fragment>(
            NewsFragment(),
            PostFragment(),
            BlogFragment()
    )

    override fun initViews() {
    }

    public fun newInstance(index: Int) {
        val fragment = HomeFragment()
        val args = Bundle()
        args.putInt("index", index)
        fragment.arguments = args
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initData() {
        val adapter = HomeFragmentPagerAdapter(childFragmentManager,mFgList )
        vp_home.adapter = adapter
        vp_home.offscreenPageLimit = 2
        vp_home.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(p0: Int) {
                setCurrent(p0)
            }

        })
        setCurrent(0)
    }

    fun setCurrent(index: Int) {
        var isOne = false
        var isTwo = false
        var isThree = false
        when (index) {
            0 -> {
                isOne = true
            }
            1 -> {
                isTwo = true
            }
            2 -> {
                isThree = true
            }
        }
        vp_home.currentItem = index
        iv_title_one.isSelected = isOne
        iv_title_two.isSelected = isTwo
        iv_title_three.isSelected = isThree
    }

}