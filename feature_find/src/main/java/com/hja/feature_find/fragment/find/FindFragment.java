package com.hja.feature_find.fragment.find;


import android.util.Log;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hja.feature_find.BR;
import com.hja.feature_find.R;
import com.hja.feature_find.bean.ResFindAnchor;
import com.hja.feature_find.bean.ResFindCategory;
import com.hja.feature_find.bean.ResFindTopic;
import com.hja.feature_find.databinding.LayoutFragmentFindBinding;
import com.hja.libbase.base.BaseFragment;
import com.hja.libbase.config.ARouterPath;

import java.util.List;

@Route(path = ARouterPath.Find.FRAGMENT_FIND)
public class FindFragment extends BaseFragment<LayoutFragmentFindBinding, FindViewModel> {
    private static final String TAG = "FindFragment";
    private CategoryAdapter mCategoryAdapter;
    private AnchorAdapter mAnchorAdapter;

    @Override
    protected FindViewModel getViewModel() {
        return new ViewModelProvider(this).get(FindViewModel.class);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_fragment_find;
    }

    @Override
    protected int getBindingVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initView() {
        Log.i(TAG, "initView");

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        mDataBinding.rvCategory.setLayoutManager(layoutManager);

        mCategoryAdapter = new CategoryAdapter();
        mDataBinding.rvCategory.setAdapter(mCategoryAdapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);//指定为横向
        mDataBinding.rvAnchor.setLayoutManager(linearLayoutManager);

        mAnchorAdapter = new AnchorAdapter();
        mDataBinding.rvAnchor.setAdapter(mAnchorAdapter);
    }

    @Override
    protected void initData() {

        mViewModel.loadFindData();//请求数据

        mViewModel.getCategory().observe(getViewLifecycleOwner(), new Observer<List<ResFindCategory>>() {
            @Override
            public void onChanged(List<ResFindCategory> category) {
                mCategoryAdapter.setDatas(category);
            }
        });

        mViewModel.getAnchor().observe(getViewLifecycleOwner(), new Observer<List<ResFindAnchor>>() {
            @Override
            public void onChanged(List<ResFindAnchor> anchors) {
                mAnchorAdapter.setDatas(anchors);
            }
        });

    }
}
