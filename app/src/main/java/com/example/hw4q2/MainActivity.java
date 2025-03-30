package com.example.hw4q2;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //App Interface
    private AppInterface appInterface ;

    //Game
    private Game game;

    //Initialize gesture detector
    private GestureDetector gestureDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Initializing AppInterface
        appInterface = new AppInterface(this);

        //Initialize game
        game = new Game();

        //display screen
        setContentView(appInterface);

        //create a touch handler and initialize gesture detector
        TouchHandler handler = new TouchHandler();
        gestureDetector = new GestureDetector(this,handler);

        //display initial game
        appInterface.showArray(game.getArray(),game.getWindowLocation(),game.getMessage());

    }

    //Event handler of touch event
    public boolean onTouchEvent(MotionEvent event)
    {
        //pass touch event to gesture detector
        if(!game.gameOver())
            gestureDetector.onTouchEvent(event);

        return true;
    }

    //class handles touch event
    private class TouchHandler extends GestureDetector.SimpleOnGestureListener
    {

        public boolean onSingleTapConfirmed(MotionEvent event)
        {
            //make a move
            game.move();

            //update screen
            appInterface.showArray(game.getArray(),game.getWindowLocation(),game.getMessage());

            return true;
        }

        //on double tap ,swap two numbers
        public boolean onDoubleTap(MotionEvent event)
        {
            //make a swap
            game.swap();

            //update screen
            appInterface.showArray(game.getArray(),game.getWindowLocation(),game.getMessage());

            return true;
        }
    }
}