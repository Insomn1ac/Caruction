package org.intensive.caruction.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuctionDTO {

    @NotNull
    private LocalDateTime startDate;

    @NotNull
    private LocalDateTime endDate;


    private String description;
}
