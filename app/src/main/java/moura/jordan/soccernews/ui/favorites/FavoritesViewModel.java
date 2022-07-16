package moura.jordan.soccernews.ui.favorites;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import moura.jordan.soccernews.data.SoccerNewsRepository;
import moura.jordan.soccernews.domain.News;

public class FavoritesViewModel extends ViewModel {

    public FavoritesViewModel() {
    }

    public LiveData<List<News>> loadFavoriteNews() {
        return  SoccerNewsRepository.getInstance().getLocalDb().newsDAO().loadFavoriteNews();
    }

    public void saveNews(News news){
        AsyncTask.execute(() -> SoccerNewsRepository.getInstance().getLocalDb().newsDAO().save(news));
    }

}