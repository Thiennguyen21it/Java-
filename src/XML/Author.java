package XML;

import java.util.Scanner;

public class Author {
    String nickname, fullname , email, address , birthday ;
    public Author() {
    }

    public Author(String nickname, String fullname, String email, String address, String birthday) {
        this.nickname = nickname;
        this.fullname = fullname;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public void Input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your nickname : ");
        nickname = scanner.nextLine();
        System.out.println("Enter your full name  : ");
        fullname = scanner.nextLine()   ;
        System.out.println("Enter your email : ");
        email = scanner.nextLine();
        System.out.println("Enter your address : ");
        address = scanner.nextLine();
        System.out.println("Enter your birth day : ");
        birthday = scanner.nextLine();
    }
    public  String toXML () {
        return "<author>\n" +
                "            <nickname>"+nickname+"</nickname>\n" +
                "            <fullname>"+fullname+" </fullname>\n" +
                "            <email>"+email+"</email>\n" +
                "            <birthday>"+birthday+"</birthday>\n" +
                "            <address>"+address+"</address>\n" +
                "        </author>\n";
    }

}
