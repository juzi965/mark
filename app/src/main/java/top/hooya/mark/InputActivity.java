package top.hooya.mark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.Date;

import top.hooya.mark.dao.AccountInfoDao;
import top.hooya.mark.pojo.AccountInfo;
import top.hooya.mark.service.AccountInfoService;
import top.hooya.mark.service.impl.AccountInfoServiceImpl;
import top.hooya.mark.ui.main.PageViewModel;
import top.hooya.mark.utils.AppDatabase;

public class InputActivity extends AppCompatActivity {

    private AccountInfoService accountInfoService = new AccountInfoServiceImpl();

    private PageViewModel pageViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        Button saveButton = findViewById(R.id.save);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel .class);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText accountName = findViewById(R.id.acconut_name);
                EditText userName = findViewById(R.id.user_name);
                final EditText password = findViewById(R.id.password);
                EditText note = findViewById(R.id.note);

                final AccountInfo accountInfo = new AccountInfo();
                accountInfo.setAccountName(accountName.getText().toString());
                accountInfo.setUserName(userName.getText().toString());
                accountInfo.setPassword(password.getText().toString());
                accountInfo.setNote(note.getText().toString());
                accountInfo.setDelFlag(0);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        accountInfoService.addAccountInfo(accountInfo);
                        pageViewModel.updateAccountInfo();
                    }
                }).start();
                Snackbar.make(view, "保存成功", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                finish();

            }
        });
    }

}
