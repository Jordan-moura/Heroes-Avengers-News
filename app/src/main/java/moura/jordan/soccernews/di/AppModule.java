package moura.jordan.soccernews.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import moura.jordan.soccernews.data.HeroesNewsRepositoryImpl;
import moura.jordan.soccernews.data.remote.HeroesNewsApi;
import moura.jordan.soccernews.domain.repository.HeroesNewsRepository;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public HeroesNewsApi provideMyApi(){
        return new Retrofit.Builder()
                .baseUrl("https://jordan-moura.github.io/Heroes-Avengers-Api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(HeroesNewsApi.class);
    }

    @Provides
    @Singleton
    public HeroesNewsRepository provideMyRepository(HeroesNewsApi api){
        return new HeroesNewsRepositoryImpl(api);
    }
}