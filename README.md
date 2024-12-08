# 은행 시스템 API 가이드

이 프로젝트는 은행 시스템의 API 설계를 연습하기 위한 예제입니다. `API.md`와 `API.http` 파일을 참고하여 Controller를 작성하고, 제공된 API를 테스트할 수 있습니다.
Controller 작성 학습 이후에 전체를 구현해볼 수 있도록 설계했습니다.

---

## Guide 문서

### [API.md](API.md)
- **설명**: API 명세서로, 각 API의 URL, 요청 방식, 요청/응답 데이터 형식 등이 포함되어 있습니다.
- **참고 방법**: 이 파일을 읽고 각 API에 필요한 Controller 메서드를 설계합니다.

### [API.http](API.http)
- **설명**: IntelliJ IDEA에서 API 요청을 테스트하기 위한 HTTP 파일입니다.
- **참고 방법**:
    1. IntelliJ IDEA에서 파일을 열고 실행 가능한 요청 블록 위에 **▶** 버튼을 클릭하여 테스트합니다.
    2. 작성한 Controller와 연동된 API가 올바르게 동작하는지 확인합니다.

---

## 테스트 진행 방법

1. **Controller 설계 및 작성**
    - `API.md`의 API 명세를 기반으로 각 API에 해당하는 Controller 메서드를 작성합니다.
    - 각 Controller는 다음과 같은 역할을 수행해야 합니다:
        - **요청 데이터 처리**: 요청 본문(JSON) 또는 경로 변수에서 데이터를 받아 처리
        - **응답 생성**: 성공 또는 실패에 따라 적절한 HTTP 응답 반환

2. **API 테스트**
    - `API.http` 파일을 열고 제공된 HTTP 요청을 하나씩 실행합니다.
    - 모든 요청이 기대한 응답을 반환하면 성공입니다.
    - Controller 학습 단계에서는 DB 조회가 없기 때문에 API 명세서에 작성된 Response(응답) 데이터를 Controller에서 하드코딩으로 데이터를 넣어서 반환 하시면 됩니다.

---

## 학습 방법 2가지

1. **주석**
   - 작성한 모든 코드에 주석으로 설명을 추가합니다.
   - 구현을 완료하면 **최원빈** 튜터에게 Github 주소 or 프로젝트 zip 파일을 전달한다.
   - 피드백을 받고서 수정합니다.
2. **튜터링**
   - 구현을 완료하면 **최원빈** 튜터에게 피드백 받으러 직접 찾아갑니다.
   - 단, 주석으로 설명을 추가하지 않았으면 직접 소스코드를 말로 설명합니다.
   - 피드백을 받고 수정합니다.

다음은 `주석`의 예제입니다:

```java
@RestController // @Controller와 @ResponseBody를 결합한 애너테이션, 각 메서드가 JSON 형태의 데이터를 Client에 반환할 수 있도록 설정
@RequestMapping("/api/customers") // 클래스 혹은 메서드에 URL 경로를 공통으로 매핑하기 위해 사용되는 애너테이션, "/api/customers" 경로로 들어오는 모든 요청이 이 컨트롤러에서 처리됨
public class CustomerController {

}
```

---

## Controller 작성 예제

다음은 `고객 등록 API`의 예제입니다:

```java
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @PostMapping
    public ResponseEntity<String> registerCustomer(@RequestBody CustomerRequestDto requestDto) {
        // 요청 처리 로직 (예: 서비스 호출, 데이터 저장 등)
        // Controller 테스트 단계 임으로 API 명세서 (API.md)에서 요구한 Response 데이터를 반환
        return ResponseEntity.status(HttpStatus.CREATED).body("API 명세서 (API.md)에서 요구한 Response 데이터");
    }
}
```

## 테스트 체크리스트

- ### 고객 관리 API
  - [ ] 등록
  - [ ] 조회
  - [ ] 수정
  - [ ] 삭제

- ### 계좌 관리 API
  - [ ] 생성
  - [ ] 조회
  - [ ] 잔액 조회
  - [ ] 삭제

- ### 거래 내역 API
  - [ ] 조회
  - [ ] 생성
  - [ ] 특정 거래 조회

---
