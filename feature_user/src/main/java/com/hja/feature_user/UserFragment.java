package com.hja.feature_user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hja.feature_user.databinding.LayoutFragmentUserBinding;

@Route(path = "/user/userFragment")
public class UserFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        LayoutFragmentUserBinding binding = DataBindingUtil.inflate(inflater,R.layout.layout_fragment_user,container,false);
        View root = binding.getRoot();
        return root;
    }
}
