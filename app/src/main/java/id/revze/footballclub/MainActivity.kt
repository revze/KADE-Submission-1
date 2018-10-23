package id.revze.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import id.revze.footballclub.adapter.ClubAdapter
import id.revze.footballclub.model.Club
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.verticalLayout
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    private var clubs: MutableList<Club> = mutableListOf()
    private lateinit var rvClub: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            rvClub = recyclerView {  }
        }

        initData()
        rvClub.layoutManager = LinearLayoutManager(this)
        rvClub.adapter = ClubAdapter(clubs) {
            startActivity<ClubDetailActivity>("logo" to it.logo, "name" to it.name, "description" to it.description)
        }
    }

    private fun initData() {
        val names = resources.getStringArray(R.array.club_name);
        val images = resources.obtainTypedArray(R.array.club_image)
        val descriptions = resources.getStringArray(R.array.club_description)

        for (i in names.indices) clubs.add(Club(names[i], images.getResourceId(i, 0), descriptions[i]))

        images.recycle()
    }
}
