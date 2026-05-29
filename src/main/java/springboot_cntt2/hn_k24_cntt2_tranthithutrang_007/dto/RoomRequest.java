package springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.entity.RoomStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RoomRequest {
    @NotNull(message = "Room number không được để trống")
    private Integer roomNumber;

    @NotBlank(message = "Room type không được để trống")
    private String roomType;

    @NotNull(message = "Price per night không được để trống")
    @Positive(message = "Price per night phải lớn hơn 0")
    private Double pricePerNight;

    private RoomStatus status;
}