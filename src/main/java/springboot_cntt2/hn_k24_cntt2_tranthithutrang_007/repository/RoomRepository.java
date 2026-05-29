package springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Page<Room> findByIsDeletedFalse(Pageable pageable);

    Page<Room> findByRoomNumberAndIsDeletedFalse(Integer roomNumber, Pageable pageable);

    Page<Room> findByRoomTypeContainingIgnoreCaseAndIsDeletedFalse(String roomType, Pageable pageable);
}