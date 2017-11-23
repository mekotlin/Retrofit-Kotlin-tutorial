package mekotlinapps.dnyaneshwar.`in`.restdemo.acitivty

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.view.View
import kotlinx.android.synthetic.main.activity_first.*
import mekotlinapps.dnyaneshwar.`in`.restdemo.R
import mekotlinapps.dnyaneshwar.`in`.restdemo.util.NetWorkConection
import org.jetbrains.anko.toast

/**
 * Created by Dnyaneshwar Dalvi on 22/11/17.
 */
class FirstScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_first)

        loadList.setOnClickListener {
            if (NetWorkConection.isNEtworkConnected(applicationContext)) {
                val inent = Intent(this@FirstScreen, MainActivity::class.java)
                startActivity(inent)
            } else {
                toast("Please turn on your Internet")
            }
        }

        tvUrl.setText(Html.fromHtml("<u>https://www.themoviedb.org/documentation/api</u>"))
        tvUrl.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val url: String = "https://www.themoviedb.org/documentation/api"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }
        })

    }
}