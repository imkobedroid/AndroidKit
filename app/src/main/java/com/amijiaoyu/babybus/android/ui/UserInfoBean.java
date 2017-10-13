package com.amijiaoyu.babybus.android.ui;

import com.google.gson.annotations.SerializedName;

/**
 * Author:SHIHONG DONG
 * Date:2017/10/12 14:14
 * Email:imkobedroid@gmail.com
 */

public class UserInfoBean {

  /**
   * id : 1
   * name_cn : Mrs.
   * name_en :
   * head_title_name : Ms.
   * name_other :
   * edition_time : 6
   * print_time : 5
   * print_date : 2004-01-21 01:34:41
   * publish_time : 2004-01-21 01:34:41
   * page_type : 1
   * book_size : Temporibus velit.
   * sheet : Ducimus quidem.
   * price : 243.00
   * editor : Pietro Collier
   * score_time : 2003-11-02 05:00:22
   * score : 2.00
   * edition : Enim.
   * number_of_suit : 3
   * abstract : Consectetur saepe eaque officia. Dolore suscipit debitis cum. Officiis architecto velit sunt.
   * read_no : 0
   * wanted_no : 0
   * age_min : 1
   * age_max : 10
   * page_num : 100
   * word_num : 100
   * package_type : 1
   * dang_url :
   * dang_score :
   * jd_url :
   * jd_score :
   * amazon_url :
   * amazon_score :
   * douban_url :
   * douban_score :
   * book_type : 1
   * book_area : 欧美
   * isbn : fjdkajfdsakl
   * created_at : 2017-10-12 09:31:06
   * updated_at : 2017-10-12 09:31:06
   */

  private DataBean data;

  public DataBean getData() {
    return data;
  }

  public void setData(DataBean data) {
    this.data = data;
  }

  public static class DataBean {
    private int id;
    private String name_cn;
    private String name_en;
    private String head_title_name;
    private String name_other;
    private int edition_time;
    private int print_time;
    private String print_date;
    private String publish_time;
    private int page_type;
    private String book_size;
    private String sheet;
    private String price;
    private String editor;
    private String score_time;
    private String score;
    private String edition;
    private int number_of_suit;
    @SerializedName("abstract") private String abstractX;
    private int read_no;
    private int wanted_no;
    private int age_min;
    private int age_max;
    private int page_num;
    private int word_num;
    private int package_type;
    private String dang_url;
    private String dang_score;
    private String jd_url;
    private String jd_score;
    private String amazon_url;
    private String amazon_score;
    private String douban_url;
    private String douban_score;
    private int book_type;
    private String book_area;
    private String isbn;
    private String created_at;
    private String updated_at;

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getName_cn() {
      return name_cn;
    }

    public void setName_cn(String name_cn) {
      this.name_cn = name_cn;
    }

    public String getName_en() {
      return name_en;
    }

    public void setName_en(String name_en) {
      this.name_en = name_en;
    }

    public String getHead_title_name() {
      return head_title_name;
    }

    public void setHead_title_name(String head_title_name) {
      this.head_title_name = head_title_name;
    }

    public String getName_other() {
      return name_other;
    }

    public void setName_other(String name_other) {
      this.name_other = name_other;
    }

    public int getEdition_time() {
      return edition_time;
    }

    public void setEdition_time(int edition_time) {
      this.edition_time = edition_time;
    }

    public int getPrint_time() {
      return print_time;
    }

    public void setPrint_time(int print_time) {
      this.print_time = print_time;
    }

    public String getPrint_date() {
      return print_date;
    }

    public void setPrint_date(String print_date) {
      this.print_date = print_date;
    }

    public String getPublish_time() {
      return publish_time;
    }

    public void setPublish_time(String publish_time) {
      this.publish_time = publish_time;
    }

    public int getPage_type() {
      return page_type;
    }

    public void setPage_type(int page_type) {
      this.page_type = page_type;
    }

    public String getBook_size() {
      return book_size;
    }

