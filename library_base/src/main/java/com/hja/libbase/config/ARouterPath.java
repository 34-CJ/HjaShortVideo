package com.hja.libbase.config;

public class ARouterPath {

    /**
     * 对应app主模块
     */
    public static class Main {

        private static final String MAIN = "/main";

        //对应MainActivity的路径
        public static final String ACTIVITY_MAIN = MAIN + "/mainActivity";
    }

    public static class Home {

        private static final String HOME = "/home";
        public static final String FRAGMENT_HOME = HOME + "/homeFragment";
        public static final String FRAGMENT_VIDEO_LIST = HOME + "/videoListFragment";
    }

    public static class Plaza {

        private static final String PLAZA = "/plaza";
        public static final String FRAGMENT_PLAZA = PLAZA + "/plazaFragment";
    }

    public static class Find {

        private static final String FIND = "/find";
        public static final String FRAGMENT_FIND = FIND + "/findFragment";
    }

    public static class User {

        private static final String USER = "/user";
        public static final String FRAGMENT_USER = USER + "/userFragment";

        public static final String ACTIVITY_LOGIN = USER + "/loginActivity";
        public static final String ACTIVITY_AGREEMENT = USER + "/AgreementActivity";
    }


}
