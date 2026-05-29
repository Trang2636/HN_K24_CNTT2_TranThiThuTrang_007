package springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.dto.RoomRequest;
import springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.dto.RoomResponse;
import springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.entity.Room;
import springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.entity.RoomStatus;
import springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.exception.RoomNotFoundException;
import springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.repository.RoomRepository;
import springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.service.RoomService;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Override
    public Page<RoomResponse> findAll(Integer roomNumber, String roomType, Pageable pageable) {
        if (roomNumber != null) {
            return roomRepository.findByRoomNumberAndIsDeletedFalse(roomNumber, pageable)
                    .map(this::toResponse);
        }

        if (roomType != null && !roomType.isBlank()) {
            return roomRepository.findByRoomTypeContainingIgnoreCaseAndIsDeletedFalse(roomType, pageable)
                    .map(this::toResponse);
        }

        return roomRepository.findByIsDeletedFalse(pageable)
                .map(this::toResponse);
    }

    @Override
    public RoomResponse findById(Long id) {
        Room room = getRoomById(id);
        return toResponse(room);
    }

    @Override
    public RoomResponse create(RoomRequest request) {
        Room room = Room.builder()
                .roomNumber(request.getRoomNumber())
                .roomType(request.getRoomType())
                .pricePerNight(request.getPricePerNight())
                .status(request.getStatus() == null ? RoomStatus.AVAILABLE : request.getStatus())
                .isDeleted(false)
                .build();

        return toResponse(roomRepository.save(room));
    }

    @Override
    public RoomResponse update(Long id, RoomRequest request) {
        Room room = getRoomById(id);

        room.setRoomNumber(request.getRoomNumber());
        room.setRoomType(request.getRoomType());
        room.setPricePerNight(request.getPricePerNight());
        room.setStatus(request.getStatus() == null ? room.getStatus() : request.getStatus());

        return toResponse(roomRepository.save(room));
    }

    @Override
    public RoomResponse patch(Long id, RoomRequest request) {
        Room room = getRoomById(id);

        if (request.getRoomNumber() != null) {
            room.setRoomNumber(request.getRoomNumber());
        }

        if (request.getRoomType() != null && !request.getRoomType().isBlank()) {
            room.setRoomType(request.getRoomType());
        }

        if (request.getPricePerNight() != null) {
            room.setPricePerNight(request.getPricePerNight());
        }

        if (request.getStatus() != null) {
            room.setStatus(request.getStatus());
        }

        return toResponse(roomRepository.save(room));
    }

    @Override
    public void deleteById(Long id) {
        Room room = getRoomById(id);
        room.setIsDeleted(true);
        roomRepository.save(room);
    }

    private Room getRoomById(Long id) {
        return roomRepository.findById(id)
                .filter(room -> !room.getIsDeleted())
                .orElseThrow(() -> new RoomNotFoundException(id));
    }

    private RoomResponse toResponse(Room room) {
        return RoomResponse.builder()
                .id(room.getId())
                .roomNumber(room.getRoomNumber())
                .roomType(room.getRoomType())
                .pricePerNight(room.getPricePerNight())
                .status(room.getStatus())
                .build();
    }
}