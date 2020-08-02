package com.huupt.clonetiki.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.huupt.clonetiki.R;
import com.huupt.clonetiki.models.flashdeal.FlashDealItem;

import java.util.ArrayList;
import java.util.List;

public class FlashDealAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<FlashDealItem> listFlashDeals = new ArrayList<>();

    private static final int TYPE_SEE_MORE = 1;
    private static final int TYPE_FLASH_DEAL = 2;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_SEE_MORE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.see_more_item, parent, false);
            return new SeeMoreViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flash_deal_item, parent, false);
            return new FlashDealViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (listFlashDeals.get(position).getTags().equals("SEE MORE") && listFlashDeals.size() > 0) {
            return TYPE_SEE_MORE;
        } else {
            return TYPE_FLASH_DEAL;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(listFlashDeals.size() > 0){
            switch (getItemViewType(position)){
                case TYPE_SEE_MORE:

                    break;
                case TYPE_FLASH_DEAL:
                    ((FlashDealViewHolder) holder).bind(listFlashDeals.get(position));
                    break;
            }
        }

    }

    @Override
    public int getItemCount() {
        return listFlashDeals == null ? 0 : listFlashDeals.size();
    }

    public void setListFlashDeals(List<FlashDealItem> listFlashDeals) {
        this.listFlashDeals = listFlashDeals;
        notifyDataSetChanged();
    }

    public class FlashDealViewHolder extends RecyclerView.ViewHolder {

        final ImageView imgFlashDeal;
        final TextView tvPriceFlashDeal;
        final ProgressBar pbFlashDeal;
        final TextView tvOrdered;

        public FlashDealViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFlashDeal = itemView.findViewById(R.id.imgFlashDeal);
            tvPriceFlashDeal = itemView.findViewById(R.id.tvPriceFlashDeal);
            pbFlashDeal = itemView.findViewById(R.id.pBFlashDeal);
            tvOrdered = itemView.findViewById(R.id.tvOrdered);
        }

        @SuppressLint("SetTextI18n")
        public void bind(FlashDealItem flashDealItem) {
            Glide.with(imgFlashDeal.getContext()).load(flashDealItem.getProduct().getThumbnailUrl()).into(imgFlashDeal);
            tvPriceFlashDeal.setText(flashDealItem.getProduct().getPrice() + "");
            if ((100.0 - flashDealItem.getProgress().getPercent()) > 20.0) {
                pbFlashDeal.setProgress(100 - (int) flashDealItem.getProgress().getPercent());
            }
            tvOrdered.setText(flashDealItem.getProgress().getQtyOrdered() == 0 ? "Vừa mở bán" : "Đã bán " + flashDealItem.getProgress().getQtyOrdered());
        }
    }

    public class SeeMoreViewHolder extends RecyclerView.ViewHolder {

        public SeeMoreViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}

