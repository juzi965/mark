package top.hooya.mark.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import top.hooya.mark.R;
import top.hooya.mark.dao.AccountInfoDao;
import top.hooya.mark.pojo.AccountInfo;
import top.hooya.mark.service.AccountInfoService;
import top.hooya.mark.service.impl.AccountInfoServiceImpl;
import top.hooya.mark.utils.AppDatabase;
import top.hooya.mark.utils.BaseApplication;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    private RecyclerView recyclerView;
    private Context mContext = BaseApplication.getContext();
    private  CardViewAdapter cardViewAdapter;


    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        pageViewModel.updateAccountInfo();
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        pageViewModel.getAccountInfos().observe(this, new Observer<List<AccountInfo>>() {
            @Override
            public void onChanged(List<AccountInfo> accountInfos) {
                cardViewAdapter = new CardViewAdapter(mContext,accountInfos);

                cardViewAdapter.setItemClickListener(new CardViewAdapter.OnItemClickListener() { //监听点击事件
                    @Override
                    public void onItemClick(int position) {

                        Toast.makeText(mContext, "点击 " + position, Toast.LENGTH_SHORT).show();
                    }
                });

                cardViewAdapter.setLongClickListener(new CardViewAdapter.OnLongClickListener() { //监听长按事件
                    @Override
                    public boolean onLongClick(View view, int position) {
                        PopupMenu popupMenu = new PopupMenu(mContext,view);
                        popupMenu.getMenuInflater().inflate(R.menu.menu_item,popupMenu.getMenu());
                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { //弹出菜单
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                switch (menuItem.getItemId()) {
                                    case R.id.del_item:
                                        Toast.makeText(mContext, "点了删除", Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.update_item:
                                        Toast.makeText(mContext, "点了修改", Toast.LENGTH_SHORT).show();
                                }
                                return false;
                            }
                        });
                        popupMenu.show();
                        Toast.makeText(mContext, "长按 " + position, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                recyclerView.setAdapter(cardViewAdapter);

            }
        });
        return root;
    }
}