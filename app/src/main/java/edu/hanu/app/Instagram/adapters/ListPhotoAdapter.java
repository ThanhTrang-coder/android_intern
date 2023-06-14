package edu.hanu.app.Instagram.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.hanu.app.Instagram.models.ListPhoto;
import edu.hanu.mydesign.R;

public class ListPhotoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_GRID = 1;
    public static final int TYPE_LARGE = 2;

    private List<ListPhoto> mListPhoto;

    public ListPhotoAdapter(List<ListPhoto> listPhotos) {
        this.mListPhoto = listPhotos;
    }

    @Override
    public int getItemViewType(int position) {
        ListPhoto listPhoto = mListPhoto.get(position);
        return listPhoto.getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(TYPE_GRID == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_grid_item, parent, false);
            return new PhotoGridViewHolder(view);
        } else if(TYPE_LARGE == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_large_item, parent, false);
            return new PhotoLargeViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ListPhoto listPhoto = mListPhoto.get(position);
        if(TYPE_GRID == listPhoto.getType()) {
            PhotoGridViewHolder photoGridViewHolder = (PhotoGridViewHolder) holder;
            photoGridViewHolder.image1.setImageResource(listPhoto.getPhotos().get(0).getResourceId());
            photoGridViewHolder.image2.setImageResource(listPhoto.getPhotos().get(1).getResourceId());
            photoGridViewHolder.image3.setImageResource(listPhoto.getPhotos().get(2).getResourceId());
        } else if(TYPE_LARGE == listPhoto.getType()) {
            PhotoLargeViewHolder photoLargeViewHolder = (PhotoLargeViewHolder) holder;
            photoLargeViewHolder.image1.setImageResource(listPhoto.getPhotos().get(0).getResourceId());
            photoLargeViewHolder.image2.setImageResource(listPhoto.getPhotos().get(1).getResourceId());
            photoLargeViewHolder.image3.setImageResource(listPhoto.getPhotos().get(2).getResourceId());
            photoLargeViewHolder.image4.setImageResource(listPhoto.getPhotos().get(3).getResourceId());
            photoLargeViewHolder.image5.setImageResource(listPhoto.getPhotos().get(4).getResourceId());
        }
    }

    @Override
    public int getItemCount() {
        if (mListPhoto != null) {
            return mListPhoto.size();
        }
        return 0;
    }

    public class PhotoGridViewHolder extends RecyclerView.ViewHolder {
        ImageView image1, image2, image3;

        public PhotoGridViewHolder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.image1);
            image2 = itemView.findViewById(R.id.image2);
            image3 = itemView.findViewById(R.id.image3);
        }
    }

    public class PhotoLargeViewHolder extends RecyclerView.ViewHolder {
        ImageView image1, image2, image3, image4, image5;

        public PhotoLargeViewHolder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.image1);
            image2 = itemView.findViewById(R.id.image2);
            image3 = itemView.findViewById(R.id.image3);
            image4 = itemView.findViewById(R.id.image4);
            image5 = itemView.findViewById(R.id.image5);
        }
    }
}
