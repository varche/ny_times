package com.rita.new_york_times.ui.recycler_adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.rita.new_york_times.R;
import com.rita.new_york_times.db.AppDatabase;
import com.rita.new_york_times.model.Article;
import com.rita.new_york_times.model.ArticleEntity;
import com.rita.new_york_times.model.ArticleJSON;
import com.rita.new_york_times.ui.activities.MainActivity;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AdapterPopular extends RecyclerViewAdapter {

    public AdapterPopular(Context context, List<ArticleJSON> data) {

        this.context = context;
        this.data = new ArrayList<>();
        if (data != null)
            this.data.addAll(data);

    }

    @Override
    public View.OnClickListener OnIconClickListener(final RecyclerView.ViewHolder viewHolder) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Article starredArticle = data.get(viewHolder.getAdapterPosition());
                ArticleEntity articleEntity = new ArticleEntity(starredArticle.getId(),
                        starredArticle.getTitle(),
                        starredArticle.getPublished_date(),
                        starredArticle.getArticle_abstract(),
                        getImageFromViewHolder((RecyclerViewAdapter.ItemViewHolder)viewHolder));

                Executor myExecutor = Executors.newSingleThreadExecutor();
                myExecutor.execute(() -> {
                    AppDatabase.getAppDatabase(context).articleDAO().insertAll(articleEntity);
                    ((Activity)context).runOnUiThread(new Runnable() {
                        public void run() {
                            Toast.makeText(context, "The article was starred", Toast.LENGTH_SHORT).show();
                        }
                    });
                    ((MainActivity) context).getFragmentStarred().loadData();
                });

            }
        };
    }

    @Override
    protected void setIconImg(ItemViewHolder viewHolder) {
        viewHolder.iconImg.setImageResource(R.drawable.ic_star_border);
    }

    @Override
    protected void setThumbnailImage(ItemViewHolder holder, int position) {

        String url = ((ArticleJSON) data.get(position)).getImageUrl();

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(url)
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.imageView);


    }

    private byte[] getImageFromViewHolder(RecyclerViewAdapter.ItemViewHolder viewHolder) {
        ImageView imageView = viewHolder.getImageView();
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

        return baos.toByteArray();
    }
}
