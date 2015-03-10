package it.wirge.data.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Represents a stored image, can be used for
 * blogposts and (maybe) other things
 */

@Entity
public class StoredImage {
  @Id
  private Long idStoredImage;
  private String baBytes;
  private String nmAlternate;
  private String nmFile;
  private Integer iOriginalW;
  private Integer iOriginalH;

  public Long getIdStoredImage() {
    return idStoredImage;
  }

  public void setIdStoredImage(Long idStoredImage) {
    this.idStoredImage = idStoredImage;
  }

  public String getBaBytes() {
    return baBytes;
  }

  public void setBaBytes(String baBytes) {
    this.baBytes = baBytes;
  }

  public String getNmAlternate() {
    return nmAlternate;
  }

  public void setNmAlternate(String nmAlternate) {
    this.nmAlternate = nmAlternate;
  }

  public String getNmFile() {
    return nmFile;
  }

  public void setNmFile(String nmFile) {
    this.nmFile = nmFile;
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
