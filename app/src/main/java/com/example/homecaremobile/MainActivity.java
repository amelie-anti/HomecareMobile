package com.example.homecaremobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "tag test" ;
    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    //autentification
    private FirebaseAuth mAuth;

    public static final int REQUEST_CODE = 2000;
    Button button_connecte;
    Button button_inscrition;
    EditText email;
    EditText mdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();


        button_connecte = (Button) findViewById(R.id.buttonConnecter);
        button_inscrition = (Button) findViewById(R.id.buttonInscription);
        email = (EditText) findViewById(R.id.email);
        mdp = (EditText) findViewById(R.id.MDP);

        //myRef.setValue("Hello, toi!");

        button_connecte.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                signIn(email.getText().toString(), mdp.getText().toString());

            }
        });

        button_inscrition.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setMessage();
            }
        });
        onStart();

//        createAccount("cooucouocub@free.fr","vfddhfbdhf2bhd");

    }

    public void setMessage() {
        String str = email.getText().toString().trim();
        myRef.setValue(str);
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
//    }

    private void updateUI(FirebaseUser currentUser) {
        if (currentUser != null){
            Log.d("Userrr", currentUser.toString());
            final Intent acceuilProprietaire = new Intent(MainActivity.this, MainProprietaireActivity.class);
            startActivityForResult(acceuilProprietaire, REQUEST_CODE);
        }else {

        }
    }

    public void createAccount(String email, String mdp){
        mAuth.createUserWithEmailAndPassword(email, mdp)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    public void signIn(String email, String mdp){
        mAuth.signInWithEmailAndPassword(email, mdp)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

}
