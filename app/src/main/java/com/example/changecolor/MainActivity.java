package com.example.changecolor;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.util.Random;

public class MainActivity extends Activity {
    private View mColorRegion;
    private int[] mColorChoices =
            { Color.BLACK, Color.BLUE, Color.CYAN,
                    Color.DKGRAY, Color.GRAY, Color.GREEN,
                    Color.LTGRAY, Color.MAGENTA, Color.RED,
                    Color.WHITE, Color.YELLOW };

    /** Initializes the app when it is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mColorRegion = findViewById(R.id.color_region);
        Button colorButton =
                (Button)findViewById(R.id.color_button);
        colorButton.setOnClickListener(new ColorRandomizer());
    }

    /** Sets the color of the color region. */

    private void setRegionColor(int color) {
        mColorRegion.setBackgroundColor(color);
    }

    private class ColorRandomizer implements OnClickListener {
        /** Calls back to the outer class to set the color of View at the bottom. */
        public void onClick(View clickedButton) {
            Random generator = new Random();
            int index = generator.nextInt(mColorChoices.length);
            setRegionColor(mColorChoices[index]);
        }
    }
}
