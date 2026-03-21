package com.hja.feature_home.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hja.feature_home.bean.ResVideo;
import com.hja.feature_home.databinding.ItemVideoBinding;
import com.hja.libbase.utils.GlideUtils;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {


    private  List<ResVideo> mVideos;

    public VideoAdapter() {

//        mVideos = videos;
    }

    public void setVideos(List<ResVideo> videos) {
        this.mVideos = videos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        ItemVideoBinding binding = ItemVideoBinding.inflate(inflater, parent, false);


        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ResVideo video = mVideos.get(position);
        holder.binding.setVideo(video);
        holder.binding.executePendingBindings();//实时更新数据



    }

    @Override
    public int getItemCount() {
        return mVideos == null ? 0 : mVideos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final ItemVideoBinding binding;

        public ViewHolder(ItemVideoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
