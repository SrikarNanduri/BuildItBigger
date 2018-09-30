package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.jokedisplaylib.JokeDisplayActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final String TAG = EndpointsAsyncTask.class.getSimpleName();
   @BindView(R.id.instructions_text_view)
    TextView mTextView;

   @BindView(R.id.joke_btn)
   ImageButton joke_btn;

    private Context mContext;
    private InterstitialAd mInterstitialAd;

    public MainActivityFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."

        mInterstitialAd = new InterstitialAd(mContext);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        String placeHolderText =getResources().getString(R.string.welcome_text);
        mTextView.setText(placeHolderText);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        joke_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.e(TAG, getString(R.string.error));
                }
            }
        });

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                InterstitialAd();
                tellJoke();
            }
        });

        return root;
    }

    public void tellJoke() {

        new EndpointsAsyncTask(new EndpointsAsyncTask.TaskCompleteListener() {
            @Override
            public void onTaskComplete(String jokeReceived) {
                if (jokeReceived != null) {
                    Intent intent = new Intent(mContext, JokeDisplayActivity.class);
                    intent.putExtra(JokeDisplayActivity.INTENT_KEY_JOKE, jokeReceived);
                    startActivity(intent);
                } else {
                    Toast.makeText(mContext, R.string.error, Toast.LENGTH_SHORT).show();
                }
            }
        }).execute(mContext);
    }

    private void InterstitialAd() {
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }


}
