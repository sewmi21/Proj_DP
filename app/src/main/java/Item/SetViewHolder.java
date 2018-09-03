package Item;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.bmi_app.R;



public class SetViewHolder extends RecyclerView.ViewHolder{
    public TextView txt_food,txt_value,txt_calories;

    public SetViewHolder(View itemView) {
        super(itemView);

        txt_food = (TextView)itemView.findViewById(R.id.food);
        txt_value = (TextView)itemView.findViewById(R.id.value);
        txt_calories = (TextView)itemView.findViewById(R.id.calories);
    }
}
