package moura.jordan.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import moura.jordan.soccernews.domain.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
         news = new MutableLiveData<>();
        // TODO Mock De Noticias
        List<News> temp_news = new ArrayList<>();
        temp_news.add(new News("Ferroviaria tem Desfalque Importante", "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain..."));
        temp_news.add(new News("Ferroviaria joga no Sabado", "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain..."));
        temp_news.add(new News("Copa do Mundo feminina esta terminando", "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain..."));

        news.setValue(temp_news);
    }

    public LiveData<List<News>> getNews() {
        return news;
    }
}