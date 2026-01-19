package document.state;

import document.context.DocumentContext;

public class PublishedState implements DocumentState {
    public void handle(DocumentContext document) {
        System.out.println("Tài liệu đã xuất bản");
    }
}
