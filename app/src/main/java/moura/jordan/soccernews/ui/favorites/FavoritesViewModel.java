package moura.jordan.soccernews.ui.favorites;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import moura.jordan.soccernews.domain.News;
import moura.jordan.soccernews.domain.repository.HeroesNewsRepository;

@HiltViewModel
public class FavoritesViewModel extends ViewModel {

    private final HeroesNewsRepository repo;

    @Inject
    public FavoritesViewModel(HeroesNewsRepository repo) {
        this.repo = repo;
    }

    public LiveData<List<News>> loadFavoriteNews() {
        return  repo.getLocalDb().newsDAO().loadFavoriteNews();
    }

    public void saveNews(News news){
        AsyncTask.execute(() -> repo.getLocalDb().newsDAO().save(news));
    }
}