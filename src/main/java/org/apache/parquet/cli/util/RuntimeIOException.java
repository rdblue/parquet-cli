package org.apache.parquet.cli.util;

import java.io.IOException;

/**
 * RuntimeException wrapper for IOExceptions
 */
public class RuntimeIOException extends RuntimeException {
  public RuntimeIOException(String message, IOException cause) {
    super(message, cause);
  }
}
