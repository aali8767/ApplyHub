package com.example.applyhub.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.applyhub.R;
import com.example.applyhub.databinding.ItemJobBinding;
import com.example.applyhub.models.Job;
import com.example.applyhub.models.Skill;

import java.util.List;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {
    private final List<Job> jobList;
    private final OnJobClickListener listener;

    public JobAdapter(List<Job> jobList, OnJobClickListener listener) {
        this.jobList = jobList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemJobBinding binding = ItemJobBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new JobViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        holder.bind(jobList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public static class JobViewHolder extends RecyclerView.ViewHolder {
        private final ItemJobBinding binding;
        private final Context context;

        public JobViewHolder(ItemJobBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.context = binding.getRoot().getContext();
        }

        @SuppressLint("SetTextI18n")
        void bind(Job job, OnJobClickListener listener) {
            binding.tvCreateTime.setText(job.getCreate_time());

            Glide
                    .with(context)
                    .load(job.getBusiness_man().getImage_url())
                    .centerCrop()
                    .circleCrop()
                    .placeholder(R.drawable.global_24)
                    .into(binding.ivBusinessMan);

            binding.tvTitle.setText(job.getTitle());
            binding.tvWatchesCount.setText(String.valueOf(job.getWatches_count()));

            if (job.getSalary() != null) {
                binding.tvSalary.setText((job.getSalary()));
            }

            binding.tvExperienceYear.setText(job.getExperience_year().getName());


            System.out.println(job.getBusiness_man().toString());
            binding.jobCompany.setText(
                    job.getBusiness_man().getBusiness_name() != null
                            ? job.getBusiness_man().getBusiness_name()
                            : "Unknown"
            );
            binding.tvSummary.setText(job.getSummary());

            binding.skillsContainer.removeAllViews();

            if (job.getSkills() != null) {
                for (Skill skill : job.getSkills()) {
                    TextView chip = new TextView(context);
                    chip.setText(skill.getName());
                    chip.setPadding(24, 12, 24, 12);
                    chip.setTextColor(Color.parseColor("#4BA8A4"));
                    chip.setTextSize(12);
                    chip.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_skill_chip));
                    chip.setLayoutParams(
                            new ViewGroup.MarginLayoutParams(
                                    ViewGroup.LayoutParams.WRAP_CONTENT,
                                    ViewGroup.LayoutParams.WRAP_CONTENT
                            )
                    );

                    ((ViewGroup.MarginLayoutParams) chip.getLayoutParams()).setMargins(8, 8, 8, 8);
                    binding.skillsContainer.addView(chip);
                }
            }

            binding.tvExpireDate.setText("Expire in: " + job.getExpire_date() + " days");

            binding.getRoot().setOnClickListener(view -> listener.onJobClick(job.getId()));
            binding.btnShare.setOnClickListener(view -> listener.onShareClick());
            binding.btnAddToBookmarks.setOnClickListener(view -> listener.onAddToBookmarksClick(job.getId()));
        }
    }

    public interface OnJobClickListener {
        void onJobClick(int jobId);

        void onShareClick();

        void onAddToBookmarksClick(int jobId);
    }
}
