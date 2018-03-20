public class ReverseListItem {
    private int docId;
    private int lineId;
//    private int wordRepeatTime;
    private int position;

    public ReverseListItem(int docId, int lineId, int position) {
        this.docId = docId;
        this.lineId = lineId;
//        this.wordRepeatTime = wordRepeatTime;
        this.position = position;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
