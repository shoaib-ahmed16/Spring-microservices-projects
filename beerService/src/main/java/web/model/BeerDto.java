package web.model;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    private UUID id;

    private Integer version;

    private OffsetDateTime createdDate;

    private OffsetDateTime lastUpdatedDate;

    private String beerName;

    private BeerStyleEnum beerStyle;

    private Long upc;

    private int price;

    private Integer quantityOnHand;


}
