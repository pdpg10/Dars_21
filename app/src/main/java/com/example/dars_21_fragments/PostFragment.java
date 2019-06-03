package com.example.dars_21_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PostFragment extends Fragment {
    private static final String POST_KEY = "selected_post";
    private TextView tvTitle, tvContent;
    private Post post;

    public static PostFragment create(Post post) {
        Bundle args = new Bundle();
        args.putParcelable(POST_KEY, post);
        PostFragment fragment = new PostFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            post = args.getParcelable(POST_KEY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.post_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvContent = view.findViewById(R.id.tv_content);
        tvTitle = view.findViewById(R.id.tv_title);
        updatePost(post);
    }

    public void updatePost(Post post) {
        this.post = post;
        tvTitle.setText(post.getTitle());
        tvContent.setText(post.getContent());
    }
}
