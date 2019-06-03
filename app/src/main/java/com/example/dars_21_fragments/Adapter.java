package com.example.dars_21_fragments;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.PostVH> {
    private ArrayList<Post> list;
    private LayoutInflater inflater;
    private ItemClickListener listener;

    public Adapter(Activity activity,
                   ArrayList<Post> list) {
        this.list = list;
        inflater = LayoutInflater.from(activity);
        this.listener = (ItemClickListener) activity;
    }

    @NonNull
    @Override
    public PostVH onCreateViewHolder(@NonNull ViewGroup parent,
                                     int viewType) {
        View itemView = inflater.inflate(R.layout.post_item, parent, false);
        return new PostVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostVH holder,
                                 int position) {
        Post post = list.get(position);
        holder.onBind(post);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PostVH extends RecyclerView.ViewHolder {
        private TextView tvTitle, tvContent;
        private Post lastSelectedPost;

        public PostVH(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(v -> listener.onPostClick(lastSelectedPost));

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_content);
        }

        void onBind(Post post) {
            this.lastSelectedPost = post;
            tvContent.setText(post.getContent().substring(0, 110) + "...");
            tvTitle.setText(post.getTitle());
        }
    }
}
