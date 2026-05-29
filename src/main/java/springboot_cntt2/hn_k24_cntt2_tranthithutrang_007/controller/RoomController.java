package springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.dto.RoomRequest;
import springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.dto.RoomResponse;
import springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.service.RoomService;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public Page<RoomResponse> getRooms(
            @RequestParam(required = false) Integer roomNumber,
            @RequestParam(required = false) String roomType,
            Pageable pageable
    ) {
        return roomService.findAll(roomNumber, roomType, pageable);
    }

    @GetMapping("/{id}")
    public RoomResponse getRoomById(@PathVariable Long id) {
        return roomService.findById(id);
    }

    @PostMapping
    public RoomResponse create(@Valid @RequestBody RoomRequest request) {
        return roomService.create(request);
    }

    @PutMapping("/{id}")
    public RoomResponse update(@PathVariable Long id, @Valid @RequestBody RoomRequest request) {
        return roomService.update(id, request);
    }

    @PatchMapping("/{id}")
    public RoomResponse patch(@PathVariable Long id, @RequestBody RoomRequest request) {
        return roomService.patch(id, request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        roomService.deleteById(id);
        return "Delete room successfully";
    }
}