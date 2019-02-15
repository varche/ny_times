package com.rita.new_york_times.ui.recycler_adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.rita.new_york_times.R;
import com.rita.new_york_times.db.AppDatabase;
import com.rita.new_york_times.model.ArticleEntity;
import com.rita.new_york_times.ui.activities.MainActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AdapterStarred extends RecyclerViewAdapter {

    public AdapterStarred(Context context, List<ArticleEntity> data) {
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
                ArticleEntity removedArticle = (ArticleEntity) data.get(viewHolder.getAdapterPosition());
                Executor myExecutor = Executors.newSingleThreadExecutor();
                myExecutor.execute(() -> {
                    AppDatabase.getAppDatabase(context).articleDAO().delete(removedArticle);
                    ((Activity)context).runOnUiThread(new Runnable() {
                        public void run() {
                            Toast.makeText(context, "The article was removed from Starred", Toast.LENGTH_SHORT).show();
                            ((MainActivity)context).getFragmentStarred().loadData();
                        }
                    });

                });

            }
        };
    }


    @Override
    protected void setIconImg(ItemViewHolder viewHolder) {
        viewHolder.iconImg.setImageResource(R.drawable.ic_delete);
    }

    @Override
    protected void setThumbnailImage(ItemViewHolder holder, int position) {
        byte[] image = ((ArticleEntity) data.get(position)).getImage();

        Bitmap bitmap = BitmapFactory.decodeByteArray(image,0, image.length);
        if (bitmap != null)
            holder.imageView.setImageBitmap(bitmap);
    }
}
