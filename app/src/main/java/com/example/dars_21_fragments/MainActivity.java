package com.example.dars_21_fragments;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity
        extends AppCompatActivity
        implements ItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //todo ??? PIE
        //todo fix NPE when rotate


        if (findViewById(R.id.container_list) == null) {
            //mobile
            if (savedInstanceState == null) {
                addFragmentToContainer(new ListFragment(), R.id.container, false);
            }
        } else {
            //tablet
            addFragmentToContainer(new ListFragment(), R.id.container_list, false);
            addFragmentToContainer(PostFragment.create(new Post("", "")), R.id.container_content, false);
        }

    }

    private void addFragmentToContainer(Fragment fragment,
                                        @IdRes int containerId,
                                        boolean isAddToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .add(containerId, fragment);
        if (isAddToBackStack) transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onPostClick(Post post) {
        Toast.makeText(this, post.getTitle(), Toast.LENGTH_SHORT).show();
        PostFragment fragment = (PostFragment) getSupportFragmentManager().findFragmentById(R.id.container_content);
        if (fragment == null) {
            //mobile
            PostFragment postFragment = PostFragment.create(post);
            addFragmentToContainer(postFragment, R.id.container, true);
        } else {
            //tablet
            fragment.updatePost(post);
        }
    }
}
