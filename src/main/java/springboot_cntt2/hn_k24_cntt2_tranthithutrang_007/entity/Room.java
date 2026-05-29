package springboot_cntt2.hn_k24_cntt2_tranthithutrang_007.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rooms")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer roomNumber;
    private String roomType;
    private Double pricePerNight;
    @Enumerated(EnumType.STRING)
    private RoomStatus status;
    private Boolean isDeleted = false;
}