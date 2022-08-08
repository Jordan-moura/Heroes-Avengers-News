package moura.jordan.soccernews.data.remote;

import java.util.List;

import javax.inject.Singleton;

import moura.jordan.soccernews.domain.News;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HeroesNewsApi {

    @GET("news.json")
    Call<List<News>> getNews();
}
