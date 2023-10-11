package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.viewmodels.SaldoViewModel;
import com.example.myapplication.viewmodels.HeaderViewModel;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private SaldoViewModel saldoViewModel;
    private HeaderViewModel headerViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Initialize the HeaderViewModel
        headerViewModel = new ViewModelProvider(this).get(HeaderViewModel.class);

        headerViewModel.setHeader("Rifqi");

        // Observe the data from HeaderViewModel
        headerViewModel.getHeader().observe(getViewLifecycleOwner(), newHeader -> {
            TextView balanceValueTextView = binding.headerText;
            balanceValueTextView.setText("Selamat Datang, " + newHeader + "!");
        });

        // Initialize the HeaderViewModel
        saldoViewModel = new ViewModelProvider(this).get(SaldoViewModel.class);

        saldoViewModel.setBalance("10,000,000");

        // Observe the data from HeaderViewModel
        saldoViewModel.getBalance().observe(getViewLifecycleOwner(), newBalance -> {
            TextView balanceValueTextView = binding.balanceValue;
            balanceValueTextView.setText("Rp. " + newBalance);
        });

        // Setup the ImageButton toggle behavior
        final ImageButton toggleButton = binding.toggleButton;
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.saldo_visible).getConstantState()) {
                    toggleButton.setImageResource(R.drawable.saldo_invisible); // Assuming "saldo_hidden" is your stripped close eye drawable.
                    saldoViewModel.setBalance("* * * * * *");
                } else {
                    toggleButton.setImageResource(R.drawable.saldo_visible);
                    saldoViewModel.setBalance("10,000,000");
                }
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}