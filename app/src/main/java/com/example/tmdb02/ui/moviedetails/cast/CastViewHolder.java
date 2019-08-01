package com.example.tmdb02.ui.moviedetails.cast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.example.tmdb02.R;
import com.example.tmdb02.data.local.model.Cast;
import com.example.tmdb02.databinding.ItemCastBinding;
import com.example.tmdb02.utils.Constants;
import com.example.tmdb02.utils.GlideApp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CastViewHolder extends RecyclerView.ViewHolder {

    private ItemCastBinding binding;

    private Context context;

    public CastViewHolder(@NonNull ItemCastBinding binding, Context context) {
        super(binding.getRoot());

        this.binding = binding;
        this.context = context;
    }

    public void bindTo(final Cast cast) {
        String profileImage =
                Constants.IMAGE_BASE_URL + Constants.PROFILE_SIZE_W185 + cast.getProfileImagePath();
        GlideApp.with(context)
                .load(profileImage)
                .placeholder(R.color.md_grey_200)
                .dontAnimate()
                .into(binding.imageCastProfile);

        binding.textCastName.setText(cast.getActorName());

        binding.executePendingBindings();
    }

    public static CastViewHolder create(ViewGroup parent) {
        // Inflate
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Create the binding
        ItemCastBinding binding =
                ItemCastBinding.inflate(layoutInflater, parent, false);
        return new CastViewHolder(binding, parent.getContext());
    }
}
