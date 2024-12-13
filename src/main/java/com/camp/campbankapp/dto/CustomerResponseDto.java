package com.camp.campbankapp.dto;
/*
* DTO(Data Transfer Object, 데이터 전송 객체) 프로세스 간의 데이터를 전달하는 객체
* 전달하고 싶은 데이터만 담김
* responseDto : 서버에서 클라이언트로 데이터를 전달할 때 사용되는 객체
* 서버가 클라이언트로 반환하는 데이터를 명확히 정의
* 필요한 데이터만 포함하여 불필요한 정보를 숨길 수 있음(보안 및 효율성)
* API 응답의 일관성을 유지하기 쉬움
*/
import lombok.Getter;

@Getter
public class CustomerResponseDto {

    private final Long id;
    private final String name;
    private final String email;
    private final String phone;
    private final String address;

    public CustomerResponseDto(Long id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}
