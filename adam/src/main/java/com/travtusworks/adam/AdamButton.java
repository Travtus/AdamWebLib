package com.travtusworks.adam;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by teodora on 14.06.2018.
 */

public class AdamButton extends FloatingActionButton {

    private static final String TAG = "AdamButton";

    public AdamButton(Context context) {
        super(context);
    }

    public AdamButton(final Context context, AttributeSet attrs) {
        super(context, attrs);

        setImageDrawable(context.getResources().getDrawable(R.drawable.adam_large));
        setBackgroundTintList(context.getResources().getColorStateList(R.color.white_color));
        setScaleType(ScaleType.CENTER);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setElevation(0);
        }
        ViewCompat.setElevation(this, 0);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i(TAG,"the ADAM button was clicked");

                Intent intent = new Intent(context, com.travtusworks.adam.AdamActivity.class);
                context.startActivity(intent);

            }
        });
    }

    public AdamButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
