package document.state;

import document.context.DocumentContext;

public class ReviewedState implements DocumentState {
    public void handle(DocumentContext document) {
        System.out.println("Tài liệu đã được duyệt");
        document.setState(new PublishedState());
    }
}
