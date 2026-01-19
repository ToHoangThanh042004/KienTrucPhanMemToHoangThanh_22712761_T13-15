package document.main;

import document.context.DocumentContext;
import document.decorator.BasicDocument;
import document.decorator.Document;
import document.decorator.PasswordDecorator;
import document.decorator.WatermarkDecorator;
import document.strategy.PdfExport;

public class MainApp {
    public static void main(String[] args) {

        // State
        DocumentContext doc = new DocumentContext();
        doc.process();
        doc.process();

        // Strategy
        doc.setExportStrategy(new PdfExport());
        doc.export();

        // Decorator
        Document document = new PasswordDecorator(
                                new WatermarkDecorator(
                                    new BasicDocument()));
        document.show();
    }
}
