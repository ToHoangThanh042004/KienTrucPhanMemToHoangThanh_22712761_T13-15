package document.strategy;

public class PdfExport implements ExportStrategy {
    public void export() {
        System.out.println("Xuất tài liệu sang PDF");
    }
}
