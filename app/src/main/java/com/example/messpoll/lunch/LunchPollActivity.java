package com.example.messpoll.lunch;

import androidx.annotation.NonNull;
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
import com.example.messpoll.breakfast.BreakfastPollActivity;
import com.example.messpoll.sharedPref.SharedPref;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LunchPollActivity extends AppCompatActivity {

    CheckBox alooMatar , chanaDalFry , arharDal , uradDal , alooNutrella , maaDaal , chhole , boondiRaita , dalMakhani , dumAloo , mixedDalFry , rajmah , chholeBathure, plainRice;

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
        setContentView(R.layout.activity_lunch_poll);

        alooMatar = findViewById(R.id.alooMatar);
        chanaDalFry = findViewById(R.id.chanaDalFry);
        arharDal = findViewById(R.id.arharDal);
         uradDal= findViewById(R.id.uradDal);
        alooNutrella = findViewById(R.id.alooNutrella);
        maaDaal = findViewById(R.id.maaDaal);
        chhole = findViewById(R.id.chhole);
        boondiRaita = findViewById(R.id.boondiRaita);
        dalMakhani = findViewById(R.id.dalMakhani);
        dumAloo = findViewById(R.id.dumAloo);
        mixedDalFry = findViewById(R.id.mixedDalFry);
        rajmah = findViewById(R.id.rajma);
        chholeBathure = findViewById(R.id.choleBathure);
        plainRice = findViewById(R.id.plainRice);
        submitButton = findViewById(R.id.submitButton);
        selectedChoices = new ArrayList<>();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth= FirebaseAuth.getInstance();
        userID =  firebaseAuth.getCurrentUser().getUid();
        sharedPref = new SharedPref(LunchPollActivity.this);


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

                if(sharedPref.getLunchEnabled() ) {

                    AlooMatar();
                    chanaDalFry();
                    arharDal();
                    uradDal();
                    alooNutrella();
                    maaDaal();
                    Chhole();
                    boondiRaita();
                    DalMakhani();
                    DumAloo();
                    mixedDalFry();
                    Rajma();
                    CholeBathure();
                    PlainRice();





                    Toast.makeText(LunchPollActivity.this, "Responses successfully saved ! Please do the same for breakfast and dinner", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(LunchPollActivity.this, MainActivity.class);

                    startActivity(intent);

                    sharedPref.setLunchEnabled(false);


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

    public void AlooMatar(){

        if(alooMatar.isChecked()){


            Map<String , Object> alooMatarHaters = new HashMap<>();

            alooMatarHaters.put("Hater" , usernameFromDatabase);



            firebaseDatabase.getReference().child("Lunch").child("AlooMatar").child(userID).updateChildren(alooMatarHaters);

        }

    }



    public  void chanaDalFry(){


        if(chanaDalFry.isChecked()){

            Map<String , Object> chanaDalFryHaters = new HashMap<>();

            chanaDalFryHaters.put("Hater" , usernameFromDatabase);

            firebaseDatabase.getReference().child("Lunch").child("chanaDalFry").child(userID).updateChildren(chanaDalFryHaters);
        }



    }

    public void arharDal(){

        if(arharDal.isChecked()){


            Map<String , Object> arharDalHaters = new HashMap<>();

            arharDalHaters.put("Hater" , usernameFromDatabase);



            firebaseDatabase.getReference().child("Lunch").child("arharDal").child(userID).updateChildren(arharDalHaters);

        }

    }

    public void uradDal(){

        if(uradDal.isChecked()){


            Map<String , Object> uradDalHaters = new HashMap<>();

            uradDalHaters.put("Hater" , usernameFromDatabase);



            firebaseDatabase.getReference().child("Lunch").child("uradDal").child(userID).updateChildren(uradDalHaters);

        }}

    public void alooNutrella(){

        if(alooNutrella.isChecked()){


            Map<String , Object> alooNutrellaHaters = new HashMap<>();

            alooNutrellaHaters.put("Hater" , usernameFromDatabase);



            firebaseDatabase.getReference().child("Lunch").child("alooNutrella").child(userID).updateChildren(alooNutrellaHaters);

        }

    }

    public void maaDaal(){

        if(maaDaal.isChecked()){


            Map<String , Object> maaDaalHaters = new HashMap<>();

            maaDaalHaters.put("Hater" , usernameFromDatabase);



            firebaseDatabase.getReference().child("Lunch").child("maaDaal").child(userID).updateChildren(maaDaalHaters);

        }

    }

    public void Chhole(){

        if(chhole.isChecked()){


            Map<String , Object> choleHaters = new HashMap<>();

            choleHaters.put("Hater" , usernameFromDatabase);



            firebaseDatabase.getReference().child("Lunch").child("Chole").child(userID).updateChildren(choleHaters);

        }

    }

    public void boondiRaita(){

        if(boondiRaita.isChecked()){


            Map<String , Object> boondiRaitaHaters = new HashMap<>();

            boondiRaitaHaters.put("Hater" , usernameFromDatabase);



            firebaseDatabase.getReference().child("Lunch").child("BoondiRaita").child(userID).updateChildren(boondiRaitaHaters);

        }

    }


    public void DalMakhani(){

        if(dalMakhani.isChecked()){


            Map<String , Object> dalMakhaniHaters = new HashMap<>();

            dalMakhaniHaters.put("Hater" , usernameFromDatabase);



            firebaseDatabase.getReference().child("Lunch").child("DalMakhani").child(userID).updateChildren(dalMakhaniHaters);

        }

    }

    public void DumAloo(){

        if(dumAloo.isChecked()){


            Map<String , Object> dumAlooHaters = new HashMap<>();

            dumAlooHaters.put("Hater" , usernameFromDatabase);



            firebaseDatabase.getReference().child("Lunch").child("DumAloo").child(userID).updateChildren(dumAlooHaters);

        }

    }

    public void mixedDalFry(){

        if(mixedDalFry.isChecked()){


            Map<String , Object> mixedDalFryHaters = new HashMap<>();

            mixedDalFryHaters.put("Hater" , usernameFromDatabase);



            firebaseDatabase.getReference().child("Lunch").child("MixedDalFry").child(userID).updateChildren(mixedDalFryHaters);

        }

    }

    public void Rajma(){

        if(rajmah.isChecked()){


            Map<String , Object> rajmaHaters = new HashMap<>();

            rajmaHaters.put("Hater" , usernameFromDatabase);



            firebaseDatabase.getReference().child("Lunch").child("Rajma").child(userID).updateChildren(rajmaHaters);

        }

    }

    public void CholeBathure(){

        if(chholeBathure.isChecked()){


            Map<String , Object> choleBathureHaters = new HashMap<>();

            choleBathureHaters.put("Hater" , usernameFromDatabase);



            firebaseDatabase.getReference().child("Lunch").child("CholeBathure").child(userID).updateChildren(choleBathureHaters);

        }

    }

    public void PlainRice(){

        if(plainRice.isChecked()){


            Map<String , Object> plainRiceHaters = new HashMap<>();

            plainRiceHaters.put("Hater" , usernameFromDatabase);



            firebaseDatabase.getReference().child("Lunch").child("PlainRice").child(userID).updateChildren(plainRiceHaters);

        }

    }



}
