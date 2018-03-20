import java.util.ArrayList;
import java.util.List;

public class Word {
    private String string;
    private int id;
    private List<ReverseListItem> itemList;

    public Word(String string, int id) {
        this.id = id;
        this.string = string;
        itemList = new ArrayList<>();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ReverseListItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<ReverseListItem> itemList) {
        this.itemList = itemList;
    }

    public void addItem(ReverseListItem item) {
        itemList.add(item);
    }
}
