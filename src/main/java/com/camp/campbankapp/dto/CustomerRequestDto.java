package com.camp.campbankapp.dto;
/*
 * DTO(Data Transfer Object, 데이터 전송 객체) 프로세스 간의 데이터를 전달하는 객체
 * 전달하고 싶은 데이터만 담김
 * requestDto : 클라이언트에서 서버로 데이터 전달 시 사용되는 객체
 * HTTP 요청의 본문(body), URL 파라미터, 쿼리 파라미터 등을 통해 전달되는 데이터 캡슐화
 * 클라이언트에서 서버로 보내는 요청 데이터를 명확히 정의
 * 데이터의 구조와 유효성을 관리하기 쉬워짐
 * 요청 데이터를 검증(validation)하기 용이
 */
import lombok.Getter;

/**
 * Lombok : 보일러 플레이트 코드(getter/setter 메서드, 생성자, toString 메서드 등과 같이 반복적으로 작성되는 코드)
* 자동으로 보일러 플레이트 코드를 생성하여 코드의 가독성과 유지보수성을 높여준다.
* 어노테이션 기반으로 동작하며 주로 컴파일 시점에 소스 코드를 변화하여 필요한 메서드를 자동 생성
* 클래스의 모든 필드에 대한 getter 메서드를 자동으로 생성
* getName(), getEmail(), getPhone(), getAddress() 메서드 자동 생성
*/
@Getter
public class CustomerRequestDto {

    private final String name;
    private final String email;
    private final String phone;
    private final String address;

    public CustomerRequestDto(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}

/*
* Dto 의 필요성
* 데이터 캡슐화: 클라이언트와 서버 간 데이터를 객체로 구조화하여 코드 가독성과 유지보수성 높이기
* 데이터 검증: RequestDto에 validation annotation을 적용하여 입력 데이터를 서버에서 검증하기 용이함
* 보안 강화: ResponseDto를 통해 서버의 내부 엔티티(Entity)를 직접 노출하지 않고 필요한 데이터만 전달
* 유지보수성 향상: 요청(Request)과 응답(Response)에 대한 명확한 데이터 모델이 있어, API를 이해하거나 변경 시 용이
* 일관성 유지: API의 요청과 응답 데이터 구조를 표준화하여 개발자 간 협업 시 혼란을 줄이고, 클라이언트-서버 간 통신을 안정적으로 유지
*/
