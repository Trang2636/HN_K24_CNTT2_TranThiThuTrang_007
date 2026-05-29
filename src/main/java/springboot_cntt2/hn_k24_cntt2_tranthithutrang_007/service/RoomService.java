package springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.dto.RoomRequest;
import springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.dto.RoomResponse;

public interface RoomService {
    Page<RoomResponse> findAll(Integer roomNumber, String roomType, Pageable pageable);

    RoomResponse findById(Long id);

    RoomResponse create(RoomRequest request);

    RoomResponse update(Long id, RoomRequest request);

    RoomResponse patch(Long id, RoomRequest request);

    void deleteById(Long id);
}