package com.example.applyhub.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applyhub.databinding.ItemFaqBinding;
import com.example.applyhub.models.FaqResponse;

import java.util.List;

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.FaqViewHolder> {
    private final List<FaqResponse.FaqItem> faqList;
    private final OnFaqClickListener listener;

    public FaqAdapter(List<FaqResponse.FaqItem> faqList, OnFaqClickListener listener) {
        this.faqList = faqList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FaqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFaqBinding binding = ItemFaqBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new FaqViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FaqViewHolder holder, int position) {
        FaqResponse.FaqItem faq = faqList.get(position);
        holder.bind(faq, listener);
    }

    @Override
    public int getItemCount() {
        return faqList.size();
    }

    public static class FaqViewHolder extends RecyclerView.ViewHolder {
        private final ItemFaqBinding binding;

        public FaqViewHolder(@NonNull ItemFaqBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(FaqResponse.FaqItem faqItem, OnFaqClickListener listener) {
            binding.tvQuestion.setText(faqItem.getTitle());
            binding.getRoot().setOnClickListener(v -> listener.onFaqClick(faqItem));
        }
    }

    public interface OnFaqClickListener {
        void onFaqClick(FaqResponse.FaqItem faqItem);
    }
}
