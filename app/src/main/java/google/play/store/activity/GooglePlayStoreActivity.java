package google.play.store.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import google.play.store.model.HorizontalModel;
import google.play.store.R;
import google.play.store.model.VerticalModel;
import google.play.store.adapter.VerticalAdapter;

public class GooglePlayStoreActivity extends AppCompatActivity {

    private RecyclerView verticalRecyclerView;
    private ArrayList<VerticalModel> verticalModelArrayList;
    private VerticalAdapter verticalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_play_store);
        initView();
        setData();
    }

    private void initView()
    {
        verticalRecyclerView=findViewById(R.id.vertical_recycler_view);
        verticalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        verticalModelArrayList = new ArrayList<>();
        verticalAdapter = new VerticalAdapter(this, verticalModelArrayList);
        verticalRecyclerView.setAdapter(verticalAdapter);
    }

    private void setData()
    {
        for (int i = 1; i <= 5; i++)
        {
            ArrayList<HorizontalModel>  horizontalModelArrayList = new ArrayList<>();

            for (int j = 0; j < 1; j++)
            {
                horizontalModelArrayList.add(new HorizontalModel(R.drawable.ic_whatsapp,"WhatsApp"));
                horizontalModelArrayList.add(new HorizontalModel(R.drawable.ic_skype,"Skype"));
                horizontalModelArrayList.add(new HorizontalModel(R.drawable.ic_facebook,"Facebook"));
                horizontalModelArrayList.add(new HorizontalModel(R.drawable.ic_gplus,"Google+"));
                horizontalModelArrayList.add(new HorizontalModel(R.drawable.ic_instagram,"Instagram"));
                horizontalModelArrayList.add(new HorizontalModel(R.drawable.ic_linkedin,"LinkedIn"));
                horizontalModelArrayList.add(new HorizontalModel(R.drawable.ic_quora,"Quora"));
                horizontalModelArrayList.add(new HorizontalModel(R.drawable.ic_twitter,"Twitter"));
                horizontalModelArrayList.add(new HorizontalModel(R.drawable.ic_tumblr,"Tumblr"));
                horizontalModelArrayList.add(new HorizontalModel(R.drawable.ic_email,"Email"));
            }
            verticalModelArrayList.add(new VerticalModel("Title " + i,horizontalModelArrayList));
        }
        verticalAdapter.notifyDataSetChanged();
    }
}
