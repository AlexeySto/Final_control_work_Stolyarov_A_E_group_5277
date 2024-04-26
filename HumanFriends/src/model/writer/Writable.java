package model.writer;

public interface Writable {
    boolean save(Object object, String fileName);
    Object load(String fileName);

}
