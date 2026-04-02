package com.hja.feature_user;

import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hja.feature_user.databinding.LayoutFragmentUserBinding;
import com.hja.libbase.base.BaseFragment;
import com.hja.libbase.base.BaseViewModel;
import com.hja.libbase.config.ARouterPath;
import com.hja.libbase.utils.StatusBarUtils;

@Route(path = ARouterPath.User.FRAGMENT_USER)
public class UserFragment extends BaseFragment<LayoutFragmentUserBinding, BaseViewModel> {
    private static final String TAG = "UserFragment";

    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.layout_fragment_user;
    }

    @Override
    protected int getBindingVariableId() {
        return 0;
    }

    @Override
    protected void initView() {
        Log.i(TAG, "initView");
        StatusBarUtils.addStatusBarHeight2Views(mDataBinding.getRoot(), mDataBinding.ivSettings, mDataBinding.ivQualifications);

        mDataBinding.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterPath.User.ACTIVITY_LOGIN).navigation();
            }
        });
    }

    @Override
    protected void initData() {

    }
}
