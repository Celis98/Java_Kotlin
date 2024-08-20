package com.example.java.kotlin.java_code;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.java.kotlin.R;
import com.example.java.kotlin.java_code.title.TitleManager;

public class JavaMainActivity extends AppCompatActivity {

    private TitleManager titleManager;

    private Button btnUpdateTitle;
    private Button btnSayHello;
    private TextView tvTitle;
    private SeekBar sbTitleOpacity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTitleManager();
        initViews();
        initListeners();
    }

    private void initTitleManager() {
        titleManager = new TitleManager();
        titleManager.init();
    }

    private void initListeners() {
        btnUpdateTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titleManager.updateTitle();
                tvTitle.setText("Hello World! " + titleManager.getCurrentTitle());
            }
        });
        btnSayHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(
                        view.getContext(),
                        "Hello World! " + titleManager.getCurrentTitle(),
                        Toast.LENGTH_LONG
                ).show();
            }
        });
        sbTitleOpacity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvTitle.setAlpha((float) i /10);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void initViews() {
        btnUpdateTitle = findViewById(R.id.btnUpdateTitle);
        btnSayHello = findViewById(R.id.btnSayHello);
        tvTitle = findViewById(R.id.tvTitle);
        sbTitleOpacity = findViewById(R.id.sb_title_opacity);
    }
}
