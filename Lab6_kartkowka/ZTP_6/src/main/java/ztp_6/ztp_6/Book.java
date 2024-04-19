package ztp_6.ztp_6;

public class Book {

    public String title;
    public String Author;

    public String Data_Wydania;

    public Boolean getTaken() {
        return isTaken;
    }

    public void setTaken(Boolean taken) {
        isTaken = taken;
    }

    public Boolean isTaken;

    public Book(String title, String Author, String Data_wydania) {
        this.isTaken = Boolean.FALSE;
        this.title = title;
        this.Author = Author;
        this.Data_Wydania = Data_wydania;
    }

    public String getData_Wydania() {
        return Data_Wydania;
    }

    public void setData_Wydania(String data_Wydania) {
        Data_Wydania = data_Wydania;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", Author='" + Author + '\'' +
                ", isTaken=" + isTaken +
                '}';
    }
}
