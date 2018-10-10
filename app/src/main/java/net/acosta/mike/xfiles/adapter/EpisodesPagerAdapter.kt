package net.acosta.mike.xfiles.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import net.acosta.mike.xfiles.ui.EpisodesFragment


class EpisodesPagerAdapter (fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int {
        return TAB_COUNT
    }

    override fun getItem(position: Int): Fragment? {
        val fragment = EpisodesFragment()
        val args = Bundle()

        args.putInt("season", position + 1)
        fragment.arguments = args

        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        return (position + 1).toString()
    }

    companion object {
        private val TAB_COUNT = 11
    }
}