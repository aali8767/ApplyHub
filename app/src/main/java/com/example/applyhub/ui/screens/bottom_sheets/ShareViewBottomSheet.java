package com.example.applyhub.ui.screens.bottom_sheets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.applyhub.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class ShareViewBottomSheet extends BottomSheetDialogFragment {

    public ShareViewBottomSheet() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.bottom_sheet_share, container, false);
    }
}