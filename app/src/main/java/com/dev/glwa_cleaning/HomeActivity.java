package com.dev.glwa_cleaning;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout linearLayoutParam  , linearLayoutTache;
    CardView linearLayoutOuvrier;

    TextView userName,userEmail;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        userName = findViewById(R.id.labelName);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        userId = firebaseAuth.getCurrentUser().getUid();


        DocumentReference documentReference = firebaseFirestore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                userName.setText("Bonjour "+ documentSnapshot.getString("name"));

                if (documentSnapshot.getString("type").equals("ouvrier")){
                    linearLayoutOuvrier = findViewById(R.id.layoutOuvrier);
                    linearLayoutOuvrier.setVisibility(View.INVISIBLE);
                }

            }
        });





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