    public void setBook_size(String book_size) {
      this.book_size = book_size;
    }

    public String getSheet() {
      return sheet;
    }

    public void setSheet(String sheet) {
      this.sheet = sheet;
    }

    public String getPrice() {
      return price;
    }

    public void setPrice(String price) {
      this.price = price;
    }

    public String getEditor() {
      return editor;
    }

    public void setEditor(String editor) {
      this.editor = editor;
    }

    public String getScore_time() {
      return score_time;
    }

    public void setScore_time(String score_time) {
      this.score_time = score_time;
    }

    public String getScore() {
      return score;
    }

    public void setScore(String score) {
      this.score = score;
    }

    public String getEdition() {
      return edition;
    }

    public void setEdition(String edition) {
      this.edition = edition;
    }

    public int getNumber_of_suit() {
      return number_of_suit;
    }

    public void setNumber_of_suit(int number_of_suit) {
      this.number_of_suit = number_of_suit;
    }

    public String getAbstractX() {
      return abstractX;
    }

    public void setAbstractX(String abstractX) {
      this.abstractX = abstractX;
    }

    public int getRead_no() {
      return read_no;
    }

    public void setRead_no(int read_no) {
      this.read_no = read_no;
    }

    public int getWanted_no() {
      return wanted_no;
    }

    public void setWanted_no(int wanted_no) {
      this.wanted_no = wanted_no;
    }

    public int getAge_min() {
      return age_min;
    }

    public void setAge_min(int age_min) {
      this.age_min = age_min;
    }

    public int getAge_max() {
      return age_max;
    }

    public void setAge_max(int age_max) {
      this.age_max = age_max;
    }

    public int getPage_num() {
      return page_num;
    }

    public void setPage_num(int page_num) {
      this.page_num = page_num;
    }

    public int getWord_num() {
      return word_num;
    }

    public void setWord_num(int word_num) {
      this.word_num = word_num;
    }

    public int getPackage_type() {
      return package_type;
    }

    public void setPackage_type(int package_type) {
      this.package_type = package_type;
    }

    public String getDang_url() {
      return dang_url;
    }

    public void setDang_url(String dang_url) {
      this.dang_url = dang_url;
    }

    public String getDang_score() {
      return dang_score;
    }

    public void setDang_score(String dang_score) {
      this.dang_score = dang_score;
    }

    public String getJd_url() {
      return jd_url;
    }

    public void setJd_url(String jd_url) {
      this.jd_url = jd_url;
    }

    public String getJd_score() {
      return jd_score;
    }

    public void setJd_score(String jd_score) {
      this.jd_score = jd_score;
    }

    public String getAmazon_url() {
      return amazon_url;
    }

    public void setAmazon_url(String amazon_url) {
      this.amazon_url = amazon_url;
    }

    public String getAmazon_score() {
      return amazon_score;
    }

    public void setAmazon_score(String amazon_score) {
      this.amazon_score = amazon_score;
    }

    public String getDouban_url() {
      return douban_url;
    }

    public void setDouban_url(String douban_url) {
      this.douban_url = douban_url;
    }

    public String getDouban_score() {
      return douban_score;
    }

    public void setDouban_score(String douban_score) {
      this.douban_score = douban_score;
    }

    public int getBook_type() {
      return book_type;
    }

    public void setBook_type(int book_type) {
      this.book_type = book_type;
    }

    public String getBook_area() {
      return book_area;
    }

    public void setBook_area(String book_area) {
      this.book_area = book_area;
    }

    public String getIsbn() {
      return isbn;
    }

    public void setIsbn(String isbn) {
      this.isbn = isbn;
    }

    public String getCreated_at() {
      return created_at;
    }

    public void setCreated_at(String created_at) {
      this.created_at = created_at;
    }

    public String getUpdated_at() {
      return updated_at;
    }

    public void setUpdated_at(String updated_at) {
      this.updated_at = updated_at;
    }
  }
}
