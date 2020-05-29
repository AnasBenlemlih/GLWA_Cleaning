package com.dev.glwa_cleaning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class TacheActivity extends AppCompatActivity {

    private LinearLayout linearLayoutAddTache;
    private LinearLayout linearLayoutMesTache;
    private LinearLayout linearLayoutAllTache;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tache);

        linearLayoutAddTache = findViewById(R.id.addtache);
        linearLayoutAddTache.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses buttonHo
                openAddTache();
            }
        });

        linearLayoutMesTache = findViewById(R.id.mestache);
        linearLayoutMesTache.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses buttonHo
                openMesTache();
            }
        });
        linearLayoutMesTache = findViewById(R.id.alltache);
        linearLayoutMesTache.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses buttonHo
                openAllTache();
            }
        });


    }

    public void openAddTache(){
        Intent intent = new Intent(this,AddTacheeActivity.class);
        startActivity(intent);
    }
    public void openMesTache(){
        Intent intent = new Intent(this,MesTacheActivity.class);
        startActivity(intent);
    }
    public void openAllTache(){
        Intent intent = new Intent(this,AllTachActivity.class);
        startActivity(intent);
    }

}
