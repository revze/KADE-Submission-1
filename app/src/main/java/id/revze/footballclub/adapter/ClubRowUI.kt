package id.revze.footballclub.adapter

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.*

class ClubRowUI : AnkoComponent<ViewGroup> {
    companion object {
        val ivClub = 1
        val tvClub = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        linearLayout {
            lparams(width = matchParent) {
                padding = dip(10)
            }

            imageView {
                id = ivClub
            }.lparams(width = dip(50), height = dip(50)) {
                rightMargin = dip(10)
            }

            textView {
                id = tvClub
            }.lparams(width = dip(0), height = wrapContent, weight = 1.toFloat()) {
                gravity = Gravity.CENTER_VERTICAL
            }
        }
    }
}