package it.wirge.data.model;

import com.google.appengine.api.datastore.Blob;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Represents a stored image, can be used for
 * blogposts and (maybe) other things
 */

@Entity
public class StoredImage {
  @Id
  private Long idStoredImage;
  @Index
  private String nmFile;
  private Blob baBytes;
  private Integer iOriginalW;
  private Integer iOriginalH;

  public Long getIdStoredImage() {
    return idStoredImage;
  }

  public void setIdStoredImage(Long idStoredImage) {
    this.idStoredImage = idStoredImage;
  }

  public String getNmFile() {
    return nmFile;
  }

  public void setNmFile(String nmFile) {
    this.nmFile = nmFile;
  }

  public Blob getBaBytes() {
    return baBytes;
  }

  public void setBaBytes(Blob baBytes) {
    this.baBytes = baBytes;
  }

  public Integer getiOriginalW() {
    return iOriginalW;
  }

  public void setiOriginalW(Integer iOriginalW) {
    this.iOriginalW = iOriginalW;
  }

  public Integer getiOriginalH() {
    return iOriginalH;
  }

  public void setiOriginalH(Integer iOriginalH) {
    this.iOriginalH = iOriginalH;
  }
}
