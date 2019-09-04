package google.play.store.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import google.play.store.model.HorizontalModel;
import google.play.store.R;
import google.play.store.model.VerticalModel;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.VerticalViewHolder>
{
    private Context context;
    private ArrayList<VerticalModel> verticalModelArrayList;

    public VerticalAdapter(Context context, ArrayList<VerticalModel> arrayList)
    {
        this.context = context;
        this.verticalModelArrayList = arrayList;
    }

    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.vertical_item_row, parent, false);
        return new VerticalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder itemViewHolder, final int position)
    {
        VerticalModel verticalModel = verticalModelArrayList.get(position);
        ((VerticalViewHolder)itemViewHolder).setData(verticalModel);
    }

    @Override
    public int getItemCount()
    {
        return verticalModelArrayList.size();
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder
    {
        private TextView itemTextView;
        private Button moreButton;
        private RecyclerView itemHorizontalRecyclerView;

        public VerticalViewHolder(View itemView)
        {
            super(itemView);
            itemTextView  = itemView.findViewById(R.id.item_category_text_view);
            moreButton  = itemView.findViewById(R.id.more_button);
            itemHorizontalRecyclerView = itemView.findViewById(R.id.horizontal_recycler_view);
        }

        public void setData(VerticalModel verticalModel)
        {
            itemTextView.setText(verticalModel.getItemTitle());

            ArrayList<HorizontalModel> horizontalModelArrayList = verticalModel.getHorizontalModelArrayList();
            HorizontalAdapter horizontalAdapter = new HorizontalAdapter(context, horizontalModelArrayList);;

            itemHorizontalRecyclerView.setHasFixedSize(true);
            itemHorizontalRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            itemHorizontalRecyclerView.setAdapter(horizontalAdapter);
            itemHorizontalRecyclerView.setNestedScrollingEnabled(false);

            SnapHelper snapHelper = new LinearSnapHelper();
            snapHelper.attachToRecyclerView(itemHorizontalRecyclerView);

            moreButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, verticalModel.getItemTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
