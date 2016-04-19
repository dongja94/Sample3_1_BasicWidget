package com.begentgroup.samplebasicwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.text_test)).setSelected(true);
    }

    public void onMyButtonClick(View view) {
        Toast.makeText(this, "My Button Click", Toast.LENGTH_SHORT).show();
        switch (view.getId()) {
            case R.id.button :
                // ...
                break;
            case R.id.textView :
                // ...
                break;
        }
    }
}
