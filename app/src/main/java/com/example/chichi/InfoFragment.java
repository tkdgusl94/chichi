package com.example.chichi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class InfoFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }
}


/*
질문
1. 스타트 화면에서 권한을 받아야지만 다음 화면으로 가게끔 하려면?
2. 메시지를 받으면 리시버에서 메시지 프래그먼트의 리사이클러뷰에 추가하는 방법
 */