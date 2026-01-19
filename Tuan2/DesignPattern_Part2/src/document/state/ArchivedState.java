package document.state;

import document.context.DocumentContext;

public class ArchivedState implements DocumentState {
    public void handle(DocumentContext document) {
        System.out.println("Tài liệu đã được lưu trữ");
    }
}
