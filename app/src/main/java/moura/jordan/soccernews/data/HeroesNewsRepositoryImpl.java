package moura.jordan.soccernews.data;

import androidx.room.Room;

import javax.inject.Inject;
import javax.inject.Singleton;

import moura.jordan.soccernews.App;
import moura.jordan.soccernews.data.local.AppDatabase;
import moura.jordan.soccernews.data.remote.HeroesNewsApi;
import moura.jordan.soccernews.domain.repository.HeroesNewsRepository;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class HeroesNewsRepositoryImpl implements HeroesNewsRepository {

    // Region Constantes
    private static final String LOCAL_DB_NAME = "soccer-news";

    // region atributos: encapsulam o acesso a API (Retrofit) e banco de dados local (Room)
    private final HeroesNewsApi remoteApi;
    private final AppDatabase localDb;

    @Inject
    public HeroesNewsRepositoryImpl(HeroesNewsApi remoteApi) {
        this.remoteApi = remoteApi;
        localDb = Room.databaseBuilder(App.getInstance(), AppDatabase.class, LOCAL_DB_NAME).build();
    }

    @Override
    public HeroesNewsApi getRemoteApi() { return remoteApi; }

    @Override
    public AppDatabase getLocalDb() {
        return localDb;
    }
}