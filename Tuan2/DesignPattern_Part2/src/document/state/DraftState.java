package document.state;

import document.context.DocumentContext;

public class DraftState implements DocumentState {
    public void handle(DocumentContext document) {
        System.out.println("Tài liệu đang soạn thảo");
        document.setState(new ReviewedState());
    }
}
