package com.example.exercicio.controller

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.exercicio.view.FisrtFragment
import com.example.exercicio.view.SecondFragment
import com.example.exercicio.view.ThirdFragment

class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FisrtFragment()
            }
            1 -> {
                SecondFragment()
            }
            else -> {
                return ThirdFragment()
            }
        }
    }


    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "First Tab"
            1 -> "Second Tab"
            else -> "Third Tab"

        }
    }

}