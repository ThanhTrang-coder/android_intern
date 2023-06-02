package edu.hanu.app.Pinterest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.hanu.app.Pinterest.models.Craft;
import edu.hanu.mydesign.R;

public class CraftAdapter extends RecyclerView.Adapter<CraftAdapter.CraftHolder> {
    private Context context;
    private ArrayList<Craft> list;

    public CraftAdapter(Context context, ArrayList<Craft> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CraftHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pinterest, parent, false);
        return new CraftHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CraftHolder holder, int position) {
        Craft item = list.get(position);
        holder.imageView.setImageResource(item.getImageUrl());
        holder.textView.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        if (list != null) return list.size();
        return 0;
    }

    public class CraftHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public CraftHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
