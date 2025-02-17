package org.example.servletproject.dto;

public class BookSearchDTO {
  private String btitle;
  private int bprice;

  public BookSearchDTO(String btitle, int bprice) {
    this.btitle = btitle;
    this.bprice = bprice;
  }

  public String getBtitle() {
    return btitle;
  }

  public int getBprice() {
    return bprice;
  }
}
