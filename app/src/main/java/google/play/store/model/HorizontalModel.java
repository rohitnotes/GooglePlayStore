package google.play.store.model;

public class HorizontalModel {

    private int itemImage;
    private String itemTitle;

    public HorizontalModel(int itemImage, String itemTitle) {
        this.itemImage = itemImage;
        this.itemTitle = itemTitle;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }
}
