package com.hja.feature_plaza;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hja.feature_plaza.databinding.LayoutFragmentPlazaBinding;

@Route(path = "/plaza/plazaFragment")
public class PlazaFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        LayoutFragmentPlazaBinding binding = DataBindingUtil.inflate(inflater,R.layout.layout_fragment_plaza,container,false);
        View root = binding.getRoot();
        return root;
    }
}
