package com.dev.glwa_cleaning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
   private Button button;


   EditText mEmail, mPassword;
   FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.Password);

        firebaseAuth = FirebaseAuth.getInstance();

        button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses buttonHo
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString();

                if (TextUtils.isEmpty(email)){
                    mEmail.setError("Email Non Valide !");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    mPassword.setError("password Non Valide !");
                    return;
                }
                if (password.length()<6){
                    mPassword.setError("password must be > 6 Characters" );
                    return;
                }

                // authontification

                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        }
                        else {

                            Toast.makeText(LoginActivity.this, "Error !" +task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }
    public void openHome(){
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }


}
