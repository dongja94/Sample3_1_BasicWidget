package com.begentgroup.samplebasicwidget;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;

    RadioGroup group;

    EditText emailView, pwView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.text_test)).setSelected(true);
        checkBox = (CheckBox)findViewById(R.id.checkBox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isForced) return;
                Toast.makeText(MainActivity.this, "isChecked : " + isChecked , Toast.LENGTH_SHORT).show();
            }
        });

        group = (RadioGroup)findViewById(R.id.group_sex);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_m :
                    case R.id.radio_f :
                        break;
                }
            }
        });

        emailView = (EditText)findViewById(R.id.edit_email);
        pwView = (EditText)findViewById(R.id.edit_password);

        pwView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = s.toString();
                if (text.length() < 4) {
                    pwView.setTextColor(Color.RED);
                } else {
                    pwView.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        pwView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    Toast.makeText(MainActivity.this, "send ..." , Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });


    }

    boolean isForced = false;
    public void onMyButtonClick(View view) {
        Toast.makeText(this, "My Button Click", Toast.LENGTH_SHORT).show();
        isForced = true;
        checkBox.setChecked(!checkBox.isChecked());
        isForced = false;

        int id = group.getCheckedRadioButtonId();
        switch (id) {
            case R.id.radio_f :
                group.check(R.id.radio_m);
                break;
            case R.id.radio_m :
                group.check(R.id.radio_f);
                break;
        }
    }
}
