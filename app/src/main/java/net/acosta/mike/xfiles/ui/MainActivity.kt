package net.acosta.mike.xfiles.ui

import android.os.Bundle
import net.acosta.mike.xfiles.adapter.EpisodesPagerAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import net.acosta.mike.xfiles.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(this.toolbar)
        supportActionBar?.setIcon(R.drawable.ic_action_bar_xfiles)

        collapsing_toolbar.title = resources.getString(R.string.app_name)
        collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(this, R.color.colorPrimary))

        view_pager.adapter = EpisodesPagerAdapter(supportFragmentManager)
        tabs.setupWithViewPager(view_pager)

        val tabSelectedListener = object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                view_pager.currentItem = tab.position
            }
        }

        tabs.addOnTabSelectedListener(tabSelectedListener)
    }
}
