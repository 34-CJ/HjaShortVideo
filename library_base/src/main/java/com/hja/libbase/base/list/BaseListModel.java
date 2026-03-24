package com.hja.libbase.base.list;

public abstract class BaseListModel {

    protected int mPage = 1;//当前请求的页数
    protected final int mLimit = 10;//每页需要请求的数量

    protected IListListenner mListenner;//加载成功或者失败时的回调


    public void setListenner(IListListenner listenner) {
        this.mListenner = listenner;
    }


    /**
     * 分页加载网络数据
     *
     * @param isFirst 是否第一次加载
     */
    public abstract void requestDatas(boolean isFirst);
}
