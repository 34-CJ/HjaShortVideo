package com.hja.feature_user.config;

public class UserConfig {

    public static class AgreementType {
        public static final String KEY_AGREEMENT_TYPE = "KEY_AGREEMENT_TYPE";//跳转到协议页面的key

        public static final int VALUE_AGREEMENT = 0;//用户协议
        public static final int VALUE_PRIVATE = 1;//隐私政策
        public static final int VALUE_SIMPLE_PRIVATE = 2;//隐私政策概要
        public static final int VALUE_USER_INFO = 3;//个人信息收集清单
    }
}
