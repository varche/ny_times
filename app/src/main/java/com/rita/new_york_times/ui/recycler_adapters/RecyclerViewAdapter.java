package com.rita.new_york_times.ui.recycler_adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.rita.new_york_times.R;
import com.rita.new_york_times.model.Article;
import com.rita.new_york_times.model.ArticleJSON;
import com.rita.new_york_times.ui.activities.ArticleActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public abstract class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> {
    public static final String ARTICLE_TITLE = "ARTICLE_TITLE", ARTICLE_ABSTRACT = "ARTICLE_ABSTRACT";

    protected Context context;
    protected List<Article> data;

/*    public RecyclerViewAdapter(Context context, List<ArticleJSON> data) {
        this.context = context;
        this.data = data;
    }*/

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false);
        final ItemViewHolder viewHolder = new ItemViewHolder(view);
        setIconImg(viewHolder);

        viewHolder.itemArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ArticleActivity.class);
                intent.putExtra(ARTICLE_TITLE, data.get(viewHolder.getAdapterPosition()).getTitle());
                intent.putExtra(ARTICLE_ABSTRACT, data.get(viewHolder.getAdapterPosition()).getArticle_abstract());
                context.startActivity(intent);
            }
        });

        viewHolder.iconImg.setOnClickListener(OnIconClickListener(viewHolder));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.titleView.setText(data.get(position).getTitle());
        holder.dateView.setText(data.get(position).getPublished_date().toString());
        //holder.imageView.setImageResource(data.get(position).get);

        setThumbnailImage(holder, position);

    }



    @Override
    public int getItemCount() {
        if (data != null)
            return data.size();
        else
            return 0;
    }


    protected abstract View.OnClickListener OnIconClickListener(RecyclerView.ViewHolder viewHolder);
    protected abstract void setIconImg(ItemViewHolder viewHolder);
    protected abstract void setThumbnailImage(ItemViewHolder holder, int position);


    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout itemArticle;
        TextView titleView;
        TextView dateView;
        ImageView imageView;
        ImageView iconImg;

        public ImageView getImageView() {return imageView;}

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemArticle = itemView.findViewById(R.id.article_item);
            titleView = itemView.findViewById(R.id.name_article);
            dateView = itemView.findViewById(R.id.published_date);
            imageView = itemView.findViewById(R.id.img_article);
            iconImg = itemView.findViewById(R.id.icon_img);

        }
    }
}
