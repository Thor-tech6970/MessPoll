package com.example.messpoll.breakfast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.messpoll.MainActivity;
import com.example.messpoll.R;
import com.example.messpoll.sharedPref.SharedPref;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BreakfastPollActivity extends AppCompatActivity {

    CheckBox alooParantha , paneerParantha , gobhiParantha , plainParantha , puriSabji, tea , coffee;

    Button submitButton;

    ArrayList<String> selectedChoices;

    FirebaseDatabase firebaseDatabase;

    FirebaseAuth firebaseAuth;

    String userID;

    String usernameFromDatabase;

    SharedPref sharedPref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast_poll);

        alooParantha = findViewById(R.id.alooParantha);
        gobhiParantha = findViewById(R.id.GobhiParantha);
        paneerParantha = findViewById(R.id.paneerParantha);
        plainParantha = findViewById(R.id.plainParantha);
        puriSabji = findViewById(R.id.puriSabji);
        tea = findViewById(R.id.tea);
        coffee = findViewById(R.id.coffee);
        submitButton = findViewById(R.id.submitButton);
        selectedChoices = new ArrayList<>();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth= FirebaseAuth.getInstance();
        userID =  firebaseAuth.getCurrentUser().getUid();
        sharedPref = new SharedPref(BreakfastPollActivity.this);








        firebaseDatabase.getReference().child("Users").child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                usernameFromDatabase = snapshot.child("UserName").getValue(String.class);

                Log.i("USERNAME" , usernameFromDatabase);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(sharedPref.getBreakfastEnabled()) {


                    AlooParantha();

                    PaneerParantha();

                    GobhiParantha();

                    PlainParantha();

                    Puri();

                    Tea();

                    Coffee();

                   // submitButton.setEnabled(false);



                    Toast.makeText(BreakfastPollActivity.this, "Responses successfully saved ! Please do the same for lunch and dinner", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(BreakfastPollActivity.this, MainActivity.class);

                    startActivity(intent);

                    sharedPref.setBreakfastEnabled(false);


                }

//                else {
//
//                   // submitButton.setEnabled(false);
//
//
//
//                   Toast.makeText(BreakfastPollActivity.this , "You have already responded before. These responses will not be saved." , Toast.LENGTH_SHORT).show();
//
//                    Intent intent = new Intent(BreakfastPollActivity.this, MainActivity.class);
//
//                    startActivity(intent);
//
//
//
//                }










            }
        });

    }

    public void AlooParantha(){

        if(alooParantha.isChecked()){


            Map<String , Object> alooParanthaHaters = new HashMap<>();

            alooParanthaHaters.put("Hater" , usernameFromDatabase);



            firebaseDatabase.getReference().child("Breakfast").child("AlooParantha").child(userID).updateChildren(alooParanthaHaters);

        }

    }

     public  void PaneerParantha(){


        if(paneerParantha.isChecked()){

            Map<String , Object> paneerParanthaHaters = new HashMap<>();

            paneerParanthaHaters.put("Hater" , usernameFromDatabase);

            firebaseDatabase.getReference().child("Breakfast").child("PaneerParantha").child(userID).updateChildren(paneerParanthaHaters);
        }



     }

    public void GobhiParantha(){

        if(gobhiParantha.isChecked()){


            Map<String , Object> gobhiParanthaHaters = new HashMap<>();

            gobhiParanthaHaters.put("Hater" , usernameFromDatabase);



            firebaseDatabase.getReference().child("Breakfast").child("GobhiParantha").child(userID).updateChildren(gobhiParanthaHaters);

        }

    }

    public void PlainParantha(){

        if(plainParantha.isChecked()){


            Map<String , Object> plainParanthaHaters = new HashMap<>();

            plainParanthaHaters.put("Hater" , usernameFromDatabase);



            firebaseDatabase.getReference().child("Breakfast").child("PlainParantha").child(userID).updateChildren(plainParanthaHaters);

        }}

        public void Puri(){

            if(puriSabji.isChecked()){


                Map<String , Object> puriHaters = new HashMap<>();

                puriHaters.put("Hater" , usernameFromDatabase);



                firebaseDatabase.getReference().child("Breakfast").child("PooriSabji").child(userID).updateChildren(puriHaters);

            }

        }

    public void Tea(){

        if(tea.isChecked()){


            Map<String , Object> teaHaters = new HashMap<>();

            teaHaters.put("Hater" , usernameFromDatabase);



            firebaseDatabase.getReference().child("Breakfast").child("Tea").child(userID).updateChildren(teaHaters);

        }

    }

    public void Coffee(){

        if(coffee.isChecked()){


            Map<String , Object> coffeeHaters = new HashMap<>();

            coffeeHaters.put("Hater" , usernameFromDatabase);



            firebaseDatabase.getReference().child("Breakfast").child("Coffee").child(userID).updateChildren(coffeeHaters);

        }

    }



}




