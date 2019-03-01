package coursenett.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class hopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hop);
    }

    public void showMessage(View view) {

        Intent be = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(be);
    }
}
