package com.example.bookmyevemt.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GenerateTicketRequestDto {
      private Long showId;
      private Long userId;
      private List<Long> showSeatIds;

}
