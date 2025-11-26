package com.example.nefis

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.nefis.modelo.Video
import com.example.nefis.otros.PlayFragment

class PlayActivity : FragmentActivity() {

    companion object {
        const val MOVIE_EXTRA = "movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            val video = intent?.getParcelableExtra<Video>(MOVIE_EXTRA)

            val fragment = PlayFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(MOVIE_EXTRA, video)
                }
            }

            supportFragmentManager.beginTransaction()
                .replace(android.R.id.content, fragment)
                .commit()
        }
    }
}
