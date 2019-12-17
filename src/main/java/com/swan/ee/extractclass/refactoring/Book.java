package com.swan.ee.extractclass.refactoring;

import lombok.Getter;

@Getter
public class Book {
    private String title;
    private String isbn;
    private String price;
    private Author author;

    public Book(String title, String isbn, String price, String authorName, String authorMail) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        author = new Author(authorName, authorMail);
    }

    public void setAuthorName(String name) {
        author.setName(name);
    }

    public void setAuthorMail(String mail) {
        author.setMail(mail);
    }

    public String getAuthorName() {
        return author.getName();
    }

    public String getAuthorMail() {
        return author.getMail();
    }

    public String toXml() {
        String authorContent = tag("author", tag("name", author.getName()) + tag("mail", author.getMail()));
        String bookContent = tag("book", tag("title", title) + tag("isbn", isbn) + tag("price", price) + authorContent);
        return bookContent;
    }

    private String tag(String element, String content) {
        return "<" + element + ">" + content + "</" + element + ">\n";
    }
}

class Author {
    private String name;
    private String mail;

    public Author(String authorName, String authorMail) {
        this.name = authorName;
        this.mail = authorMail;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() { return name; }
    public String getMail() { return mail; }
}
