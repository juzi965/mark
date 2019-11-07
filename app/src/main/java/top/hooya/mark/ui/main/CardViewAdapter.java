package top.hooya.mark.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import top.hooya.mark.R;
import top.hooya.mark.pojo.AccountInfo;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ItemCardViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private List<AccountInfo> mList;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public interface OnLongClickListener{
        boolean onLongClick(int position);
    }

    private OnItemClickListener mItemClickListener;
    private OnLongClickListener mLongClickListener;

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public void setLongClickListener(OnLongClickListener longClickListener) {
        mLongClickListener = longClickListener;
    }




    public CardViewAdapter(Context context, List<AccountInfo> list){
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
    public void onBindViewHolder(@NonNull CardViewAdapter.ItemCardViewHolder holder, final int position) {
        holder.textView.setText(mList.get(position).getAccountName());
        //设置点击和长按事件
        if (mItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(position);
                }
            });
        }
        if (mLongClickListener != null){
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    return mLongClickListener.onLongClick(position);
                }
            });
        }
    }

    public static class ItemCardViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public ItemCardViewHolder(View inflate) {
            super(inflate);
            textView = inflate.findViewById(R.id.show_name);
        }
    }

}
