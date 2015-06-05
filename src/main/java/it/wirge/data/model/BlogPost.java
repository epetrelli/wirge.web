package it.wirge.data.model;

import com.google.appengine.api.datastore.Text;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents a blog post, or a generic content page;
 * storedImage is the main image,
 * storedImageS represents the image gallery
 */

@Entity
public class BlogPost {

  @Id
  private Long idBlogPost;
  @Index
  private String ulLink;
  @Index
  private Date dhCreated;

  private String nmTitle;
  private String nmSubtitle;
  private String nmDescription;
  private Text txText;
  private String nmAuthor;
  private Boolean published;
  private StoredImage storedImage;
  private List<StoredImage> storedImages = new ArrayList<>();

  public Long getIdBlogPost() {
    return idBlogPost;
  }

  public void setIdBlogPost(Long idBlogPost) {
    this.idBlogPost = idBlogPost;
  }

  public String getUlLink() {
    return ulLink;
  }

  public void setUlLink(String ulLink) {
    this.ulLink = ulLink;
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

  public Text getTxText() {
    return txText;
  }

  public void setTxText(Text txText) {
    this.txText = txText;
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

  public StoredImage getStoredImage() {
    return storedImage;
  }

  public void setStoredImage(StoredImage storedImage) {
    this.storedImage = storedImage;
  }

  public List<StoredImage> getStoredImages() {
    return storedImages;
  }

  public void setStoredImages(List<StoredImage> storedImages) {
    this.storedImages = storedImages;
  }
}
