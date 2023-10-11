package com.example.myapplication.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class DashboardFragment extends Fragment {

    private TextView tvName, tvDOB, tvPhone, tvEmail;
    private EditText etName, etDOB, etPhone, etEmail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        tvName = view.findViewById(R.id.tvName);
        tvDOB = view.findViewById(R.id.tvDOB);
        tvPhone = view.findViewById(R.id.tvPhone);
        tvEmail = view.findViewById(R.id.tvEmail);

        etName = view.findViewById(R.id.etName);
        etDOB = view.findViewById(R.id.etDOB);
        etPhone = view.findViewById(R.id.etPhone);
        etEmail = view.findViewById(R.id.etEmail);

        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToEditText(tvName, etName);
            }
        });

        tvDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToEditText(tvDOB, etDOB);
            }
        });

        tvPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToEditText(tvPhone, etPhone);
            }
        });

        tvEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToEditText(tvEmail, etEmail);
            }
        });

        // Inside onCreateView()

        Button btnSaveChanges = view.findViewById(R.id.btnSaveChanges);
        btnSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalizeEditing();
            }
        });

        return view;
    }
    private void finalizeEditing() {
        switchToTextView(etName, tvName);
        switchToTextView(etDOB, tvDOB);
        switchToTextView(etPhone, tvPhone);
        switchToTextView(etEmail, tvEmail);
    }

    private void switchToTextView(EditText et, TextView tv) {
        tv.setText(et.getText().toString()); // Transfer the edited text
        et.setVisibility(View.GONE);
        tv.setVisibility(View.VISIBLE);
    }

    private void switchToEditText(TextView tv, EditText et) {
        tv.setVisibility(View.GONE);
        et.setVisibility(View.VISIBLE);
        et.requestFocus();
    }
}
