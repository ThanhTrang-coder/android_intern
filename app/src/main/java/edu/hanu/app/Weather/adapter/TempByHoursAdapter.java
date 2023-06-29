package edu.hanu.app.Weather.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.hanu.app.Weather.model.TempByHours;
import edu.hanu.mydesign.R;

public class TempByHoursAdapter extends RecyclerView.Adapter<TempByHoursAdapter.TempHolder> {
    private List<TempByHours> list;

    public void setData (List<TempByHours> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public TempHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TempHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_temp_by_hours, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TempHolder holder, int position) {
        TempByHours item = list.get(position);
        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TempHolder extends RecyclerView.ViewHolder {
        TextView tvCurrentHours, tvCurrentTemp;
        ImageView iconWeather;

        public TempHolder(@NonNull View itemView) {
            super(itemView);

            tvCurrentHours = itemView.findViewById(R.id.tvCurrentHours);
            tvCurrentTemp = itemView.findViewById(R.id.tvCurrentTemp);
            iconWeather = itemView.findViewById(R.id.iconWeather);
        }

        private void setData(TempByHours item) {
            tvCurrentHours.setText(item.getHours());
            tvCurrentTemp.setText(item.getTemperature()+"⁰");
            iconWeather.setImageResource(item.getIconWeather());
        }
    }
}
