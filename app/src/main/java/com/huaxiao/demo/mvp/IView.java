package com.huaxiao.demo.mvp;

/**
 * Created by sunhuaxiao on 2018/12/5.
 */
public interface IView<P extends BasePresenter> {

    void setPresenter(P presenter);

    P getPresenter();

}
