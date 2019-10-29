package top.hooya.mark.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import top.hooya.mark.pojo.AccountInfo;

@Dao
public interface AccountInfoDao {

    @Query("select * from account_info where del_flag = 0")
    List<AccountInfo> selectAccountInfoList();

    @Insert
    Long insertAccountInfo(AccountInfo accountInfo);




}
