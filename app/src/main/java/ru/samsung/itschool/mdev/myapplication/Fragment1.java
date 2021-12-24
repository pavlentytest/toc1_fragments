package ru.samsung.itschool.mdev.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {

    private String mParam1;
    public OnDataFragment1Listener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(listener instanceof OnDataFragment1Listener) {
            listener = (OnDataFragment1Listener) getActivity();  // context
        } else {
            // исключение
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(MainActivity.KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    public interface OnDataFragment1Listener {
        void onDataFragment1Listener(String str);
    }
}