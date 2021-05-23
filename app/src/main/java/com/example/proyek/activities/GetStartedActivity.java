package com.example.proyek.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.proyek.R;
import com.google.android.material.button.MaterialButton;

public class GetStartedActivity extends AppCompatActivity implements View.OnClickListener {
//    private Button btnSignIn;
//    private TextView tvSignUp;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_get_started);
//
//        btnSignIn = findViewById(R.id.btnSignIn);
//        tvSignUp = findViewById(R.id.tvSignUp);
//
//        btnSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(GetStartedActivity.this, SignInActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        tvSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(GetStartedActivity.this, SignUpActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//    }
//
//    @Override
//    public void onBackPressed(){
//        moveTaskToBack(true);
//    }

    // kode ini digunakan hanya sekedar untuk mendemo-kan dialog box
    // beri comment jika tidak digunakan
    private Dialog dialogBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        dialogBox = new Dialog(GetStartedActivity.this);

        dialogBox.setContentView(R.layout.dialog_box_reset_cart);
        dialogBox.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogBox.setCancelable(false);
        dialogBox.getWindow().getAttributes().windowAnimations = R.style.DialogBoxAnimation;

        MaterialButton btnConfirm = dialogBox.findViewById(R.id.btnResetCartTrue);
        btnConfirm.setOnClickListener(this);

        MaterialButton btnCancel = dialogBox.findViewById(R.id.btnResetCartFalse);
        btnCancel.setOnClickListener(this);

        MaterialButton btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btnResetCartTrue) {
            Toast.makeText(this, "Do something here!", Toast.LENGTH_SHORT).show();
            dialogBox.dismiss();
        } else if (id == R.id.btnResetCartFalse) {
            dialogBox.dismiss();
        } else if (id == R.id.btnSignIn) {
            dialogBox.show();
        }
    }
}