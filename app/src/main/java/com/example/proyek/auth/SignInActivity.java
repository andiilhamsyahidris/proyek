package com.example.proyek.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyek.R;
import com.example.proyek.activities.GetStartedActivity;
import com.example.proyek.activities.HomeActivity;
import com.example.proyek.admin.AdminActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignInActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextInputEditText etUsernameOrEmail, etPassword;
    private Button btnSignIn;
    private TextView tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();
        etUsernameOrEmail = findViewById(R.id.etUsernameorEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        tvSignUp = findViewById(R.id.tvSignUp);

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etUsernameOrEmail.getText().toString();
                String password = etPassword.getText().toString();

                if (email.isEmpty()) {
                    etUsernameOrEmail.setError("Mohon masukkan email anda !");
                    etUsernameOrEmail.requestFocus();
                } else if (!isUsernameValid(email)) {
                    etUsernameOrEmail.setError("Mohon masukkan email yang valid !");
                    etUsernameOrEmail.requestFocus();
                } else if (password.isEmpty()) {
                    etPassword.setError("Mohon masukkan password anda !");
                    etPassword.requestFocus();
                } else if (password.length() < 6) {
                    etPassword.setError("Password harus lebih dari 6 karakter !");
                    etPassword.requestFocus();
                } else if (email.isEmpty() && password.isEmpty()) {
                    Toast.makeText(SignInActivity.this, "Please fill the empty space !", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && password.isEmpty())) {
                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
                                databaseReference.child("Login").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        if (snapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("as").getValue(String.class).equals("admin")) {
                                            Intent intent = new Intent(SignInActivity.this, AdminActivity.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(intent);
                                        } else if (snapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("as").getValue(String.class).equals("user")) {
                                            Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(intent);
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            } else {
                                Toast.makeText(SignInActivity.this, "Tolon masukkan email atau password yang terdaftar !", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(SignInActivity.this, "Telah terjadi kesalahan, mohon coba ulang", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseUser user = mAuth.getCurrentUser();
////        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
//
//        if (user != null){
//            startActivity(new Intent(SignInActivity.this, HomeActivity.class));
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
//        }
//    }


    boolean isUsernameValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(SignInActivity.this, GetStartedActivity.class);
        startActivity(intent);
    }
}