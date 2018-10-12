package com.travtusworks.adamweblibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.travtusworks.adam.AdamButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.adam_button)
    AdamButton adamButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        adamButton.setCompanyId(1);

    }
}
