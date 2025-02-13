package example.controller;


import example.service.BookService;
import example.service.BookServiceImpl;
import example.vo.BookVO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class BookController implements Initializable {

  @FXML
  private TableView<BookVO> tableView;
  @FXML
  private TableColumn<BookVO, String> bisbn;
  @FXML
  private TableColumn<BookVO, String> btitle;
  @FXML
  private TableColumn<BookVO, Integer> bprice;
  @FXML
  private TableColumn<BookVO, String> bauthor;
  @FXML
  private Button searchBtn;
  @FXML
  private Button deleteBtn;
  @FXML
  private TextField input;
  @FXML
  private TextField newBisbn;
  @FXML
  private TextField newBtitle;
  @FXML
  private TextField newBprice;
  @FXML
  private TextField newBauthor;
  @FXML
  private Button registerBtn;

  BookService bookService = new BookServiceImpl();

  public BookController() throws Exception {
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    bisbn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));
    btitle.setCellValueFactory(new PropertyValueFactory<>("btitle"));
    bprice.setCellValueFactory(new PropertyValueFactory<>("bprice"));
    bauthor.setCellValueFactory(new PropertyValueFactory<>("bauthor"));

    //수정
    tableView.setOnMouseClicked(event -> {
      tableView.setEditable(true);
    });
    bauthor.setCellFactory(TextFieldTableCell.forTableColumn());

    bauthor.setOnEditCommit(event -> { // 수정된 값 저장
      BookVO bookVO = event.getRowValue();
      bookVO.setBauthor(event.getNewValue());
      try {
        bookService.updateBook(event.getRowValue());
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    });

    // 검색
    searchBtn.setOnAction(event -> {
      String keyWord = input.getText();
      tableView.setItems(bookService.getBookByKeyWord(keyWord));
    });

    // 삭제
    deleteBtn.setOnAction(e -> {
      BookVO selectedBookVO = tableView.getSelectionModel().getSelectedItem();
      if (selectedBookVO != null) {
        try {
          String bisbn = selectedBookVO.getBisbn();
          bookService.deleteBook(bisbn); // 실제 삭제 로직 호출
          tableView.getItems().remove(selectedBookVO);
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      } else {
        System.out.println("선택된 책이 없습니다.");
      }
    });

    // 입력
    registerBtn.setOnAction(event -> {
      String isbn = newBisbn.getText().trim();
      String title = newBtitle.getText().trim();
      String priceText = newBprice.getText().trim();
      String author = newBauthor.getText().trim();

      try {
        int price = Integer.parseInt(priceText); // 가격을 숫자로 변환
        BookVO newBook = new BookVO(isbn, title, price, author); // bisbn은 자동 생성

        bookService.registerBook(newBook); // 서비스에서 처리
      } catch (IllegalStateException e) {
        showAlert("등록 실패", e.getMessage(), AlertType.WARNING);
      } catch (Exception e) {

      }
    });
  }

  private void showAlert(String title, String message, AlertType type) {
    Alert alert = new Alert(type);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }
}
