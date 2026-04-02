package com.hja.feature_user.ui.agreement;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.lifecycle.ViewModelProvider;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hja.feature_user.R;
import com.hja.feature_user.databinding.ActivityAgreementBinding;
import com.hja.libbase.base.BaseActivity;
import com.hja.libbase.base.BaseViewModel;
import com.hja.libbase.config.ARouterPath;
import com.hja.libbase.utils.StatusBarUtils;

@Route(path = ARouterPath.User.ACTIVITY_AGREEMENT)
public class AgreementActivity extends BaseActivity<ActivityAgreementBinding, BaseViewModel> {

    private final String URL = "https://titok.fzqq.fun/agreement.html";


    @Override
    protected BaseViewModel getViewModel() {
        return new ViewModelProvider(this).get(BaseViewModel.class);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_agreement;
    }

    @Override
    protected int getBindingVariableId() {
        return 0;
    }

    @Override
    protected void initView() {
        StatusBarUtils.addStatusBarHeight2RootView(mDataBinding.getRoot());
    }

    @Override
    protected void initData() {
        mViewModel.showLoading(true);

        mDataBinding.webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //网页加载结束  会触发这个方法
                mViewModel.showLoading(false);
            }
        });
        mDataBinding.webView.loadUrl(URL);

    }
}