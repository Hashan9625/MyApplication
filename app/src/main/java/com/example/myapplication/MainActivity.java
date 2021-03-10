 package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;


import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

//    Button chenge ;
    pl.droidsonroids.gif.GifImageView animation;
    TextView text;
    int i =1;
    private static final int RECRESULT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        chenge = (Button) findViewById(R.id.but);
        animation = (pl.droidsonroids.gif.GifImageView)findViewById(R.id.ani);
        text = (TextView)findViewById(R.id.tex);


//        chenge.getDisplay(no)

//        if (! Python.isStarted()) {
//            Python.start(new AndroidPlatform(this));
//        }
//        //start python
//
//        Python py = Python.getInstance();
//
//        PyObject pyobj = py.getModule("myPython");
//
//        PyObject obj = pyobj.callAttr("main");
//
//        text.setText(obj.toString());


    }

    public void onClick(View view){

//        if(i==1){
//            animation.setImageResource(R.drawable.giphysad);
//            i=2;
//        }
//        else if(i==2)
//        {
//            animation.setImageResource(R.drawable.giphyhapy);
//            i=1;
//        }


        // speech to text
        Intent speechIntent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        speechIntent.putExtra(RecognizerIntent.EXTRA_PROMPT,"speech");
        startActivityForResult(speechIntent,RECRESULT);  //  -------------------   run time error


    }

    // speech to text
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==RECRESULT && resultCode == RESULT_OK)
        {
            ArrayList<String> mach = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            text.setText(mach.get(0).toString());

        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}

