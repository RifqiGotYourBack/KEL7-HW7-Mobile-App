package com.example.myapplication.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SaldoViewModel extends ViewModel {

    private final MutableLiveData<String> balance = new MutableLiveData<>();

    public MutableLiveData<String> getBalance() {
        return balance;
    }

    public void setBalance(String value) {
        balance.setValue(value);
    }
}
