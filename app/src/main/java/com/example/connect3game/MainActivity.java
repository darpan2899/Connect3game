package com.example.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activeplayer=0;

    int gamestate[]={2,2,2,2,2,2,2,2,2};

    int winningPostions[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    boolean gameActive=true;

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;

        int tappedcounter = Integer.parseInt(counter.getTag().toString());


        if (gameActive && (gamestate[tappedcounter] == 2)) {
            counter.setTranslationY(-1500);
            gamestate[tappedcounter] = activeplayer;

            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.yellow);

                activeplayer = 1;
            } else {

                counter.setImageResource(R.drawable.red);

                activeplayer = 0;
            }

            counter.animate().translationYBy(1500).setDuration(200);

            for (int wp[] : winningPostions) {
                if (gamestate[wp[0]] == gamestate[wp[1]] && gamestate[wp[1]] == gamestate[wp[2]] && gamestate[wp[0]] != 2) {
                    gameActive = false;
                    Toast.makeText(this, "someone has won", Toast.LENGTH_SHORT).show();
                    Button playAgain = (Button) findViewById(R.id.playAgain);
                    playAgain.setVisibility(View.VISIBLE);

                }
            }

            if(gamestate[0] != 2 && gamestate[1] != 2 && gamestate[2] != 2 && gamestate[3] != 2 && gamestate[4] != 2 && gamestate[5] != 2 && gamestate[6] != 2 && gamestate[7] != 2 && gamestate[8] != 2 )
            {
                gameActive = false;
                Toast.makeText(this, "no one has won", Toast.LENGTH_SHORT).show();
                Button playAgain = (Button) findViewById(R.id.playAgain);
                playAgain.setVisibility(View.VISIBLE);
            }

        }
    }


        public void playAg(View view)
        {
            Log.i("msg","1");
            Button playAgain = (Button) findViewById(R.id.playAgain);
            playAgain.setVisibility(View.INVISIBLE);
            androidx.gridlayout.widget.GridLayout gt = (androidx.gridlayout.widget.GridLayout) findViewById(R.id.gridLayout);

            Log.i("msg","2");

            for(int i=0; i<gt.getChildCount(); i++)
            {
                Log.i("msg","3");
                ImageView counter =((ImageView)gt.getChildAt(i));
                counter.setImageResource(0);
            }
            for(int i=0; i<gamestate.length; i++)
            {
                Log.i("msg","4");
                gamestate[i]=2;
            }
            activeplayer=0;
            gameActive=true;
        }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
