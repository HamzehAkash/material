package android.alcode.com.material.models;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Hamzeh on 4/1/2016.
 */
public class CApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);

    }
}
