package top.hooya.mark.service;


import java.util.List;

import top.hooya.mark.pojo.AccountInfo;

public interface AccountInfoService {

    List<AccountInfo> getAccountInfoList();

    Long addAccountInfo(AccountInfo accountInfo);

    Long delAccountInfoById(int id);

    Long updateAccountInfoById(int id);


}
