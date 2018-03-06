package net.acosta.mike.xfiles

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.acosta.mike.xfiles.adapter.EpisodesPagerAdapter
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat


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
