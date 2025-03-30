package com.example.hw4q2;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AppInterface extends RelativeLayout
{
    //array of TextView
    private TextView[] viewArray;

    //the size of the array
    private final int SIZE = 10;

    //message text view
    private TextView message;

    //grid to hold the array
    private GridLayout myGrid ;



    //public constructor
    public AppInterface(Context context)
    {

        super(context);

        final int DP = (int)(getResources().getDisplayMetrics().density);

        //create a gridLayout inside a RelativeLayout
        myGrid = new GridLayout(context);
        myGrid.setId(GridLayout.generateViewId());
        myGrid.setColumnCount(1);

        //setting layouts for the grid
        LayoutParams myGridLayouts = new LayoutParams
                (
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
        myGridLayouts.addRule(RelativeLayout.CENTER_HORIZONTAL);
        myGrid.setLayoutParams(myGridLayouts);

        //creating an textView array
        viewArray = new TextView[SIZE];

        //Initializing the array
        for(int x = 0 ; x < viewArray.length ; x++ )
        {
            viewArray[x] = new TextView(context);
            viewArray[x].setBackgroundColor(Color.parseColor("#87CEEB")); //window color 4169e1
            viewArray[x].setText(" ");
            viewArray[x].setTextAlignment(ViewGroup.TEXT_ALIGNMENT_CENTER);
            viewArray[x].setGravity(Gravity.CENTER);
            viewArray[x].setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
            viewArray[x].setTextColor(Color.parseColor("#FF000000"));
            GridLayout.LayoutParams params = new GridLayout.LayoutParams( );
            params.width = 80*DP;
            params.height  = 80*DP;
            params.rowSpec = GridLayout.spec(x, 1);
            params.topMargin = params.bottomMargin = 1;
            params.leftMargin = params.rightMargin = 1;

            if (x == 0) params.topMargin = 150;
            viewArray[x].setLayoutParams(params);
            myGrid.addView(viewArray[x]);
        }

        //adding the grid to the view
        addView(myGrid);

        //Initializing the message text View
        message = new TextView(context);
        message.setId(TextView.generateViewId());
        message.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        message.setTextColor(Color.parseColor("#FFFFFFFF"));
        message.setTextAlignment(ViewGroup.TEXT_ALIGNMENT_CENTER);
        message.setGravity(Gravity.CENTER);
        message.setBackgroundColor(Color.parseColor("#505050"));
        //setting params for the message
        RelativeLayout.LayoutParams messageParams = new RelativeLayout.LayoutParams(800,150);
        messageParams.addRule(CENTER_HORIZONTAL);
        messageParams.addRule(RelativeLayout.BELOW,myGrid.getId());
        messageParams.topMargin = 100;
        message.setLayoutParams(messageParams);
        //adding message to the view
        addView(message);


        //setting the background screen color
        setBackgroundColor(Color.parseColor("#DDDDDD"));

    }

    //method displays array from game class
    public void showArray(int[] array, int windowLocation , String str )
    {
        //show the array on textView
        for(int x =0 ; x < viewArray.length ; x++)
        {
            //set texts from the array
            viewArray[x].setText(array[x]+"");
            viewArray[x].setBackgroundColor(Color.parseColor("#87CEEB"));
        }

        //highlight window
        viewArray[windowLocation].setBackgroundColor(Color.parseColor("#4F8AAF"));
        viewArray[windowLocation+1].setBackgroundColor(Color.parseColor("#4F8AAF"));

        //show the message
        message.setText(str);
    }
}
