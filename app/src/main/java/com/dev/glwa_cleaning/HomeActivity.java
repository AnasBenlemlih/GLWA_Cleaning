package com.dev.glwa_cleaning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout linearLayoutParam;
    private LinearLayout linearLayoutTache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        linearLayoutParam = findViewById(R.id.parametre);
        linearLayoutParam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses buttonHo
                openParametre();
            }
        });

        linearLayoutTache = findViewById(R.id.tache);
        linearLayoutTache.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses buttonHo
                openTache();
            }
        });
    }

    public void openParametre(){
        Intent intent = new Intent(this,ParamActivity.class);
        startActivity(intent);
    }
    public void openTache(){
        Intent intent = new Intent(this,TacheActivity.class);
        startActivity(intent);
    }
}
