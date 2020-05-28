package com.dev.glwa_cleaning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class ParamActivity extends AppCompatActivity {
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_param);

        linearLayout = findViewById(R.id.editPass);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses buttonHo
                openEditPassword();
            }
        });
    }
    public void openEditPassword(){
        Intent intent = new Intent(this,EditPasswordActivity.class);
        startActivity(intent);
    }

}
