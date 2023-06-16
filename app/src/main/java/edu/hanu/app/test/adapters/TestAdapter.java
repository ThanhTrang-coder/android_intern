package edu.hanu.app.test.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.hanu.app.test.models.HorizontalModel;
import edu.hanu.mydesign.R;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {
    List<HorizontalModel> list;

    public TestAdapter (List<HorizontalModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_horizontal, parent, false);
        return new TestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        HorizontalModel item = list.get(position);
        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TestViewHolder extends RecyclerView.ViewHolder {
        CircleImageView user_avatar;
        TextView user_name;

        public TestViewHolder(@NonNull View itemView) {
            super(itemView);

            user_avatar = itemView.findViewById(R.id.user_avatar);
            user_name = itemView.findViewById(R.id.user_name);
        }

        private void setData(HorizontalModel item) {
            user_avatar.setImageResource(item.getAvatar());
            user_name.setText(item.getUser_name());
        }
    }
}
