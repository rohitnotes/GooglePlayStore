package google.play.store.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import google.play.store.model.HorizontalModel;
import google.play.store.R;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder>
{
    private Context context;
    private ArrayList<HorizontalModel> horizontalModelArrayList;

    public HorizontalAdapter(Context context, ArrayList<HorizontalModel> arrayList)
    {
        this.context = context;
        this.horizontalModelArrayList = arrayList;
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.horizontal_item_row, parent, false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder itemViewHolder, final int position)
    {
        HorizontalModel horizontalModel = horizontalModelArrayList.get(position);
        ((HorizontalViewHolder)itemViewHolder).setData(horizontalModel);
    }

    @Override
    public int getItemCount()
    {
        return horizontalModelArrayList.size();
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView itemImageView;
        private TextView itemTextView;

        public HorizontalViewHolder(View itemView)
        {
            super(itemView);
            itemImageView = itemView.findViewById(R.id.item_image_view);
            itemTextView  = itemView.findViewById(R.id.item_text_view);
        }

        public void setData(HorizontalModel horizontalModel)
        {
            itemImageView.setImageResource(horizontalModel.getItemImage());
            itemTextView.setText(horizontalModel.getItemTitle());
        }
    }
}
