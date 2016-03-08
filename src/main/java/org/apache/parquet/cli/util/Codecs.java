package org.apache.parquet.cli.util;

import org.apache.avro.file.CodecFactory;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;

import java.util.Locale;

public class Codecs {
  public static CompressionCodecName parquetCodec(String codec) {
    try {
      return CompressionCodecName.valueOf(codec.toUpperCase(Locale.ENGLISH));
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Unknown compression codec: " + codec);
    }
  }

  public static CodecFactory avroCodec(String codec) {
    CompressionCodecName parquetCodec = parquetCodec(codec);
    switch (parquetCodec) {
      case UNCOMPRESSED:
        return CodecFactory.nullCodec();
      case SNAPPY:
        return CodecFactory.snappyCodec();
      case GZIP:
        return CodecFactory.deflateCodec(9);
      default:
        throw new IllegalArgumentException(
            "Codec incompatible with Avro: " + codec);
    }
  }
}
