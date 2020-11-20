package com.example.messpoll.breakfast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.messpoll.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class BreakfastResults extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;

    FirebaseAuth firebaseAuth;

    ArrayList<String> AlooParanthaHaters , PaneerParanthaHaters , GobhiParanthaHaters , PlainParanthaHaters , PuriHaters , TeaHaters , CoffeeHaters;

    ArrayList<String> totalUsers;

    int totalNumberOfUsers , APHaters, PPHaters , GPHaters , PLPHaters , PUHaters , TEHaters, COHaters , pAP , pPP , pGP , pPL , pPU , pTE , pCO;

    TextView textView1 , textView2 , textView3 , textView4 , textView5 , textView6 , textView7;

    Button alooButton , fetchButton, gobhiButton, paneerButton, plainButton , puriButton, teaButton, coffeeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast_results);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        AlooParanthaHaters = new ArrayList<>();
        PaneerParanthaHaters = new ArrayList<>();
        GobhiParanthaHaters = new ArrayList<>();
        PlainParanthaHaters = new ArrayList<>();
        PuriHaters = new ArrayList<>();
        TeaHaters = new ArrayList<>();
        CoffeeHaters = new ArrayList<>();
        totalUsers = new ArrayList<>();
        fetchButton = findViewById(R.id.fetchButton);
        alooButton = findViewById(R.id.alooButton);
        textView1= findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        gobhiButton= findViewById(R.id.gobhiButton);
        paneerButton= findViewById(R.id.paneerButton);
        plainButton= findViewById(R.id.plaimButton);
        puriButton= findViewById(R.id.pooriButton);
        teaButton= findViewById(R.id.teaButton);
        coffeeButton= findViewById(R.id.coffeeButton);
        alooButton.setEnabled(false);
        paneerButton.setEnabled(false);
        gobhiButton.setEnabled(false);
        plainButton.setEnabled(false);
        puriButton.setEnabled(false);
        teaButton.setEnabled(false);
        coffeeButton.setEnabled(false);
        textView1.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
        textView4.setVisibility(View.INVISIBLE);
        textView5.setVisibility(View.INVISIBLE);
        textView6.setVisibility(View.INVISIBLE);
        textView7.setVisibility(View.INVISIBLE);


        //alooParanthaTextView = findViewById(R.id.alooParanthaTextView);

        firebaseDatabase.getReference().child("Users").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String userNameFromDatabase = snapshot.child("UserName").getValue(String.class);

                Log.i("Users", userNameFromDatabase);

                totalUsers.add(userNameFromDatabase);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }


        });

        firebaseDatabase.getReference().child("Breakfast").child("AlooParantha").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String hater = snapshot.child("Hater").getValue(String.class);

                Log.i(" AP HATERS" , hater);

                AlooParanthaHaters.add(hater);


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }

        });

        firebaseDatabase.getReference().child("Breakfast").child("GobhiParantha").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String hater = snapshot.child("Hater").getValue(String.class);

                Log.i(" GP HATERS" , hater);

                GobhiParanthaHaters.add(hater);


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }

        });


        firebaseDatabase.getReference().child("Breakfast").child("PaneerParantha").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String hater = snapshot.child("Hater").getValue(String.class);

                Log.i(" PP HATERS" , hater);

                PaneerParanthaHaters.add(hater);


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }

        });

        firebaseDatabase.getReference().child("Breakfast").child("PlainParantha").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String hater = snapshot.child("Hater").getValue(String.class);

                Log.i("PP HATERS" , hater);

                PlainParanthaHaters.add(hater);


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }

        });

        firebaseDatabase.getReference().child("Breakfast").child("PooriSabji").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String hater = snapshot.child("Hater").getValue(String.class);

                Log.i(" PS HATERS" , hater);

                PuriHaters.add(hater);


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }

        });


        firebaseDatabase.getReference().child("Breakfast").child("Tea").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String hater = snapshot.child("Hater").getValue(String.class);

                Log.i(" TEA HATERS" , hater);

                TeaHaters.add(hater);


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }

        });

        firebaseDatabase.getReference().child("Breakfast").child("Coffee").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String hater = snapshot.child("Hater").getValue(String.class);

                Log.i(" COFFEE HATERS" , hater);

                CoffeeHaters.add(hater);


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }

        });
        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alooButton.setEnabled(true);
                paneerButton.setEnabled(true);
                plainButton.setEnabled(true);
                puriButton.setEnabled(true);
                gobhiButton.setEnabled(true);
                teaButton.setEnabled(true);
                coffeeButton.setEnabled(true);
                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                textView4.setVisibility(View.VISIBLE);
                textView5.setVisibility(View.VISIBLE);
                textView6.setVisibility(View.VISIBLE);
                textView7.setVisibility(View.VISIBLE);

                fetchData();



            }
        });

        alooButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(BreakfastResults.this , AlooList.class);

                startActivity(intent);
            }
        });

        gobhiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BreakfastResults.this , GobhiList.class);

                startActivity(intent);

            }
        });

        paneerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BreakfastResults.this , PaneerList.class);

                startActivity(intent);
            }
        });

        plainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BreakfastResults.this , PlainList.class);

                startActivity(intent);

            }
        });

        puriButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(BreakfastResults.this, PooriList.class);

                startActivity(intent);

            }
        });

        teaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(BreakfastResults.this, TeaList.class);

                startActivity(intent);
            }
        });

        coffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(BreakfastResults.this, CoffeeList.class);

                startActivity(intent);
            }
        });












//        int percentage = (APHaters * 100) / numberOfUsers;

//        Log.i("PERCENTAGE" , Integer.toString(percentage));

//        alooParanthaTextView.setText("" + percentage + " % " + "users hate Aloo Parantha");








    }

    public void fetchData(){

        totalNumberOfUsers= totalUsers.size();

      //  Log.i("USERS", Integer.toString(numberOfUsers));

        APHaters = AlooParanthaHaters.size();
        GPHaters = GobhiParanthaHaters.size();
        PPHaters = PaneerParanthaHaters.size();
        PLPHaters = PlainParanthaHaters.size();
        PUHaters = PuriHaters.size();
        TEHaters = TeaHaters.size();
        COHaters = CoffeeHaters.size();

        //Log.i("AP HATERS", Integer.toString(APHaters));

        pAP= (APHaters * 100 ) / totalNumberOfUsers;

        //Log.i("PERCENTAGE", Float.toString(percentage));

        textView1.setText("" + pAP + "% of users hate Aloo Parantha");

        pGP = (GPHaters * 100) / totalNumberOfUsers;

        textView2.setText("" + pGP + "% of users hate Gobhi Parantha");

        pPP = (PPHaters * 100) / totalNumberOfUsers;

        textView3.setText("" + pPP + "% of users hate Paneer Parantha");

        pPL = (PLPHaters * 100) / totalNumberOfUsers;

        textView4.setText("" + pPL + "% of users hate Plain  Parantha");

        pPU = (PUHaters * 100) / totalNumberOfUsers;

        textView5.setText("" + pPU + "% of users hate Puri Sabji");

        pTE = (TEHaters * 100) / totalNumberOfUsers;

        textView6.setText("" + pTE + "% of users hate Tea");

        pCO = (COHaters * 100) / totalNumberOfUsers;

        textView7.setText("" + pCO + "% of users hate Coffee");





    }







}