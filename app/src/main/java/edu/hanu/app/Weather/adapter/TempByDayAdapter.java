package edu.hanu.app.Weather.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.hanu.app.Weather.model.TempByDay;
import edu.hanu.mydesign.R;

public class TempByDayAdapter extends RecyclerView.Adapter<TempByDayAdapter.TempByDayHolder> {
    private List<TempByDay> list;

    public void setData (List<TempByDay> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public TempByDayHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_temp_by_day, parent, false);
        return new TempByDayHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TempByDayHolder holder, int position) {
        TempByDay item = list.get(position);
        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TempByDayHolder extends RecyclerView.ViewHolder {
        TextView tvDay, tvHumidity, tvTempMaxMin;

        public TempByDayHolder(@NonNull View itemView) {
            super(itemView);

            tvDay = itemView.findViewById(R.id.tvDay);
            tvHumidity = itemView.findViewById(R.id.tvHumidity);
            tvTempMaxMin = itemView.findViewById(R.id.tvTempMaxMin);
        }

        private void setData(TempByDay item) {
            tvDay.setText(item.getDay());
            tvHumidity.setText(""+item.getHumidity()+"%");
            tvTempMaxMin.setText(item.getTempMax()+"⁰/ "+item.getTempMin()+"⁰");
        }
    }
}
