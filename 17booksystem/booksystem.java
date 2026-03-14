/*未完成
setId
例外処理 */

import java.util.*;

public class booksystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        BookAction bookAction = new BookAction();
        
        try{
        while (true) {
            System.out.println("1:本の登録 2:貸出 3:返却");
            int choose = sc.nextInt();
            sc.nextLine();

            /* 本の登録+並び替え＋表示 */
            if (choose == 1) {
                System.out.println("本の名前：");
            String name = sc.nextLine();
            
            System.out.println("著者名：");
            String author = sc.nextLine();
            
            /*IDはBookActionが決めるから
            仮の数0を置いとく */
            Book book = new Book(0, name, author);
            bookAction.addBook(book);

            //bookAction.sortBook(book, name);
        }
        /* 貸出 */
        else if (choose == 2) {
            System.out.println("借りたい本のID：");
            int id = sc.nextInt();
            sc.nextLine();
            bookAction.borrow(id);
        }
        else if (choose == 3) {
            System.out.println("返却したい本のID：");
            int id = sc.nextInt();
            sc.nextLine();
            bookAction.back(id);
        }
        else if (choose == 4) {
            bookAction.showBook();
    }
}
    catch (BookNotFoundException e) { 
        System.out.println(e.getMessage());

    }
    }  
    /*入力装置を閉じる */     
    sc.close();
}
}

/*
 * 本を登録
 * ↓
 * 本を貸す
 * ↓
 * 返却
 * ↓
 * 貸出一覧表示
 */

class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    /*
     * private は
     * 
     * 外のクラスから直接触れない
     * BookAction から
     * これはできない
     * book.id = 3
     * 
     * id メソッドの引数
     * this.id Bookのフィールド
     * 引数の id を
     * Bookの id に入れる;
     */
    public void setId(int id) {
        this.id = id;
    }
}

class BookAction {
    Map<Integer, Book> bookMap = new HashMap<>();
    Set<Integer> bookSet = new HashSet<>();
    /* IDの始まりは１にしたい */
    int nextId = 1;

    public void addBook(Book book) {
        bookMap.put(nextId, book);
        book.setId(nextId);
        System.out.println("本を登録しました" + nextId);
        nextId++;
    }

    public void showBook() {
        /* Mapが空かどうか */
        if (bookMap.isEmpty()) {
            System.out.println("IDは存在しません");
            return;
        }
        /* bookMap.values()はbookを表す */
        List<Book> list = new ArrayList<>(bookMap.values());
        list.sort((a, b) -> a.getTitle().compareTo(b.getTitle()));
        for (Book b : list) {
            System.out.println(
                    b.getId() + b.getTitle() + b.getAuthor());
        }
    }

    public void borrow(int id) {

        Book borrowBook = bookMap.get(id);
        if (bookSet.contains(id)) {
            System.out.println("貸出できません");
        } else {
            bookSet.add(id);
            System.out.println("貸出できました");
        }

    }

    public void back(int id) {
        Book backBook = bookMap.get(id);
        if (!bookSet.contains(id)) {
            System.out.println("返却済みです");
        } else {
            bookSet.remove(id);
            System.out.println("返却できました");
        }

    }

}
