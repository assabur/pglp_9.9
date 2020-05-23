package DessinException;

public class KeyAlreadyExistException extends Exception {
  public KeyAlreadyExistException() {
    super("Une figure de ce nom existe déjà");
  }
}
