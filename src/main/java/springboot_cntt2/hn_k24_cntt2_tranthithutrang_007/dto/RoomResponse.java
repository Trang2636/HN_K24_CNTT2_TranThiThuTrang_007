package springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.dto;

import lombok.*;
import springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.entity.RoomStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RoomResponse {
    private Long id;
    private Integer roomNumber;
    private String roomType;
    private Double pricePerNight;
    private RoomStatus status;
}