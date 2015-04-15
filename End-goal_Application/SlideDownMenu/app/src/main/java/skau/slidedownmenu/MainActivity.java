package skau.slidedownmenu;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends ActionBarActivity {


    //Animation
    private AnimationDrawable myAnimation;

    //Google maps text field
    public static final String EXTRA_NAME = "name";

    private EditText textFieldName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //onCreate animation
        ImageView SampleAnimation = (ImageView) findViewById(R.id.AnimationView);
        SampleAnimation.setBackgroundResource(R.drawable.animation);
        myAnimation = (AnimationDrawable)SampleAnimation.getBackground();


        textFieldName = (EditText) findViewById(R.id.textFieldName);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void emilMus(View view){
        if (textFieldName.getText().length() > 0)
        {
            Intent intent = new Intent(this,MapsActivity.class);

            intent.putExtra(EXTRA_NAME, textFieldName.getText().toString());

            startActivity(intent);
        }
    }
    public void animationStart(View view){
        myAnimation.start();
    }
    public void animationStop(View view){
        myAnimation.stop();
    }
    public void animationToggle(View view){
        if(myAnimation.isRunning()){
            Toast.makeText(this,"Stopping the animation",Toast.LENGTH_SHORT).show();
            myAnimation.stop();
            } else{myAnimation.start();
        }
        Toast.makeText(this,"Starting the animation",Toast.LENGTH_SHORT).show();
    };
    public void randomColor(View view){Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        view.setBackgroundColor(color);}
}
