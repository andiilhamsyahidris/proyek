package com.example.proyek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyek.admin.AdminActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

//    private TextView toRegister;
//    private EditText editTextEmail, editTextPassword;
//    private FirebaseAuth mAuth;
//    private Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mAuth = FirebaseAuth.getInstance();
//
//        editTextEmail = findViewById(R.id.usernameInput);
//        editTextPassword = findViewById(R.id.passwordInput);
//        toRegister = findViewById(R.id.registrationLink);
//        toRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, Register.class));
//            }
//        });
//        signIn = findViewById(R.id.buttonLogin);
//        signIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String email = editTextEmail.getText().toString();
//                String password = editTextPassword.getText().toString();
//
//                if (email.isEmpty()) {
//                    editTextEmail.setError("email is required");
//                    editTextEmail.requestFocus();
//
//                    return;
//                }
//                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//                    editTextEmail.setError("please provide valid email");
//                    return;
//                }
//
//                if (password.isEmpty()) {
//                    editTextPassword.setError("Password is required");
//                    editTextPassword.requestFocus();
//                    return;
//                }
//                if (password.length() < 6) {
//                    editTextPassword.setError("password must be 6 character");
//                    editTextPassword.requestFocus();
//                    return;
//                }
//
//                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//
//                            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
//                            databaseReference.child("Login").addListenerForSingleValueEvent(new ValueEventListener() {
//                                @Override
//                                public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                    if (snapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("as").getValue(String.class).equals("admin")) {
//
//                                        Intent b = new Intent(MainActivity.this, AdminActivity.class);
//                                        b.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                        startActivity(b);
//
//                                    } else if (snapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("as").getValue(String.class).equals("user")) {
//                                        Intent a = new Intent(MainActivity.this, Home.class);
//                                        a.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                        startActivity(a);
//                                    }
//                                }
//
//                                @Override
//                                public void onCancelled(@NonNull DatabaseError error) {
//
//                                }
//                            });
//
//                        } else {
//                            Toast.makeText(MainActivity.this, "failed to login", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
//            }
//        });
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseUser user = mAuth.getCurrentUser();
////        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
//
//        if (user != null){
//            startActivity(new Intent(MainActivity.this, Home.class));
//            finish();
////            databaseReference.child("Login").addListenerForSingleValueEvent(new ValueEventListener() {
////                @Override
////                public void onDataChange(@NonNull DataSnapshot snapshot) {
////                    if (snapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("as").getValue(String.class).equals("admin")){
////                        startActivity(new Intent(MainActivity.this, AdminActivity.class));
////                        finish();
////                    }else {
////
////                    }
////                }
////
////                @Override
////                public void onCancelled(@NonNull DatabaseError error) {
////
////                }
////            });
//
//
//        }
//    }
}