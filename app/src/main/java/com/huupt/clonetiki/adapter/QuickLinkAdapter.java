package com.huupt.clonetiki.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.huupt.clonetiki.R;
import com.huupt.clonetiki.models.quicklink.QuickLinkItem;

import java.util.ArrayList;
import java.util.List;

public class QuickLinkAdapter extends RecyclerView.Adapter<QuickLinkAdapter.QuickLinkViewHolder> {

    List<QuickLinkItem> listQuickLinks = new ArrayList<>();

    @NonNull
    @Override
    public QuickLinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quick_link_item, parent, false);
        return new QuickLinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuickLinkViewHolder holder, int position) {
        if (listQuickLinks != null && listQuickLinks.size() > 0) {
            Glide.with(holder.imgQLink.getContext()).load(listQuickLinks.get(position).getImageUrl()).into(holder.imgQLink);
            holder.tvQLink.setText(listQuickLinks.get(position).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return listQuickLinks == null ? 0 : listQuickLinks.size();
    }

    public void setListQuickLinks(List<QuickLinkItem> listQuickLinks) {
        this.listQuickLinks = listQuickLinks;
        notifyDataSetChanged();
    }

    public class QuickLinkViewHolder extends RecyclerView.ViewHolder {

        final ImageView imgQLink;
        final TextView tvQLink;

        public QuickLinkViewHolder(@NonNull View itemView) {
            super(itemView);
            imgQLink = itemView.findViewById(R.id.imgQLink);
            tvQLink = itemView.findViewById(R.id.tvTitleQLink);

        }
    }
}

