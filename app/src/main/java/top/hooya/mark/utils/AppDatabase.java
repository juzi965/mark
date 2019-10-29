package top.hooya.mark.utils;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import top.hooya.mark.dao.AccountInfoDao;
import top.hooya.mark.pojo.AccountInfo;

@Database(entities = {AccountInfo.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract AccountInfoDao accountInfoDao();

    private static final String DB_NAME = "AppDatabase.db";

    private static volatile AppDatabase instance;

    //单例模式
    static AppDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    return Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
                }
            }
        }
        return instance;

    }
}
