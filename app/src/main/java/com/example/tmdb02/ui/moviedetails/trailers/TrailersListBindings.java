package com.example.tmdb02.ui.moviedetails.trailers;


import com.example.tmdb02.data.local.model.Trailer;

import java.util.List;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;


public class TrailersListBindings {

    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, List<Trailer> items) {
        TrailersAdapter adapter = (TrailersAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.submitList(items);
        }
    }
}
