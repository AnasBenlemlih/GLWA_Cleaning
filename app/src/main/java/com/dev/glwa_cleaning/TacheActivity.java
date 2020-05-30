package com.dev.glwa_cleaning;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class TacheActivity extends AppCompatActivity {

    private LinearLayout linearLayoutAddTache;
    private LinearLayout linearLayoutMesTache;
    private LinearLayout linearLayoutAllTache;

    CardView addcard, mescard , allcard;
    String userId;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tache);


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        userId = firebaseAuth.getCurrentUser().getUid();

        addcard =findViewById(R.id.addtachecard);
        mescard = findViewById(R.id.mestachecard);
        allcard = findViewById(R.id.alltachecard);


        DocumentReference documentReference = firebaseFirestore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                if (documentSnapshot.getString("type").equals("ouvrier")){

                    allcard.setVisibility(View.INVISIBLE);
                    addcard.setVisibility(View.INVISIBLE);
                }
                if (documentSnapshot.getString("type").equals("chef")){

                    mescard.setVisibility(View.INVISIBLE);
                    addcard.setVisibility(View.INVISIBLE);

                }
                if (documentSnapshot.getString("type").equals("admin")){

                    mescard.setVisibility(View.INVISIBLE);
                }

            }
        });




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
