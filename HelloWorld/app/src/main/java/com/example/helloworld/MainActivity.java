package com.example.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

/*
Written by H. David Gleaton
1/25/21
 */
public class MainActivity extends AppCompatActivity {
    private int clickcount;

    //pre:
    //post: Creates instance new or based off savedInstanceState. Sets clickcount to 0 for image rotation
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickcount = 0;
    }

    //pre: View is created
    //post: Changes ImageButton ResumePic's resource from drawable to a different pic.
    public void onPicClick(View view){
        //Clickcount variable updated for each click
        clickcount += 1;
        //Switch cases pivot on which number the rotation is on
        switch (clickcount){
            case 1:
                /*
                Use of this ImageButton object to get the view by id
                Then setting the resource to a different location to change it.
                The first case will always be tiggered.
                 */
                ImageButton ResumePic = findViewById(R.id.ResumePic);
                ResumePic.setImageResource(R.drawable.cat1);
                break;
            case 2:
                ResumePic = findViewById(R.id.ResumePic);
                ResumePic.setImageResource(R.drawable.pic2);
                break;
            case 3:
                //Set the clickcount to 0 to place it at the beginning of the rotation
                ResumePic = findViewById(R.id.ResumePic);
                ResumePic.setImageResource(R.drawable.pic1);
                clickcount = 0;
                break;
        }

    }
    //pre: State is created
    //post: Redirects user to the learnview.xml layout page
    public void onLearnClick(View view){
        setContentView(R.layout.learnview);

    }

    //pre: State is created
    //post: Returns user back to activity_main.xml layout page
    public void onReturnClick(View view) {
        setContentView(R.layout.activity_main);
    }

    //pre: State is created, I am not banned from LinkdIn
    //post: Opens David Gleaton's LinkdIn page via the default browser
    public void onWebClick(View view){
        //Use of the Intent to open up the default browser.
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/david-gleaton-508b58191/"));
        startActivity(browserIntent);

    }
}