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
                Video("The Everlasting Guilty Crown", "Musica", R.mipmap.Mus3, "Compositor: Ryo, Interprete: Vesperbell Yomi", R.raw.Mus3),
                Video("Slow Downer", "Musica", R.mipmap.Mus4, "Compositor: GUMI, Interprete: Veserbell Yomi ft KMNZ Liz", R.raw.Mus4),
                Video("Marshall Maximizer", "Musica", R.mipmap.Mus5, "Compositor: Hiiragi Magnetite, Interprete: Aitsuki Nakuru", R.raw.Mus5)
            )),
            Categoria("Avances", listOf(
                Video("86: Eighty-Six", "Avances", R.mipmap.Ava1, "Estreno: Abril 10 de 2021, Stream en Crunchyroll", R.raw.Ava1),
                Video("86: Eighty-Six Cour 2", "Avances", R.mipmap.Ava1, "Estreno: Octubre 2 de 2021, Stream en Crunchyroll", R.raw.Ava2),
                Video("Frieren: Beyond's the Journey End", "Avances", R.mipmap.Ava3, "Estreno: Septiembre 29 de 2023, Stream en Crunchyroll", R.raw.Ava3),
                Video("An Archdemon’s Dilemma", "Avances", R.mipmap.Ava4, "Estreno: Enero 2024, Stream en Crunchyroll", R.raw.Ava4),
                Video("Zenshu", "Avances", R.mipmap.Ava5, "Estreno: Enero 5 de 2025, Stream en Crunchyroll", R.raw.Ava5)
            )),
            Categoria("Datos", listOf(
                Video("Los 5 paises más ricos de Hispanoamérica", "Datos", R.mipmap.Dat1, "Conoce los 5 países con mayor PIB", R.raw.Dat1),
                Video("Los 5 países con más hispanohablantes", "Datos", R.mipmap.Dat2, "Conoce los 5 países donde mas se habla español", R.raw.Dat2),
                Video("La novela que predijo el hundimiento del titanic", "Datos", R.mipmap.Dat3, "Conoce la novela que predijo el hundimiento del titanic", R.raw.Dat3),
                Video("Los 5 países con más turistas", "Datos", R.mipmap.Dat4, "Conoce los 5 países más visitados", R.raw.Dat4),
                Video("Gran Bretaña no es un país", "Datos", R.mipmap.Dat5, "Conoce la diferencia entre Inglaterra, Gran Bretaña y Reino Unido", R.raw.Dat5)
            )),
            Categoria("Musica2", listOf(
                Video("Ragnarok in Remembrance", "Musica2", R.mipmap.Mus6, "Aitsuki Nakuru, Hifumi Inc. 2023", R.raw.Mus6),
                Video("Stellar Stellar", "Musica2", R.mipmap.Mus7, "Hoshimachi Suisei, Taku Inoue. 2021", R.raw.Mus7),
                Video("Kireigoto", "Musica2", R.mipmap.Mus8, "Hoshimachi Suisei, Taku Inoue. 2025", R.raw.Mus8),
                Video("Issei", "Musica2", R.mipmap.Mus9, "Vesperbell, Veena. 2025", R.raw.Mus9),
                Video("Emergence", "Musica2", R.mipmap.Mus10, "Vesperbell, Veena. 2024", R.raw.Mus10)
            ))
        )
    }
}
