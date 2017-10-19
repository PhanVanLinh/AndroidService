package toong.vn.androidservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import toong.vn.androidservice.boundservice.BoundActivity;
import toong.vn.androidservice.unboundservice.UnBoundActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void unBoundServiceExampleClick(View v){
        startActivity(new Intent(this, UnBoundActivity.class));
    }

    public void boundServiceExampleClick(View v){
        startActivity(new Intent(this, BoundActivity.class));
    }
}
