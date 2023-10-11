package com.example.myapplication.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HeaderViewModel extends ViewModel{

    private final MutableLiveData<String> balance = new MutableLiveData<>();

    public MutableLiveData<String> getHeader() {
        return balance;
    }

    public void setHeader(String value) {
            balance.setValue(value);
        }

}
