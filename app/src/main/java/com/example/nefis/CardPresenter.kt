package com.example.nefis

import android.content.Context
import android.view.ViewGroup
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.example.nefis.modelo.Video
import kotlin.properties.Delegates

class CardPresenter : Presenter() {
    private var mDefaultCardImage by Delegates.notNull<Int>()

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val context = parent.context
        mDefaultCardImage = R.mipmap.ic_launcher

        val cardView = object : ImageCardView(context) {
            override fun setSelected(selected: Boolean) {
                super.setSelected(selected)
            }
        }

        cardView.isFocusable = true
        cardView.isFocusableInTouchMode = true
        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val video = item as Video
        val cardView = viewHolder.view as ImageCardView

        cardView.titleText = video.title
        cardView.contentText = video.category
        cardView.setMainImageDimensions(313, 176)

        cardView.mainImageView.setImageResource(video.cardImageUrl)
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        val cardView = viewHolder.view as ImageCardView
        cardView.mainImage = null
    }

}
