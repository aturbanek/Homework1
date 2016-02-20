package com.example.anthony.homework1;

import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TakeQuiz extends AppCompatActivity implements TextFrag.OnFragmentInteractionListener,
ImageFrag.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_quiz);
        getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, ImageFrag.newInstance(null))
                        .addToBackStack(null)
                        .commit();
}

    @Override
    public void onFragmentInteraction(Uri uri)
    {

    }

}
