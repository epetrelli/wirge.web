package it.wirge.data.model;

import com.google.appengine.api.datastore.Text;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.Date;

/**
 * Represents a blog post, or a generic content page
 */

@Entity
public class BlogPost {

  @Id
  private Long idBlogPost;
  @Index
  private String ulLink;

  private String nmTitle;
  private String nmSubtitle;
  private String nmDescription;
  private Text txText;
  private Date dhCreated;
  private String nmAuthor;
  private Boolean published;

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
}
