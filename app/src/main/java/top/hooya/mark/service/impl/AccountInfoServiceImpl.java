package top.hooya.mark.service.impl;

import java.util.List;

import top.hooya.mark.dao.AccountInfoDao;
import top.hooya.mark.pojo.AccountInfo;
import top.hooya.mark.service.AccountInfoService;
import top.hooya.mark.utils.AppDatabase;
import top.hooya.mark.utils.BaseApplication;

public class AccountInfoServiceImpl implements AccountInfoService {

    private AccountInfoDao accountInfoDao = AppDatabase.getInstance(BaseApplication.getContext()).accountInfoDao();


    @Override
    public List<AccountInfo> getAccountInfoList() {
        return accountInfoDao.selectAccountInfoList();
    }

    @Override
    public Long addAccountInfo(AccountInfo accountInfo) {

        return accountInfoDao.insertAccountInfo(accountInfo);
    }

    @Override
    public Long delAccountInfoById(int id) {
        return null;
    }

    @Override
    public Long updateAccountInfoById(int id) {
        return null;
    }
}
