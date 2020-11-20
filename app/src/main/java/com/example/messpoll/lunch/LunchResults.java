package com.example.messpoll.lunch;

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

public class LunchResults extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;

    FirebaseAuth firebaseAuth;

    ArrayList<String> AlooMatarHaters , ChanaDalFryHaters , ArharDalHaters , UradDalHaters , AlooNutrellaHaters , MaaDaalHaters , ChholeHaters , BundiRaitaHaters , DalMakhaniHaters ,   DumAlooHaters , MixedDalFryHaters , RajmaHaters , CholeBathureHaters , PlainRiceHaters;

    ArrayList<String> totalUsers;

    int totalNumberOfUsers , AMHaters, CDFHaters , ADHaters , UDHaters , ANHaters , MDHaters, CHaters , BRHaters ,  DMHaters , DAHaters , MDFHaters , RHaters , CBHaters , PRHaters , pAM , pCDF , pAD , pUD, pAN , pMD , pC , pBR , pDM , pDA , pMDF , pR , pCB , pPR;

    TextView textView1 , textView2 , textView3 , textView4 , textView5 , textView6 , textView7 , textView8 , textView9, textView10, textView11, textView12, textView13, textView14;

    Button alooMatarButton , chanaDalFryButton , arharDalButton , uradDalButton , alooNutrellaButton , maaDaalButton , chholeButton , bundiRaitaButton , dalMakhaniButton , dumAlooButton , mixedDalFryButton , rajmaButton , choleBathureButton , plainRiceButton , fetchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_results);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        fetchButton = findViewById(R.id.fetchButton);
        alooMatarButton = findViewById(R.id.alooMatarButton);
        chanaDalFryButton = findViewById(R.id.chanaDalFryButton);
        arharDalButton = findViewById(R.id.arharDalButton);
        uradDalButton = findViewById(R.id.uradDalButton);
        alooNutrellaButton = findViewById(R.id.alooNutrellaButton);
        maaDaalButton = findViewById(R.id.maaDaalButton);
        chholeButton = findViewById(R.id.chholeButton);
        bundiRaitaButton = findViewById(R.id.boondiRaitaButton);
        dalMakhaniButton = findViewById(R.id.dalMakhaniButton);
        dumAlooButton = findViewById(R.id.dumAlooButton);
        mixedDalFryButton = findViewById(R.id.mixedDalFryutton);
        rajmaButton = findViewById(R.id.rajmaButton);
        choleBathureButton = findViewById(R.id.chholeBathureButton);
        plainRiceButton = findViewById(R.id.plainRiceButton);
        AlooMatarHaters = new ArrayList<>();
        ChanaDalFryHaters = new ArrayList<>();
        ArharDalHaters = new ArrayList<>();
        UradDalHaters = new ArrayList<>();
        AlooNutrellaHaters = new ArrayList<>();
        MaaDaalHaters = new ArrayList<>();
        ChholeHaters = new ArrayList<>();
        BundiRaitaHaters = new ArrayList<>();
        DalMakhaniHaters = new ArrayList<>();
        DumAlooHaters = new ArrayList<>();
        MixedDalFryHaters = new ArrayList<>();
        RajmaHaters = new ArrayList<>();
        CholeBathureHaters = new ArrayList<>();
        PlainRiceHaters = new ArrayList<>();
        totalUsers = new ArrayList<>();
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        textView11 = findViewById(R.id.textView11);
        textView12 = findViewById(R.id.textView12);
        textView13 = findViewById(R.id.textView13);
        textView14 = findViewById(R.id.textView14);
        alooMatarButton.setEnabled(false);
        chanaDalFryButton.setEnabled(false);
        arharDalButton.setEnabled(false);
        uradDalButton.setEnabled(false);
        alooNutrellaButton.setEnabled(false);
        maaDaalButton.setEnabled(false);
        chholeButton.setEnabled(false);
        bundiRaitaButton.setEnabled(false);
        dalMakhaniButton.setEnabled(false);
        dumAlooButton.setEnabled(false);
        mixedDalFryButton.setEnabled(false);
        rajmaButton.setEnabled(false);
        choleBathureButton.setEnabled(false);
        plainRiceButton.setEnabled(false);
        textView1.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
        textView4.setVisibility(View.INVISIBLE);
        textView5.setVisibility(View.INVISIBLE);
        textView6.setVisibility(View.INVISIBLE);
        textView7.setVisibility(View.INVISIBLE);
        textView8.setVisibility(View.INVISIBLE);
        textView9.setVisibility(View.INVISIBLE);
        textView10.setVisibility(View.INVISIBLE);
        textView11.setVisibility(View.INVISIBLE);
        textView12.setVisibility(View.INVISIBLE);
        textView13.setVisibility(View.INVISIBLE);
        textView14.setVisibility(View.INVISIBLE);

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

        firebaseDatabase.getReference().child("Lunch").child("AlooMatar").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String hater = snapshot.child("Hater").getValue(String.class);

                Log.i(" AM HATERS" , hater);

                AlooMatarHaters.add(hater);


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

        firebaseDatabase.getReference().child("Lunch").child("BoondiRaita").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String hater = snapshot.child("Hater").getValue(String.class);

                Log.i(" BR HATERS" , hater);

                BundiRaitaHaters.add(hater);


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

        firebaseDatabase.getReference().child("Lunch").child("Chole").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String hater = snapshot.child("Hater").getValue(String.class);

                Log.i(" C HATERS" , hater);

                ChholeHaters.add(hater);


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

        firebaseDatabase.getReference().child("Lunch").child("CholeBathure").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String hater = snapshot.child("Hater").getValue(String.class);

                Log.i(" CB HATERS" , hater);

                CholeBathureHaters.add(hater);


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

        firebaseDatabase.getReference().child("Lunch").child("DalMakhani").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String hater = snapshot.child("Hater").getValue(String.class);

                Log.i(" DM HATERS" , hater);

                DalMakhaniHaters.add(hater);


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

        firebaseDatabase.getReference().child("Lunch").child("DumAloo").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String hater = snapshot.child("Hater").getValue(String.class);

                Log.i(" DA HATERS" , hater);

                DumAlooHaters.add(hater);


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

        firebaseDatabase.getReference().child("Lunch").child("MixedDalFry").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String hater = snapshot.child("Hater").getValue(String.class);

                Log.i(" MDF HATERS" , hater);

                MixedDalFryHaters.add(hater);


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

        firebaseDatabase.getReference().child("Lunch").child("PlainRice").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String hater = snapshot.child("Hater").getValue(String.class);

                Log.i(" PR HATERS" , hater);

                PlainRiceHaters.add(hater);


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

        firebaseDatabase.getReference().child("Lunch").child("Rajma").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String hater = snapshot.child("Hater").getValue(String.class);

                Log.i(" R HATERS" , hater);

                RajmaHaters.add(hater);


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

        firebaseDatabase.getReference().child("Lunch").child("alooNutrella").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String hater = snapshot.child("Hater").getValue(String.class);

                Log.i(" AN HATERS" , hater);

                AlooNutrellaHaters.add(hater);


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

        firebaseDatabase.getReference().child("Lunch").child("arharDal").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String hater = snapshot.child("Hater").getValue(String.class);

                Log.i(" AD HATERS" , hater);

                ArharDalHaters.add(hater);


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

        firebaseDatabase.getReference().child("Lunch").child("chanaDalFry").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String hater = snapshot.child("Hater").getValue(String.class);

                Log.i(" CDF HATERS" , hater);

                ChanaDalFryHaters.add(hater);


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

        firebaseDatabase.getReference().child("Lunch").child("maaDaal").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String hater = snapshot.child("Hater").getValue(String.class);

                Log.i(" MD HATERS" , hater);

                MaaDaalHaters.add(hater);


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

        firebaseDatabase.getReference().child("Lunch").child("uradDal").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                String hater = snapshot.child("Hater").getValue(String.class);

                Log.i(" UD HATERS" , hater);

                UradDalHaters.add(hater);


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

                alooMatarButton.setEnabled(true);
                bundiRaitaButton.setEnabled(true);
                chholeButton.setEnabled(true);
                choleBathureButton.setEnabled(true);
                dalMakhaniButton.setEnabled(true);
                dumAlooButton.setEnabled(true);
                mixedDalFryButton.setEnabled(true);
                plainRiceButton.setEnabled(true);
                rajmaButton.setEnabled(true);
                alooNutrellaButton.setEnabled(true);
                arharDalButton.setEnabled(true);
                chanaDalFryButton.setEnabled(true);
                maaDaalButton.setEnabled(true);
                uradDalButton.setEnabled(true);
                textView1.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                textView4.setVisibility(View.VISIBLE);
                textView5.setVisibility(View.VISIBLE);
                textView6.setVisibility(View.VISIBLE);
                textView7.setVisibility(View.VISIBLE);
                textView8.setVisibility(View.VISIBLE);
                textView9.setVisibility(View.VISIBLE);
                textView10.setVisibility(View.VISIBLE);
                textView11.setVisibility(View.VISIBLE);
                textView12.setVisibility(View.VISIBLE);
                textView13.setVisibility(View.VISIBLE);
                textView14.setVisibility(View.VISIBLE);

                fetchData();



            }
        });

        bundiRaitaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LunchResults.this , BoondiRaitaList.class);

                startActivity(intent);
            }
        });

        alooMatarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LunchResults.this , AlooMatarList.class);

                startActivity(intent);
            }
        });

        chholeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LunchResults.this , CholeList.class);

                startActivity(intent);
            }
        });

        choleBathureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LunchResults.this , CholeBathureList.class);

                startActivity(intent);
            }
        });

        dalMakhaniButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LunchResults.this , DalMakhaniList.class);

                startActivity(intent);
            }
        });

        dumAlooButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LunchResults.this , DumAlooList.class);

                startActivity(intent);
            }
        });

        mixedDalFryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LunchResults.this , MixedDalFryList.class);

                startActivity(intent);
            }
        });

        plainRiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LunchResults.this , PlainRiceList.class);

                startActivity(intent);
            }
        });

        rajmaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LunchResults.this , RajmaList.class);

                startActivity(intent);
            }
        });

        alooNutrellaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LunchResults.this , AlooNutrellaList.class);

                startActivity(intent);
            }
        });

        arharDalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LunchResults.this , ArharDalList.class);

                startActivity(intent);
            }
        });

        chanaDalFryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LunchResults.this , ChanaDalFryList.class);

                startActivity(intent);
            }
        });

        maaDaalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LunchResults.this , MaaDaalList.class);

                startActivity(intent);
            }
        });

        uradDalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LunchResults.this , UradDalList.class);

                startActivity(intent);
            }
        });



        }

    public void fetchData(){

        totalNumberOfUsers= totalUsers.size();

        //  Log.i("USERS", Integer.toString(numberOfUsers));

        AMHaters = AlooMatarHaters.size();
        CDFHaters = ChanaDalFryHaters.size();
        ADHaters = ArharDalHaters.size();
        UDHaters = UradDalHaters.size();
        ANHaters = AlooNutrellaHaters.size();
        MDHaters = MaaDaalHaters.size();
        CHaters = ChholeHaters.size();
        BRHaters= BundiRaitaHaters.size();
        DMHaters= DalMakhaniHaters.size();
        DAHaters= DumAlooHaters.size();
        MDFHaters= MixedDalFryHaters.size();
        RHaters= RajmaHaters.size();
        CBHaters= CholeBathureHaters.size();
        PRHaters= PlainRiceHaters.size();

        //Log.i("AP HATERS", Integer.toString(APHaters));

        pAM= (AMHaters * 100 ) / totalNumberOfUsers;

        //Log.i("PERCENTAGE", Float.toString(percentage));

        textView1.setText("" + pAM + "% of users hate Aloo Matar");

        pCDF = (CDFHaters * 100) / totalNumberOfUsers;

        textView2.setText("" + pCDF + "% of users hate Chana Dal Fry");

        pAD = (ADHaters * 100) / totalNumberOfUsers;

        textView3.setText("" + pAD + "% of users hate Arhar Dal");

        pUD = (UDHaters * 100) / totalNumberOfUsers;

        textView4.setText("" + pUD + "% of users hate Urad Dal");

        pAN = (ANHaters * 100) / totalNumberOfUsers;

        textView5.setText("" + pAN + "% of users hate Aloo Nutrella");

        pMD = (MDHaters * 100) / totalNumberOfUsers;

        textView6.setText("" + pMD + "% of users hate Maa Dal");

        pC = (CHaters * 100) / totalNumberOfUsers;

        textView7.setText("" + pC + "% of users hate Chhole");

        pBR = (BRHaters * 100) / totalNumberOfUsers;

        textView8.setText("" + pBR + "% of users hate Bundi Raita");

        pDM = (DMHaters * 100) / totalNumberOfUsers;

        textView9.setText("" + pC + "% of users hate Dal Makhani");

        pDA = (DAHaters * 100) / totalNumberOfUsers;

        textView10.setText("" + pDA + "% of users Dum Aloo");

        pMDF = (MDFHaters * 100) / totalNumberOfUsers;

        textView11.setText("" + pMDF + "% of users hate Mixed Dal Fry");

        pR = (RHaters * 100) / totalNumberOfUsers;

        textView12.setText("" + pR + "% of users hate Rajma");

        pCB = (CBHaters * 100) / totalNumberOfUsers;

        textView13.setText("" + pCB + "% of users hate Chhola Bathura");

        pPR = (PRHaters * 100) / totalNumberOfUsers;

        textView14.setText("" + pPR + "% of users hate Plain Rice");









    }
}