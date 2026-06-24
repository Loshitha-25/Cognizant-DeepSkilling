import java.util.Scanner;

public class FactoryTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter document type:");
        System.out.println("word");
        System.out.println("pdf");
        System.out.println("excel");

        String choice = sc.nextLine().toLowerCase();

        DocumentFactory factory = null;

        switch (choice) {
            case "word":
                factory = new WordDocumentFactory();
                break;

            case "pdf":
                factory = new PdfDocumentFactory();
                break;

            case "excel":
                factory = new ExcelDocumentFactory();
                break;

            default:
                System.out.println("Invalid document type");
                sc.close();
                return;
        }

        Document document = factory.createDocument();
        document.open();

        sc.close();
    }
}