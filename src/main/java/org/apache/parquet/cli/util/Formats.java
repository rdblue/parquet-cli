package org.apache.parquet.cli.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Formats {
  public enum Format {
    PARQUET,
    AVRO,
    SEQUENCE,
    TEXT
  }

  public static Format detectFormat(InputStream stream) throws IOException {
    byte[] first3 = new byte[3];
    stream.read(first3);
    if (Arrays.equals(first3, new byte[]{'P', 'A', 'R'})) {
      return Format.PARQUET;
    } else if (Arrays.equals(first3, new byte[]{'O', 'b', 'j'})) {
      return Format.AVRO;
    } else if (Arrays.equals(first3, new byte[]{'S', 'E', 'Q'})) {
      return Format.SEQUENCE;
    } else {
      return Format.TEXT;
    }
  }
}
