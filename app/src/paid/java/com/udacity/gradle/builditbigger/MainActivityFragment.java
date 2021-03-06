package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.jokedisplaylib.JokeDisplayActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {


   @BindView(R.id.instructions_text_view)
    TextView mTextView;

   @BindView(R.id.joke_btn)
   ImageButton joke_btn;

    private Context mContext;

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

        String placeHolderText =getResources().getString(R.string.welcome_text);
        mTextView.setText(placeHolderText);
        joke_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
}
