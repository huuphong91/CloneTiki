package com.huupt.clonetiki.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.huupt.clonetiki.R;
import com.huupt.clonetiki.models.banner.BannerItem;

import java.util.ArrayList;
import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {

    List<BannerItem> listBanners = new ArrayList<>();

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_card_item, parent, false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        if(listBanners != null && listBanners.size() > 0) {
            holder.bind(listBanners.get(position % listBanners.size()));
        }
    }

    @Override
    public int getItemCount() {
        return listBanners.isEmpty() ? 0 : Integer.MAX_VALUE;
    }

    public void setListBanners(List<BannerItem> listBanners){
        this.listBanners = listBanners;
        notifyDataSetChanged();
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder {

        final ImageView imageView;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView3);
        }

        public void bind(BannerItem bannerItem){
            imageView.getRootView().setVisibility(View.VISIBLE);
            Glide.with(imageView.getContext()).load(bannerItem.getMobileUrl()).into(imageView);
        }
    }
}