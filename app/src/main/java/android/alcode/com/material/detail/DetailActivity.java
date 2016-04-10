package android.alcode.com.material.detail;

import android.alcode.com.material.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
    }


    @Override
    protected void onStop() {
        super.onStop();
    }
}
