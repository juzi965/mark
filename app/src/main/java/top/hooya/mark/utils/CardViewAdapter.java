package top.hooya.mark.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import top.hooya.mark.R;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ItemCardViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private List<String> mList;

    public CardViewAdapter(Context context, List<String> list){
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mList = list;
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }

    @NonNull
    @Override
    public CardViewAdapter.ItemCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CardViewAdapter.ItemCardViewHolder(mLayoutInflater.inflate(R.layout.card_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewAdapter.ItemCardViewHolder holder, int position) {
        holder.textView.setText(mList.get(position));
    }

    public static class ItemCardViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public ItemCardViewHolder(View inflate) {
            super(inflate);
            textView = inflate.findViewById(R.id.show_name);
        }
    }

}
