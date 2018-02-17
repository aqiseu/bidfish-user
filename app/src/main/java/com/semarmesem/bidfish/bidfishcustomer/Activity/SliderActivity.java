package com.semarmesem.bidfish.bidfishcustomer.Activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.github.paolorotolo.appintro.AppIntro2;
import com.semarmesem.bidfish.bidfishcustomer.R;
import com.semarmesem.bidfish.bidfishcustomer.Utility.SampleSlide;

import butterknife.BindView;

public class SliderActivity extends AppIntro2 {


    @BindView(R.id.tv_slider_1)
    TextView tvSlider1;
    @BindView(R.id.tv_slider_2)
    TextView tvSlider2;
    @BindView(R.id.tv_slider_3)
    TextView tvSlider3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Note here that we DO NOT use setContentView();

        // Add your slide fragments here.
        // AppIntro will automatically generate the dots indicator and buttons.
        addSlide(SampleSlide.newInstance(R.layout.slider_one_layout));
        addSlide(SampleSlide.newInstance(R.layout.slider_two_layout));
        addSlide(SampleSlide.newInstance(R.layout.slider_three_layout));


        // Hide Skip/Done button.
        showSkipButton(false);
        setProgressButtonEnabled(true);


        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.
        setVibrate(true);
        setVibrateIntensity(30);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
    }


    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }


}