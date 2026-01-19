package document.decorator;

public abstract class DocumentDecorator implements Document {
    protected Document document;

    public DocumentDecorator(Document document) {
        this.document = document;
    }
}
