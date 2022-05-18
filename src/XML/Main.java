package XML;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Author> authors = new ArrayList<>();
    static List<Book> books = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int chose;
        do{
            showMenu() ;
            chose  = Integer.parseInt(scanner.nextLine());
            switch (chose){
                case  1 :
                    inputAuthor();
                    break;
                case 2:
                    inputBook();
                    break;
                case 3:
                    displayBooK();
                    break;
                case 4:
                    saveFile();
                    break;
                case 5:
                    readFile();
                    break;
                case 6:
                    System.out.println("GoodByte !");
                    break;
                default:
                    System.out.println("Input failed !");
                    break;
            }
        }while (chose !=6);
    }

    private static void readFile() {
        File file = new File("library.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
        LibraryParser libraryParser = new LibraryParser();
        try {
            parser.parse(file,libraryParser);
            authors = libraryParser.authors;
            books = libraryParser.books;
            displayBooK();
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private static String toXML(String authorList , String bookList) {

        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<lib>\n" +
                "\n" +
                "    <author-list>  \n" +
                "\n" + authorList+
                "    </author-list>\n" +
                "\n" +
                "    <book-list>    \n" +
                "\n" + bookList+
                "    </book-list>\n" +
                "    \n" +
                "</lib>";
    }

    private static void saveFile() {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("library.xml");
            String authorList = "";
            for (Author author: authors
                 ) {
                authorList += author.toXML();
            }
            String bookList="";
            for (Book book :
                    books) {
                bookList += book.toXML();
            }
            String content = toXML(authorList,bookList);
            byte[] data = content.getBytes(StandardCharsets.UTF_8);
            fileOutputStream.write(data);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    private static void displayBooK() {
        books.forEach(book ->{
            System.out.println(book);
        });
    }

    private static void inputBook() {
        System.out.println("Enter (N) book ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0 ; i < n ; i++) {
            Book book = new Book();
            book.Input();
            books.add(book);
        }
    }

    private static void inputAuthor() {
        System.out.println("Enter (N) Author");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0 ; i < n ; i++) {
            Author author = new Author();
            author.Input();
            authors.add(author);
        }
    }

    public static void showMenu(){
        System.out.println("1. Input Author ");
        System.out.println("2. Input Book ");
        System.out.println("3. Display Book ");
        System.out.println("4. Save File ");
        System.out.println("5. Read File ");
    }
}
