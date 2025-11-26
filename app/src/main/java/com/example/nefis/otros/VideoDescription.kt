package com.example.nefis.otros

import androidx.leanback.widget.AbstractDetailsDescriptionPresenter

class VideoDescription: AbstractDetailsDescriptionPresenter() {
    override fun onBindDescription(vh: ViewHolder, item: Any?) {
        val video= item as Video
        vh.title.text=video.title
        vh.subtitle.text=video.subtitle
        vh.body.text=video.description
    }

}