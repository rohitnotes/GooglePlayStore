package google.play.store.model;

import java.util.ArrayList;
public class VerticalModel
{
    private String itemTitle;
    private ArrayList<HorizontalModel> horizontalModelArrayList;

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public ArrayList<HorizontalModel> getHorizontalModelArrayList() {
        return horizontalModelArrayList;
    }

    public VerticalModel(String itemTitle, ArrayList<HorizontalModel> horizontalModelArrayList) {
        this.itemTitle = itemTitle;
        this.horizontalModelArrayList = horizontalModelArrayList;
    }

    public void setHorizontalModelArrayList(ArrayList<HorizontalModel> horizontalModelArrayList) {
        this.horizontalModelArrayList = horizontalModelArrayList;
    }
}
