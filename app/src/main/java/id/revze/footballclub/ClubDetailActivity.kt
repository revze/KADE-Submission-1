package id.revze.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import id.revze.footballclub.model.Club
import org.jetbrains.anko.*

class ClubDetailActivity : AppCompatActivity() {

    private lateinit var ivClub: ImageView
    private lateinit var tvClubName: TextView
    private lateinit var tvClubDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(10)

            ivClub = imageView {

            }.lparams(width = dip(70), height = dip(70)) {
                gravity = Gravity.CENTER_HORIZONTAL
                bottomMargin = dip(10)
            }

            tvClubName = textView {
                textSize = 16f
                gravity = Gravity.CENTER_HORIZONTAL
            }.lparams(width = matchParent) {
                bottomMargin = dip(15)
            }

            tvClubDescription = textView {

            }.lparams(width = matchParent)
        }

        intent?.let {
            Picasso.get().load(it.getIntExtra("logo", 0)).into(ivClub)
            tvClubName.setText(it.getStringExtra("name"))
            tvClubDescription.setText(it.getStringExtra("description"))
        }
    }
}
