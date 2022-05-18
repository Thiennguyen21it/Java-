package XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class LibraryParser extends DefaultHandler {
    List<Author> authors = new ArrayList<>();
    List<Book> books = new ArrayList<>();
    Author author = null;
    Book book = null;
    boolean isAuthor = false ;
    boolean isNickname = false;
    boolean isFullname = false;
    boolean isEmail = false;
    boolean isAddress = false;
    boolean isBirthday = false;


    boolean isBook = false;
    boolean isNickname2 = false;
    boolean isTitle= false;
    boolean isPrice = false;
    boolean isNxb = false;
    boolean isDes = false;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        // doc xong open tag
        if(qName.equalsIgnoreCase("author")){
            isAuthor = true;
            author = new Author();
        }
        if(isAuthor) {
            if (qName.equalsIgnoreCase("nickname")){
                isNickname= true;
            } else if (qName.equalsIgnoreCase("fullname")){
                isFullname= true;
            }else if (qName.equalsIgnoreCase("email")){
                isEmail= true;
            }else if (qName.equalsIgnoreCase("address")){
                isAddress= true;
            }else if (qName.equalsIgnoreCase("birthday")){
                isBirthday= true;
            }
        }
        if (qName.equalsIgnoreCase("book")){
            isBook = true;
            book = new Book();
        }
        if(isBook){
            if (qName.equalsIgnoreCase("title")){
                isTitle= true;
            } else if (qName.equalsIgnoreCase("nickname")){
                isNickname2= true;
            }else if (qName.equalsIgnoreCase("price")){
                isPrice= true;
            }else if (qName.equalsIgnoreCase("nxb")){
                isNxb= true;
            }else if (qName.equalsIgnoreCase("description")){
                isDes= true;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        // doc xong close tag
        if (qName.equalsIgnoreCase("author")){
            isAuthor = false;
            authors.add(author);
            author = null;
        }
        if(isAuthor) {
            if (qName.equalsIgnoreCase("nickname")){
                isNickname= false;
            } else if (qName.equalsIgnoreCase("fullname")){
                isFullname= false;
            }else if (qName.equalsIgnoreCase("email")){
                isEmail= false;
            }else if (qName.equalsIgnoreCase("address")){
                isAddress= false;
            }else if (qName.equalsIgnoreCase("birthday")){
                isBirthday= false ;
            }
        }
        if (qName.equalsIgnoreCase("book")){
            isBook = false;
            books.add(book);
            book = null;
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        // noi dung ben trong tag
        String str = String.valueOf(ch,start,length);
        if(isAuthor) {
            if (isNickname) {
                author.setNickname(str);
            }else if (isFullname) {
                author.setFullname(str);
            }if (isEmail) {
                author.setEmail(str);
            }if (isAddress) {
                author.setAddress(str);
            }if (isBirthday) {
                author.setBirthday(str);
            }
        }
        if(isBook){
            if (isNickname2) {
                book.setNickname(str);
            }else if (isTitle) {
                book.setTitle(str);
            }else if (isNxb) {
                book.setNxb(str);
            }else if (isPrice) {
                book.setPrice(Float.parseFloat(str));
            }else if (isDes) {
                book.setDescription(str);
            }
        }
    }

}
