package org.example.servletproject.vo;

public class Book {
  private String bisbn;
  private String btitle;
  private int bprice;

  private String bauthor;



  public Book(){
  }
  public Book(String bisbn, String btitle, int bprice) {
    this.bisbn = bisbn;
    this.btitle = btitle;
    this.bprice = bprice;;
  }
  public Book(String bisbn, String btitle, int bprice,String bauthor) {
    this.bisbn = bisbn;
    this.btitle = btitle;
    this.bprice = bprice;
    this.bauthor = bauthor;
  }

  public String getBisbn() {
    return bisbn;
  }

  public void setBisbn(String bisbn) {
    this.bisbn = bisbn;
  }

  public String getBtitle() {
    return btitle;
  }

  public String getBauthor() {
    return bauthor;
  }

  public void setBtitle(String btitle) {
    this.btitle = btitle;
  }


  public int getBprice() {
    return bprice;
  }

  public void setBprice(int bprice) {
    this.bprice = bprice;
  }

}

