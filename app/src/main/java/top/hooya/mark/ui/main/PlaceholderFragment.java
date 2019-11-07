package top.hooya.mark.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private LinearLayoutManager linearLayoutManager;
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
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = root.findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(linearLayoutManager);

        pageViewModel.getAccountInfos().observe(this, new Observer<List<AccountInfo>>() {
            @Override
            public void onChanged(List<AccountInfo> accountInfos) {
                cardViewAdapter = new CardViewAdapter(mContext,accountInfos);
                cardViewAdapter.setItemClickListener(new CardViewAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Toast.makeText(BaseApplication.getContext(), "click " + position, Toast.LENGTH_SHORT).show();
                    }
                });
                cardViewAdapter.setLongClickListener(new CardViewAdapter.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(int position) {
                        Toast.makeText(BaseApplication.getContext(), "long click " + position, Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                recyclerView.setAdapter(cardViewAdapter);

            }
        });
        return root;
    }
}