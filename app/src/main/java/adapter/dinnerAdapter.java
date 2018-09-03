package adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.bmi_app.R;

import java.util.Collections;
import java.util.List;

import Item.Item;
import Item.SetViewHolder;



public class dinnerAdapter extends RecyclerView.Adapter<SetViewHolder>{
    private Activity activity;
    List<Item> items = Collections.emptyList();
    public dinnerAdapter(Activity activity, List<Item> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public SetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item,parent,false);
        return  new SetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SetViewHolder holder, int position) {
        holder.txt_food.setText(items.get(position).getFood());
        holder.txt_value.setText(items.get(position).getValue());
        holder.txt_calories.setText(items.get(position).getCalories());
    }

    @Override
    public int getItemCount() {
        return  items.size();
    }
}
