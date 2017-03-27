package com.undabot.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.undabot.newsapp.model.Article;

import java.util.List;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ViewHolder> {

    private NewsActivity activity;
    private final List<Article> data;

    public ArticlesAdapter(NewsActivity activity, List<Article> data) {
        this.activity = activity;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Article article = data.get(position);

        holder.tvTitle.setText(article.title);
        holder.tvContentPreview.setText(article.content);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activity.isTwoPane()) {
                    Bundle arguments = new Bundle();
                    arguments.putString(ArticleDetailFragment.ARG_ITEM_ID, article.id);
                    ArticleDetailFragment fragment = new ArticleDetailFragment();
                    fragment.setArguments(arguments);
                    activity.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.article_detail_container, fragment)
                            .commit();
                } else {
                    Intent intent = new Intent(activity, ArticleDetailActivity.class);
                    intent.putExtra(ArticleDetailFragment.ARG_ITEM_ID, article.id);
                    activity.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View view;
        final TextView tvTitle;
        final TextView tvContentPreview;

        ViewHolder(View view) {
            super(view);
            this.view = view;
            this.tvTitle = (TextView) view.findViewById(R.id.tv_title);
            this.tvContentPreview = (TextView) view.findViewById(R.id.tv_content_preview);
        }
    }
}