package moura.jordan.soccernews.data;

import androidx.room.Room;

import moura.jordan.soccernews.App;
import moura.jordan.soccernews.data.local.AppDatabase;
import moura.jordan.soccernews.data.remote.SoccerNewsApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SoccerNewsRepository {

    // Region Constantes
    private static final String REMOTE_API_URL = "https://jordan-moura.github.io/Heroes-Avengers-Api/";
    private static final String LOCAL_DB_NAME = "soccer-news";

    // region atributos: encapsulam o acesso a API (Retrofit) e banco de dados local (Room)
    private SoccerNewsApi remoteApi;
    private AppDatabase localDb;

    public SoccerNewsApi getRemoteApi() { return remoteApi; }

    public AppDatabase getLocalDb() {
        return localDb;
    }

    // region Singleton : garante uma instancia unica dos atributos relacionados ao Retrofit e Room
    private SoccerNewsRepository () {
        remoteApi = new Retrofit.Builder()
                .baseUrl(REMOTE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SoccerNewsApi.class);

        localDb = Room.databaseBuilder(App.getInstance(), AppDatabase.class, LOCAL_DB_NAME).build();
    }

    public static SoccerNewsRepository getInstance() {return LazyHolder.INSTANCE; }

    private static class LazyHolder{

        private static final SoccerNewsRepository INSTANCE = new SoccerNewsRepository();
    }
}