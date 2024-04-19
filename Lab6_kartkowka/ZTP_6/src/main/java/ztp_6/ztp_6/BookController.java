package ztp_6.ztp_6;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class BookController {
    List<Book> books = new ArrayList<>();

    @GetMapping("/books")
    public String books() {
        String result = null;
        for (int i = 0 ; i < books.size() ; i++){
            result += books.get(i).toString();
        }
        return result;
    }


    @GetMapping("/Test")
    public String TEST() {
        return "TEST";
    }

    @GetMapping("/books_taken")
    public String books_taken() {
        String result = null;
        for (int i = 0 ; i < books.size() ; i++){
            if (books.get(i).getTaken()){
                result += books.get(i).toString();
            }
        }
        return result;
    }

    @GetMapping("/books_author")
    public String books_author(@RequestParam(value = "Author") String Author) {
        String result = null;
        for (int i = 0 ; i < books.size() ; i++){
            if (books.get(i).getAuthor().equals(Author)){
                result += books.get(i).toString();
            }
        }
        return result;
    }

    @PostMapping("/book")
    public String book_post(@RequestParam(value = "title") String title, @RequestParam(value = "Author") String Author, @RequestParam(value = "Data_Wydania") String Data_Wydania) {
        books.add(new Book(title,Author,Data_Wydania));
        return "New Book Added";
    }

    @PostMapping("/book_take")
    public String book_take(@RequestParam(value = "title") String title) {
        for (int i = 0 ; i < books.size() ; i++){
            if (books.get(i).getTitle().equals(title)){
                books.get(i).setTaken(Boolean.TRUE);
            }
        }
        return title + "has been taken";
    }

    @PostMapping("/book_give")
    public String book_give(@RequestParam(value = "title") String title) {
        for (int i = 0 ; i < books.size() ; i++){
            if (books.get(i).getTitle().equals(title)){
                books.get(i).setTaken(Boolean.FALSE);
            }
        }
        return title + "has been given";
    }

}

