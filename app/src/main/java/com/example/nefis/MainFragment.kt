package com.example.nefis

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.OnItemViewClickedListener
import com.example.nefis.modelo.Categoria
import com.example.nefis.modelo.Video

class MainFragment: BrowseSupportFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title="Nuevo Video"

        loadRows()

        onItemViewClickedListener= OnItemViewClickedListener{ _, item, _, _ ->
            if (item is Video) {
                val intent = Intent(requireContext(), PlayActivity::class.java).apply{
                    putExtra(PlayActivity.MOVIE_EXTRA, item)
                }
                startActivity(intent)
            }
        }
    }

    private fun loadRows() {
        val categoriesList = getCategories()

        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())

        categoriesList.forEachIndexed { index, categoria ->
            val listRowAdapter = ArrayObjectAdapter(CardPresenter())

            listRowAdapter.addAll(0, categoria.videos)

            val header = HeaderItem(index.toLong(), categoria.nombre)

            rowsAdapter.add(ListRow(header, listRowAdapter))
        }

        adapter = rowsAdapter
    }

    private fun getCategories(): List<Categoria> {
        return listOf(
            Categoria("Comedia", listOf(
                Video("Video 1.1", "Comedia", R.mipmap.ic_launcher, "Descripción del video de comedia 1", R.raw.video_file_1_1),
                Video("Video 1.2", "Comedia", R.mipmap.ic_launcher, "Descripción del video de comedia 2", R.raw.video_file_1_2),
                Video("Video 1.3", "Comedia", R.mipmap.ic_launcher, "Descripción del video de comedia 3", R.raw.video_file_1_3),
                Video("Video 1.4", "Comedia", R.mipmap.ic_launcher, "Descripción del video de comedia 4", R.raw.video_file_1_4),
                Video("Video 1.5", "Comedia", R.mipmap.ic_launcher, "Descripción del video de comedia 5", R.raw.video_file_1_5)
            )),
            Categoria("Acción", listOf(
                Video("Video 2.1", "Acción", R.mipmap.ic_launcher, "Descripción del video de acción 1", R.raw.video_file_2_1),
                Video("Video 2.2", "Acción", R.mipmap.ic_launcher, "Descripción del video de acción 2", R.raw.video_file_2_2),
                Video("Video 2.3", "Acción", R.mipmap.ic_launcher, "Descripción del video de acción 3", R.raw.video_file_2_3),
                Video("Video 2.4", "Acción", R.mipmap.ic_launcher, "Descripción del video de acción 4", R.raw.video_file_2_4),
                Video("Video 2.5", "Acción", R.mipmap.ic_launcher, "Descripción del video de acción 5", R.raw.video_file_2_5)
            )),
            Categoria("Drama", listOf(
                Video("Video 3.1", "Drama", R.mipmap.ic_launcher, "Descripción del video de drama 1", R.raw.video_file_3_1),
                Video("Video 3.2", "Drama", R.mipmap.ic_launcher, "Descripción del video de drama 2", R.raw.video_file_3_2),
                Video("Video 3.3", "Drama", R.mipmap.ic_launcher, "Descripción del video de drama 3", R.raw.video_file_3_3),
                Video("Video 3.4", "Drama", R.mipmap.ic_launcher, "Descripción del video de drama 4", R.raw.video_file_3_4),
                Video("Video 3.5", "Drama", R.mipmap.ic_launcher, "Descripción del video de drama 5", R.raw.video_file_3_5)
            )),
            Categoria("Ciencia Ficción", listOf(
                Video("Video 4.1", "Sci-Fi", R.mipmap.ic_launcher, "Descripción del video de sci-fi 1", R.raw.video_file_4_1),
                Video("Video 4.2", "Sci-Fi", R.mipmap.ic_launcher, "Descripción del video de sci-fi 2", R.raw.video_file_4_2),
                Video("Video 4.3", "Sci-Fi", R.mipmap.ic_launcher, "Descripción del video de sci-fi 3", R.raw.video_file_4_3),
                Video("Video 4.4", "Sci-Fi", R.mipmap.ic_launcher, "Descripción del video de sci-fi 4", R.raw.video_file_4_4),
                Video("Video 4.5", "Sci-Fi", R.mipmap.ic_launcher, "Descripción del video de sci-fi 5", R.raw.video_file_4_5)
            )),
            Categoria("Documentales", listOf(
                Video("Video 5.1", "Documental", R.mipmap.ic_launcher, "Descripción del documental 1", R.raw.video_file_5_1),
                Video("Video 5.2", "Documental", R.mipmap.ic_launcher, "Descripción del documental 2", R.raw.video_file_5_2),
                Video("Video 5.3", "Documental", R.mipmap.ic_launcher, "Descripción del documental 3", R.raw.video_file_5_3),
                Video("Video 5.4", "Documental", R.mipmap.ic_launcher, "Descripción del documental 4", R.raw.video_file_5_4),
                Video("Video 5.5", "Documental", R.mipmap.ic_launcher, "Descripción del documental 5", R.raw.video_file_5_5)
            ))
        )
    }
}
