package com.example.applyhub.ui.screens.bottom_sheets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.applyhub.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class LoginSignupBottomSheet extends BottomSheetDialogFragment {

    public LoginSignupBottomSheet() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.bottom_sheet_login_signup, container, false);
    }
}