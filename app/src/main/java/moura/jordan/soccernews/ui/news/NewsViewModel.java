package moura.jordan.soccernews.ui.news;

import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;
import moura.jordan.soccernews.data.HeroesNewsRepositoryImpl;
import moura.jordan.soccernews.domain.News;
import moura.jordan.soccernews.domain.repository.HeroesNewsRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class NewsViewModel extends ViewModel {

    public enum State {
        DOING, DONE, ERROR;
    }

    private HeroesNewsRepository repo;
    private final MutableLiveData<List<News>> news = new MutableLiveData<>();
    private final MutableLiveData<State> state = new MutableLiveData<>();

    @Inject
    public NewsViewModel(HeroesNewsRepository repository) {
        this.repo = repository;
        this.findNews();
    }

    public void findNews() {
        state.setValue(State.DOING);
        repo.getRemoteApi().getNews().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(@NonNull Call<List<News>> call, @NonNull Response<List<News>> response) {
                if (response.isSuccessful()) {
                    news.setValue(response.body());
                    state.setValue(State.DONE);
                } else {
                    state.setValue(State.ERROR);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<News>> call, @NonNull Throwable error) {
                error.printStackTrace();
                state.setValue(State.ERROR);
            }
        });
    }

    public void saveNews(News news){
        AsyncTask.execute(() -> repo.getLocalDb().newsDAO().save(news));
    }

    public LiveData<List<News>> getNews() {
        return news;
    }

    public LiveData<State> getState() {
        return this.state;
    }
}