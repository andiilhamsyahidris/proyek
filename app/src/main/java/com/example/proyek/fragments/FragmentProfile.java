package com.example.proyek.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.proyek.auth.SignInActivity;
import com.example.proyek.R;
import com.example.proyek.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class FragmentProfile extends Fragment {

    private View view;
    private Toolbar tbProfile;
    private CircleImageView civProfileImg;

//    private Button btnOut;
//    private FirebaseUser user;
//    private DatabaseReference reference;
//    private String userID;
//    private FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);

//        user = FirebaseAuth.getInstance().getCurrentUser();
//        reference = FirebaseDatabase.getInstance().getReference("User");
//        userID = user.getUid();
//        mAuth = FirebaseAuth.getInstance();
//
//        final TextView textViewName = view.findViewById(R.id.tvName);
//        final TextView textViewEmail = view.findViewById(R.id.tvEmail);
//
//        btnOut = view.findViewById(R.id.btnOut);
//        btnOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mAuth.signOut();
//                Intent a = new Intent(getActivity(), SignInActivity.class);
//                a.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(a);
//                getActivity().finish();
//            }
//        });
//
//        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                User userProfile = snapshot.getValue(User.class);
//                if (userProfile != null){
//                    String username = userProfile.username;
//                    String email = userProfile.email;
//
//                    textViewEmail.setText(email);
//                    textViewName.setText(username);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//                Toast.makeText(getActivity(), "something wrong", Toast.LENGTH_LONG).show();
//            }
//        });

        return view;
    }
}
