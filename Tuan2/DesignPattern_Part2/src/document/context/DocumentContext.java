package document.context;

import document.state.DocumentState;
import document.state.DraftState;
import document.strategy.ExportStrategy;

public class DocumentContext {

    private DocumentState state;
    private ExportStrategy exportStrategy;

    public DocumentContext() {
        state = new DraftState();
    }

    public void setState(DocumentState state) {
        this.state = state;
    }

    public void process() {
        state.handle(this);
    }

    public void setExportStrategy(ExportStrategy strategy) {
        this.exportStrategy = strategy;
    }

    public void export() {
        exportStrategy.export();
    }
}
