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
            Categoria("Leyendas", listOf(
                Video("La leyenda del poeta", "Leyendas", R.mipmap.Ley1, "La historia de un poeta que aun muerto sigue cantando por su amada", R.raw.Ley1),
                Video("El espejo del diablo", "Leyendas", R.mipmap.Ley2, "El espejo que te muestra tu rostro en su último momento", R.raw.Ley2),
                Video("El Quinto Sol", "Leyendas", R.mipmap.Ley3, "La historia del surgimiento del quinto sol", R.raw.Ley3),
                Video("Vampiros mexicanos", "Leyendas", R.mipmap.Ley4, "No todos los vampiros están en Europa, también en nuestro país hay", R.raw.Ley4),
                Video("Brujas", "Leyendas", R.mipmap.Ley5, "Las brujas más siniestras de nuestro país", R.raw.Ley5)
            )),
            Categoria("Musica", listOf(
                Video("Hated By Life Itself", "Musica", R.mipmap.Mus1, "Cover en Español, Compositor: Kanzaki Iori, Artista: Hatsune Miku", R.raw.Mus1),
                Video("Last's One Wipping", "Musica", R.mipmap.Mus2, "Compositor: Neru, Interprete: Hachi ft Itsuki Natsume", R.raw.Mus2),
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
