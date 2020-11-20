package com.example.messpoll.breakfast;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.messpoll.R;
import com.example.messpoll.sharedPref.SharedPref;

public class Breakfast extends Fragment {

    Button pollButton;

    SharedPref sharedPref;

    TextView responseTextView;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.breakfast , container , false);

        pollButton = view.findViewById(R.id.pollButton);
        sharedPref= new SharedPref(getContext());
        responseTextView = view.findViewById(R.id.responseTextView);
        responseTextView.setVisibility(View.INVISIBLE);

        if(sharedPref.getBreakfastEnabled()==false){

            pollButton.setEnabled(false);

            responseTextView.setVisibility(View.VISIBLE);

        }




        pollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(getContext() , BreakfastPollActivity.class);


                startActivity(intent);

            }
        });







        return view;



    }


}
