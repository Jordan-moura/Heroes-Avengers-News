package moura.jordan.soccernews;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class App extends Application {

    private static App instance;

    public static App getInstance() { return instance; }

    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;
    }
}
