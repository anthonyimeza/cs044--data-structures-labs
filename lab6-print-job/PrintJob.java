

public class PrintJob {

    private String documentName;
    private int pageCount;

    //Constructor
    public PrintJob(String documentName, int pageCount) {
        this.documentName = documentName;
        this.pageCount = pageCount;

    }
    //Getters (just in-case)
    public int getPageCount() {
        return pageCount;
    }
    public String getDocumentName() {
        return documentName;
    }

    @Override
    public String toString() {
        return "PrintJob[Document: " + documentName + ", Pages: " + pageCount + "]";
    }
}