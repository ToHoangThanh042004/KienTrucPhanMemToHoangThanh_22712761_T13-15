package document.state;

import document.context.DocumentContext;

public interface DocumentState {
    void handle(DocumentContext document);
}
