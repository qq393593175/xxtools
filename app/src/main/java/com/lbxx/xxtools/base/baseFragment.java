package com.lbxx.xxtools.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lbxx.xxtools.R;
import com.lbxx.xxtools.fragment.homefragment;
import com.lbxx.xxtools.fragment.systemfragment;
import com.lbxx.xxtools.fragment.toolsfragment;

public abstract class baseFragment extends Fragment {

    private View mBaseview;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBaseview = inflater.inflate(R.layout.fragment_base, container, false);
        getActivity(mBaseview);
        return mBaseview;
    }
    public View getActivity(View view){
        return view;
    }

    public abstract void initview();
    public abstract void initdata();

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
