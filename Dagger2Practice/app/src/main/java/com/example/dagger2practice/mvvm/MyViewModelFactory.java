package com.example.dagger2practice.mvvm;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.dagger2practice.di.MyViewModel;

public class MyViewModelFactory implements ViewModelProvider.Factory {

    private final int age;

    public MyViewModelFactory(int age) {
        this.age = age;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MyViewModel.class)) {
            return (T) new MyViewModel(this.age);
        } else {
            throw new IllegalArgumentException("Unknown class");
        }
    }
}
