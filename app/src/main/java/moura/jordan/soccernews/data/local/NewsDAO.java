package moura.jordan.soccernews.data.local;


import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import moura.jordan.soccernews.domain.News;

@Dao
public interface NewsDAO {
    @Query("SELECT * FROM news WHERE favorite = :favorite")
    List<News> loadFavoriteNews(boolean favorite);
}
