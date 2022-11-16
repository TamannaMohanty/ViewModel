package com.tamanna.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //Declaration
    Button button ;
    TextView textView ;
    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);


        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

//        // Getting the initial Count
//        textView.setText("You Clicked Me: "+mainActivityViewModel.getInitialCounter()+ " times");


        //Using live data to get the counter

        LiveData<Integer> count = mainActivityViewModel.getInitialCounter();

count.observe(this, new Observer<Integer>() {
    @Override
    public void onChanged(Integer integer) {

        textView.setText("You Clicked Me: "+integer +" times");
    }
});

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Getting the Current Count

               mainActivityViewModel.getCounter();
//                textView.setText("You Clicked Me: "+mainActivityViewModel.getCounter() +" times");
            }
        });
}}