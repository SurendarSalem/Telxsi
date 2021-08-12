package com.example.dagger2practice.di;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.dagger2practice.R;
import com.example.dagger2practice.mvvm.MyViewModelFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {

    @Inject
    String someString;

    private static final String TAG = "AuthActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        Log.d(TAG, "onCreate: " + someString);
        MyViewModel myViewModel = new ViewModelProvider(this, new MyViewModelFactory(10)).get(MyViewModel.class);
        
    }
}
