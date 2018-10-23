package id.revze.footballclub.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import id.revze.footballclub.model.Club
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.sdk25.coroutines.onClick

class ClubAdapter(private val clubs: List<Club> = listOf(), private val listener: (Club) -> Unit) : RecyclerView.Adapter<ClubAdapter.ClubViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ClubViewHolder(ClubRowUI().createView(AnkoContext.create(parent.context, parent)))

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        val club = clubs[position]
        holder.bindItem(club, listener)
    }

    override fun getItemCount() = clubs.size

    class ClubViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        private val ivClub = containerView.findViewById<ImageView>(ClubRowUI.ivClub)
        private val tvClub = containerView.findViewById<TextView>(ClubRowUI.tvClub)

        fun bindItem(club: Club, listener: (Club) -> Unit) {
            tvClub.text = club.name
            club.logo?.let { Picasso.get().load(it).into(ivClub) }
            containerView.onClick {
                listener(club)
            }
        }
    }
}