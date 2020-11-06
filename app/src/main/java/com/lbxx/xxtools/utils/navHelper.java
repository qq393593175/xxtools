package com.lbxx.xxtools.utils;

import android.content.Context;
import android.util.SparseArray;
import android.widget.TabHost;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class navHelper<T> {
    private final SparseArray<Tab<T>> tabs = new SparseArray<>();
    private  int containerId;
    private FragmentManager fragmentManager;
    private Tab<T> currentTab;
    private Context mContext;
    private  OnTabChangeListener<T> mListener;
    public navHelper(Context mContext, int containerId, FragmentManager fragmentManager, OnTabChangeListener<T> mlistener){
        this.mContext=mContext;
        this.containerId=containerId;
        this.fragmentManager=fragmentManager;
        this.mListener=mlistener;
    }
    public boolean ClickMenu(int menuid){
        Tab<T> tab = tabs.get(menuid);
        if(tab!=null){
            doSelect(tab);
            return true;
        }
        return false;
    }
    public Tab<T> getCurrentTab(){
        return currentTab;
    }
    public void doSelect(Tab<T> tab){
        Tab<T> oldTab=null;
        if (currentTab!=null){
            oldTab=currentTab;
            if (oldTab==tab){
                notifyReselect(tab);
                return;
            }
        }
        currentTab = tab;
        doTabChanged(currentTab,oldTab);
    }

    private void doTabChanged(Tab<T> newTab,Tab<T> oldTab) {

        FragmentTransaction ft = fragmentManager.beginTransaction();
        if (oldTab!=null){
            if (oldTab.mFragment!=null){
                ft.detach(oldTab.mFragment);
            }
        }
        if(newTab!=null){
            if (newTab.mFragment==null){
                Fragment fragment=Fragment.instantiate(mContext,newTab.clx.getName(),null);
                newTab.mFragment=fragment;
                ft.add(containerId,fragment,newTab.clx.getName());
            }else {
                ft.attach(newTab.mFragment);
            }
        }
    }

    private void notifyReselect(Tab<T> tab) {
        /*刷新*/
    }

    public static class Tab<T>{
        public Tab(Class<?> clx,T extra){
            this.clx=clx;
            this.extra=extra;
        }
        Class<?> clx;
        public T extra;
        private Fragment mFragment;
    }

    /**
     * 事件处理回调接口
     *
     * @param <T>
     */
    public interface OnTabChangeListener<T> {
        void onTabChange(Tab<T> newTab, Tab<T> oldTab);
    }
}
