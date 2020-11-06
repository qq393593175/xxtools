package com.lbxx.xxtools.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lbxx.xxtools.R;
import com.lbxx.xxtools.base.baseFragment;

public class toolsfragment extends baseFragment {

    @Override
    public View getActivity(View view) {
        return super.getActivity(view);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tools, container, false);
        initview();
        initdata();
        return view;
    }

    @Override
    public void initview() {

    }

    @Override
    public void initdata() {

    }
}
