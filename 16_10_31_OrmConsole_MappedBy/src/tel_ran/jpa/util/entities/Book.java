package tel_ran.jpa.util.entities;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="2016_10_31_Book")
public class Book {
@Id
long isbn;
String title;
float price;
@ManyToOne
Publisher publisher;
@ManyToMany
Set<Author> authors;

public Book(){};
public Book(long isbn, String title, float price) {
	super();
	this.isbn = isbn;
	this.title = title;
	this.price = price;

}
@Override
public String toString() {
	return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price + ", publisher=" + publisher + ", authors="
			+ authors + "]";
}
public float getPrice() {
	return price;
}
public Publisher getPublisher() {
	return publisher;
}
public Set<Author> getAuthors() {
	return authors;
}
public void setPrice(float price) {
	this.price = price;
}
public void setPublisher(Publisher publisher) {
	this.publisher = publisher;
}
public void setAuthors(Set<Author> authors) {
	this.authors = authors;
}
public long getIsbn() {
	return isbn;
}
public void setIsbn(long isbn) {
	this.isbn = isbn;
}


}
