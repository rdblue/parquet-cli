package org.apache.parquet.cli.util;

/**
 * Exception to signal that a record could not be read or written.
 */
public class RecordException extends RuntimeException {
  public RecordException(String message) {
    super(message);
  }

  public RecordException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Precondition-style validation that throws a {@link RecordException}.
   *
   * @param isValid
   *          {@code true} if valid, {@code false} if an exception should be
   *          thrown
   * @param message
   *          A String message for the exception.
   */
  public static void check(boolean isValid, String message, Object... args) {
    if (!isValid) {
      String[] argStrings = new String[args.length];
      for (int i = 0; i < args.length; i += 1) {
        argStrings[i] = String.valueOf(args[i]);
      }
      throw new RecordException(
          String.format(String.valueOf(message), (Object[]) argStrings));
    }
  }
}
