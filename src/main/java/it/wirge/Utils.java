package it.wirge;

import java.text.Normalizer;

/**
 * Created by enricopetrelli on 10/03/15.
 */
public class Utils {

  public static String toPrettyURL(String sIn, String sExtension){
    String sOut = Normalizer.normalize(sIn.toLowerCase(), Normalizer.Form.NFD)
      .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
      .replaceAll("[^\\p{Alnum}]+", "-")
      .replaceAll("[^a-z0-9]+$", "")
      .replaceAll("^[^a-z0-9]+", "");
    sOut += (sExtension!=null?"." + sExtension:"");
    return sOut;
  }

}
