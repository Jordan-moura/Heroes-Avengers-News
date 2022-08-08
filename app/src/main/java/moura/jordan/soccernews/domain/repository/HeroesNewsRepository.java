package moura.jordan.soccernews.domain.repository;

import moura.jordan.soccernews.data.local.AppDatabase;
import moura.jordan.soccernews.data.remote.HeroesNewsApi;

public interface HeroesNewsRepository {
    HeroesNewsApi getRemoteApi();

    AppDatabase getLocalDb();
}
