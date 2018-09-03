package FragmentActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.bmi_app.DatabaseHelper;
import com.example.android.bmi_app.R;

import java.util.ArrayList;

import Item.Item;
import adapter.breakfastAdapter;



public class CGBreakfastFragment extends Fragment {
    private RecyclerView recyclerView;
    private DatabaseHelper databaseHelper;
    private ArrayList<Item> arrayList = new ArrayList<Item>();
    private Cursor cursor;
    private breakfastAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.list_item, container, false);
        recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler_view);
        loadDatabase();
        return viewGroup;
    }

    public void loadDatabase() {
        databaseHelper = new DatabaseHelper(getActivity());
        try {
            databaseHelper.checkAndCopyDatabase();
            databaseHelper.OpenDatabase();
        }catch (SQLiteException e){
            e.printStackTrace();
        }
        try {
            cursor = databaseHelper.QueryData("select * from CholesterolGastritisB");
            if (cursor != null) {
                if (cursor.moveToNext()) {
                    do {

                        Item item = new Item();
                        item.setFood(cursor.getString(1));
                        item.setValue(cursor.getString(2));
                        item.setCalories(cursor.getString(3));
                        arrayList.add(item);
                    } while (cursor.moveToNext());
                }
            }
        }catch (SQLiteException e){
            e.printStackTrace();
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        adapter = new breakfastAdapter(getActivity(),arrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
