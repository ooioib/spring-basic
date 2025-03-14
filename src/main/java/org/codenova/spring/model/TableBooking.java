package org.codenova.spring.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Setter
@Getter
@ToString
public class TableBooking {

    @NotBlank // 비울 수 없음
    private String customerName;  // 예약자 명

    @Min(2) // 최소 2명 ~ 6명
    @Max(6)
    private int guests;  // 예약 인원

    @Future // 오늘 날짜 포함 (Past, Future)
    private LocalDate bookingDate;  // 예약 날짜

    @Email  // 이메일 사용 해야 함
    private String contact;  // 연락수단

    @Size(min = 1, max = 20) // 문자열 1~20자
    private String requests;  // 요청사항

}
