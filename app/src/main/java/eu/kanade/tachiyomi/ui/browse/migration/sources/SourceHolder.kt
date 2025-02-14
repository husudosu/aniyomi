package eu.kanade.tachiyomi.ui.browse.migration.sources

import android.view.View
import androidx.core.view.isVisible
import eu.davidea.viewholders.FlexibleViewHolder
import eu.kanade.tachiyomi.animesource.icon
import eu.kanade.tachiyomi.databinding.SourceMainControllerItemBinding
import eu.kanade.tachiyomi.source.icon
import eu.kanade.tachiyomi.util.system.LocaleHelper

class SourceHolder(view: View, val adapter: SourceAdapter) :
    FlexibleViewHolder(view, adapter) {

    private val binding = SourceMainControllerItemBinding.bind(view)

    fun bind(item: SourceItem) {
        val source = item.source

        binding.title.text = "${source.name} (${item.mangaCount})"
        binding.subtitle.isVisible = source.lang != ""
        binding.subtitle.text = LocaleHelper.getDisplayName(source.lang)

        itemView.post {
            binding.image.setImageDrawable(source.icon())
        }
    }
    fun bind(item: AnimeSourceItem) {
        val source = item.source

        binding.title.text = "${source.name} (${item.animeCount})"
        binding.subtitle.isVisible = source.lang != ""
        binding.subtitle.text = LocaleHelper.getDisplayName(source.lang)

        itemView.post {
            binding.image.setImageDrawable(source.icon())
        }
    }
}
