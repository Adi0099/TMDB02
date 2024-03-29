package com.example.tmdb02.ui.moviedetails.trailers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.tmdb02.R;
import com.example.tmdb02.data.local.model.Trailer;
import com.example.tmdb02.databinding.ItemTrailerBinding;
import com.example.tmdb02.utils.Constants;
import com.example.tmdb02.utils.GlideApp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class TrailerViewHolder extends RecyclerView.ViewHolder {

    private ItemTrailerBinding binding;

    private Context context;

    public TrailerViewHolder(@NonNull ItemTrailerBinding binding, Context context) {
        super(binding.getRoot());

        this.binding = binding;
        this.context = context;
    }

    public void bindTo(final Trailer trailer) {
        String thumbnail =
                "https://img.youtube.com/vi/" + trailer.getKey() + "/hqdefault.jpg";
        GlideApp.with(context)
                .load(thumbnail)
                .placeholder(R.color.md_grey_200)
                .into(binding.imageTrailer);

        binding.trailerName.setText(trailer.getTitle());

        binding.cardTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent appIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("vnd.youtube:" + trailer.getKey()));
                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(Constants.YOUTUBE_WEB_URL + trailer.getKey()));
                if (appIntent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(appIntent);
                } else {
                    context.startActivity(webIntent);
                }
            }
        });

        binding.executePendingBindings();
    }

    public static TrailerViewHolder create(ViewGroup parent) {
        // Inflate
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Create the binding
        ItemTrailerBinding binding =
                ItemTrailerBinding.inflate(layoutInflater, parent, false);
        return new TrailerViewHolder(binding, parent.getContext());
    }
}
