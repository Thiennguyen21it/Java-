package XML;

import java.util.Scanner;

public class Book {
    String title , nickname ,nxb ,description ;
    float price;
    public Book() {
    }


    public Book(String title, String nxb,String nickname, float price, String description) {
        this.title = title;
        this.nickname = nickname;
        this.price = price;
        this.description = description;
        this.nxb = nxb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void Input () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your book title  :");
        title = scanner.nextLine();
        System.out.println("Enter your book nickname ");
        nickname = scanner.nextLine();
        System.out.println("Enter your NXB : ");
        nxb = scanner.nextLine();
        System.out.println("Enter description");
        description = scanner.nextLine();
        System.out.println("Enter your book price");
        price = Float.parseFloat(scanner.nextLine());
    }
    public String toXML() {
        return " <book>\n" +
                "            <title>"+title+"</title>\n" +
                "            <nickname>"+nickname+"</nickname>\n" +
                "            <price>"+price+"</price>\n" +
                "            <nxb>"+nxb+"</nxb>\n" +
                "            <description>"+description+"</description>\n" +
                "        </book>";
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' + "nxb = '" +nxb + '\''+", nickname='" + nickname + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
