package com.undabot.newsapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.undabot.newsapp.model.Article;
import com.undabot.newsapp.model.ArticlesDataSource;

/**
 * A fragment representing a single Article detail screen.
 * This fragment is either contained in a {@link NewsActivity}
 * in two-pane mode (on tablets) or a {@link ArticleDetailActivity}
 * on handsets.
 */
public class ArticleDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    private Article article;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ArticleDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get Article from passed argument
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            article = ArticlesDataSource.ARTICLE_MAP.get(getArguments().getString(ARG_ITEM_ID));
            // create intentional bug here :)
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        AppCompatActivity activity = (AppCompatActivity) this.getActivity();
        if (activity != null && activity.getSupportActionBar() != null) {
            activity.getSupportActionBar().setTitle(article.title);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.article_detail_fragment, container, false);

        // Show article content in TextView
        if (article != null) {
            TextView textView = (TextView) rootView.findViewById(R.id.article_detail);
            textView.setText(article.content);
        }

        return rootView;
    }
}