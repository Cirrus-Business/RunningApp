package com.running.lizzy.runningapp_01;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        if (Static.UserName == null) {
            setContentView(R.layout.activity_main);

            ImageButton boyButton = (ImageButton) findViewById(R.id.boyButton);
            ImageButton girlButton = (ImageButton) findViewById(R.id.girlButton);
            Button startButton = (Button) findViewById(R.id.startButton);
            final RelativeLayout layout = (RelativeLayout) findViewById(R.id.characterCreateLayout);

            boyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    layout.setBackgroundResource(R.drawable.boy);
                }
            });

            girlButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    layout.setBackgroundResource(R.drawable.girl);
                }
            });

            startButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Static.UserName = ((EditText) findViewById(R.id.name)).getText().toString();
                    System.out.println(Static.UserName);
                    setContentView(R.layout.main_menu);
                }
            });

        } else {
            setContentView(R.layout.main_menu);
        }
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View decorView = getWindow().getDecorView();
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
