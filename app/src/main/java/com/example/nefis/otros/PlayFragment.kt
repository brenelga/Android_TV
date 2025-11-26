package com.example.nefis.otros

import android.net.Uri
import android.os.Bundle
import androidx.leanback.app.VideoSupportFragment
import androidx.leanback.app.VideoSupportFragmentGlueHost
import androidx.leanback.media.MediaPlayerAdapter
import androidx.leanback.media.PlaybackTransportControlGlue
import androidx.leanback.widget.PlaybackControlsRow
import com.example.nefis.PlayActivity
import com.example.nefis.modelo.Video

class PlayFragment : VideoSupportFragment() {

    private lateinit var transportControlGlue: PlaybackTransportControlGlue<MediaPlayerAdapter>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val video = requireActivity().intent.getParcelableExtra<Video>(PlayActivity.MOVIE_EXTRA) ?: return

        val glueHost = VideoSupportFragmentGlueHost(this)
        val playerAdapter = MediaPlayerAdapter(requireContext())
        playerAdapter.setRepeatAction(PlaybackControlsRow.RepeatAction.INDEX_NONE)

        transportControlGlue = PlaybackTransportControlGlue(requireContext(), playerAdapter)
        transportControlGlue.host = glueHost

        transportControlGlue.title = video.title
        transportControlGlue.subtitle = video.description

        transportControlGlue.playWhenPrepared()

        val videoUri = "android.resource://${requireContext().packageName}/${video.videoUrl}"
        playerAdapter.setDataSource(Uri.parse(videoUri))
    }

    override fun onPause() {
        super.onPause()
        transportControlGlue.pause()
    }
}
