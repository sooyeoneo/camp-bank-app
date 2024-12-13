package com.camp.campbankapp.controller;

import com.camp.campbankapp.dto.CustomerRequestDto;
import com.camp.campbankapp.dto.CustomerResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller 에 @ResponseBody 가 결합된 어노테이션 : 응답 데이터를 반환
@RestController // @Controller 와 달리 각 메서드 마다 @ResponseBody 를 추가하지 않아도 됨
@RequestMapping("/api/customers") // 특정 URL 로 Request 를 보내면 들어온 요청을 Controller 내부의 특정 Method 와 Mapping 을 위해 사용
public class CustomerController {

    // 고객 등록 : 클라이언트가 "/api/customers"로 POST 요청
    @PostMapping // HTTP POST 요청을 처리 - 서버에 새로운 리소스 생성, 클라이언트가 서버로 데이터 보낼 때 body 에 데이터 포함
    public ResponseEntity<CustomerResponseDto> registerCustomer(
            @RequestBody CustomerRequestDto requestDto, // 클라이언트가 보낸 데이터를 CustomerRequestDto 로 Mapping
            HttpServletRequest request,
            HttpServletResponse response) {

        // 요청 처리 로직 - 서비스 호출, 데이터 저장 -> 서비스 없이 하드 코딩
        // CustomerResponseDto 를 생성하여 responseDto 에 하드 코딩된 값을 넣어줌
        CustomerResponseDto responseDto = new CustomerResponseDto( // 새로운 고객 생성
                1L, // customerId
                "Robbie", // customerName
                "Robbie@example.com", // customerEmail
                "010-1234-5678", // customerPhone
                "123 Seoul" // customerAddress
        );

        // Controller 테스트 단계임으로 API 명세서에서 요구한 Response 데이터 반환
        // 요청 성공시 상태 코드 201 반환
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    // 고객 조회 : URL "/api/customers/{customerId}" 고객 아이디를 기준으로 조회 (특정 아이디로 조회, 수정, 삭제 가능)
    @GetMapping("/{customerId}") // 서버로부터 데이터를 조회할 때 사용 - 경로 변수를 통해 데이터 전달
    public ResponseEntity<CustomerResponseDto> getCustomer(@PathVariable Long customerId) {

        // 하드 코딩된 고객 데이터를 응답을 반환
        CustomerResponseDto responseDto = new CustomerResponseDto(
                1L,
                "Robbie",
                "Robbie@example.com",
                "010-1234-5678",
                "123 Seoul"
        );
        return ResponseEntity.ok(responseDto); // 요청 성공 시 상태 코드 200 반환
    }

    // 고객 정보 수정 : URL "/api/customers/{customerId}" 서버가 고객의 아이디를 기준으로 해당 고객의 모든 데이터를 요청 본문에 따라 업데이트
    @PutMapping("/{customerId}") // HTTP PUT 요청을 처리 - 서버에 기존 리소스를 전체 수정할 때 사용(일부 수정은 @PatchMapping)
    // 수정할 데이터 body 에 포함
    public ResponseEntity<CustomerResponseDto> updateCustomer(
            HttpServletRequest request, // 요청 객체
            HttpServletResponse response, // 응답 객체
            @RequestBody CustomerRequestDto requestDto // 수정할 데이터를 요청 본문에서 전달 받음
    ) {
        // 하드 코딩된 수정된 고객 데이터를 응답으로 반환
        CustomerResponseDto responseDto = new CustomerResponseDto(
                1L,
                "Lucia",
                "Lucia@example.com",
                "010-9876-5321",
                "132 Seoul"
        );
        return ResponseEntity.ok(responseDto); // 요청 성공 시 상태 코드 200 반환
    }

    // 고객 삭제 : URL "/api/customers/{customerId}" 로 Delete 요청을 보내면 서버는 해당 Id에 해당하는 고객 삭제
    @DeleteMapping("/{customerId}") // HTTP DELETE 요청을 처리 - 서버에 리소스를 삭제할 때 사용, 경로 변수로 삭제할 대상 식별 (ex. Id)
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
        // 삭제 완료 후 상태코드 204 반환
        return ResponseEntity.noContent().build();
    }
}
