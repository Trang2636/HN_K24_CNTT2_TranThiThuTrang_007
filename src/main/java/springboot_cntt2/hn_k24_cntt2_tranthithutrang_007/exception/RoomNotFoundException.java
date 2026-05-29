package springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.exception;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(Long id) {
        super("Room with id " + id + " not found");
    }
}