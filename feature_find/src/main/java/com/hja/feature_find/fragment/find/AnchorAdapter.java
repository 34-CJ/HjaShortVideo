package com.hja.feature_find.fragment.find;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hja.feature_find.bean.ResFindAnchor;
import com.hja.feature_find.databinding.ItemAnchorBinding;

import java.util.List;

public class AnchorAdapter extends RecyclerView.Adapter<AnchorAdapter.ViewHolder> {

    private List<ResFindAnchor> mDatas;

    @NonNull
    @Override
    public AnchorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemAnchorBinding binding = ItemAnchorBinding.inflate(inflater, parent, false);
        return new AnchorAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AnchorAdapter.ViewHolder holder, int position) {
        ResFindAnchor anchor = mDatas.get(position);
        holder.binding.setData(anchor);
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public void setDatas(List<ResFindAnchor> datas) {
        this.mDatas = datas;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemAnchorBinding binding;

        public ViewHolder(ItemAnchorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

