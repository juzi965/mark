package top.hooya.mark.ui.main;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Collections;
import java.util.List;

import top.hooya.mark.pojo.AccountInfo;
import top.hooya.mark.service.AccountInfoService;
import top.hooya.mark.service.impl.AccountInfoServiceImpl;

public class PageViewModel extends ViewModel {

    private MutableLiveData<List<AccountInfo>> accountInfos = new MutableLiveData<>();
    private AccountInfoService accountInfoService = new AccountInfoServiceImpl();

    public LiveData<List<AccountInfo>> getAccountInfos(){
        if (accountInfos == null){
            accountInfos = new MutableLiveData<>();
            loadAccountInfos();
        }
        return accountInfos;
    }
    private void loadAccountInfos(){
        new Thread(){
            @Override
            public void run() {
                List<AccountInfo> accountInfoList = accountInfoService.getAccountInfoList();
                Collections.reverse(accountInfoList);
                accountInfos.postValue(accountInfoList);
            }
        }.start();

    }

    public void setAccountInfo(List<AccountInfo> accountInfoList){
        accountInfos.setValue(accountInfoList);
    }

    public LiveData<List<AccountInfo>> getData(){
        return accountInfos;
    }
    public void updateAccountInfo(){
        loadAccountInfos();
    }

}