package FragmentActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.android.bmi_app.R;

import data.DBAdapter;
import model.Spacecraft;


public class InterGalactic extends android.support.v4.app.Fragment {

    ListView lv;
    Button refreshBtn;
    ArrayAdapter<Spacecraft> adapter;

    public static InterGalactic newInstance()
    {
        return new InterGalactic();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.intergalactic,null);

        initializeViews(rootView);
        loadData();

        return rootView;
    }
    /*
    INITIALIZE VIEWS
     */
    private void initializeViews(View rootView)
    {
        lv= (ListView) rootView.findViewById(R.id.intergalactic_LV);
        refreshBtn= (Button) rootView.findViewById(R.id.intergalacticRefresh);

        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadData();
            }
        });
    }
    /*
    LOAD DATA
     */
    private void loadData()
    {
        DBAdapter db=new DBAdapter(getActivity());
        adapter=new ArrayAdapter<Spacecraft>(getActivity(),android.R.layout.simple_list_item_1,db.retrieveSpacecrafts(this.toString()));
        lv.setAdapter(adapter);

    }

    @Override
    public String toString() {
        return "Lunch";
    }
}