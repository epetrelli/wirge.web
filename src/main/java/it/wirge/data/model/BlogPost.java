package it.wirge.data.model;

import com.googlecode.objectify.annotation.Entity;

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a blog post, or a generic content page
 */

@Entity
public class BlogPost {

  private Long idBlogPost;
  private String nmTitle;
  private String nmSubtitle;
  private String nmDescription;
  private String txText;
  private ArrayList<StoredImage> storedImages;
  private Date dhCreated;
  private String nmAuthor;
  private Boolean published;

  public Long getIdBlogPost() {
    return idBlogPost;
  }

  public void setIdBlogPost(Long idBlogPost) {
    this.idBlogPost = idBlogPost;
  }

  public String getNmTitle() {
    return nmTitle;
  }

  public void setNmTitle(String nmTitle) {
    this.nmTitle = nmTitle;
  }

  public String getNmSubtitle() {
    return nmSubtitle;
  }

  public void setNmSubtitle(String nmSubtitle) {
    this.nmSubtitle = nmSubtitle;
  }

  public String getNmDescription() {
    return nmDescription;
  }

  public void setNmDescription(String nmDescription) {
    this.nmDescription = nmDescription;
  }

  public String getTxText() {
    return txText;
  }

  public void setTxText(String txText) {
    this.txText = txText;
  }

  public ArrayList<StoredImage> getStoredImages() {
    return storedImages;
  }

  public void setStoredImages(ArrayList<StoredImage> storedImages) {
    this.storedImages = storedImages;
  }

  public Date getDhCreated() {
    return dhCreated;
  }

  public void setDhCreated(Date dhCreated) {
    this.dhCreated = dhCreated;
  }

  public String getNmAuthor() {
    return nmAuthor;
  }

  public void setNmAuthor(String nmAuthor) {
    this.nmAuthor = nmAuthor;
  }

  public Boolean getPublished() {
    return published;
  }

  public void setPublished(Boolean published) {
    this.published = published;
  }
}
