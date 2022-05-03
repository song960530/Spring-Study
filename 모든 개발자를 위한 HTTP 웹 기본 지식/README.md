# 모든 개발자를 위한 HTTP 웹 기본 지식

## IP(인터넷 프로토콜)
- 지정한 IP 주소(IP Address)에 데이터 전달
- 패킷이라는 단위로 데이터를 전달


## IP 프로토콜의 한계
- 비연결성
  - 패킷을 받을 상대가 없는 상태여도 전송이 됨
- 비신뢰성
  - 중간에 만약 전달해주는 서버에 문제가 생겼을 경우 소실될 수 있다
  - 대략 1500바이트가 넘으면 패킷을 나눠서 보내게 되는데 이 과정에서 보낸 순서대로 도착하지 않을 수 있다
- 프로그램 구분
  - 같은 IP를 사용하넌 서버에서 통신하는 어플리케이션이 둘 이상이라면?(포트를 지정하지 않음)




## 인터넷 프로토콜 스택의 4계층
![4계층](https://user-images.githubusercontent.com/52727315/166098309-ed196831-a78d-43c0-8d1d-55f27fb11058.png)


## 프로토콜 계층(TCP 버전)
![프로토콜 계층(TCP)](https://user-images.githubusercontent.com/52727315/166098352-57f66fdc-ab75-4f98-8093-445f5497bfdb.png)

## TCP의 특징
- 전송 제어 프로토콜(Transmission Control Protocol)
- 연결지향 - TCP 3 way handshake(가상 연결)
  - 1.SYN(출발지 -> 목적지로 접속 요청)
  - 2.SYN+ACK(목적지 -> 출발지로 요청 수락,접속 요청)
  - 3.ACK(출발지 -> 목적지로 요청 수락 및 데이터 전송)
- 데이터 전달 보증
  - 출발지에서 목적지로 데이터를 전송하였을 때 목적지에서 정상적으로 수신하였다면 수신했다는것을 알려준다
- 순서 보장
  - 출발지에서 패킷1,2,3 순서대로 전달하였는데 목적지엔 패킷1,3,2 순서로 도착하였다면 패킷2부터 다시 보내도록 재요청을한다
- 신뢰할 수 있는 프로토콜
- 현재 대부분 TCP사용

## UDP 특징
- 사용자 데이터그램 프로토콜(User Datagram Protocol)
- 기능이 거의 없다
- TCP 3 way handshake를 지원하지 않는다
- 데이터 전달을 보증하지 않는다
- 순서를 보장하지 않는다
- 단순하며 빠르다
- 단순 IP 프로토콜과 거의 같고 + PORT + 체크썸 정도만 추가되었다
- 다만 최근들어 HTTP3에서는 단순하고 빠른 통신이 가능한 UDP 방식으로 통신을 하도록 지원하고 있다



## PORT
- 같은 IP내에서 프로세스 구분
- 0 ~ 65535까지 할당 가능
  - 0 ~ 1023 -> 잘 알려져있는 포트라 사용하지 않는것이 좋다
  - FTP -> 20, 21
  - TELNET -> 23
  - HTTP -> 80
  - HTTPS -> 443



## DNS
- 도메인 네임 시스템(Domain Name System)
- 전화번호부 같은 역할을 한다
- 도메인명을 IP주소로 변경해준다(DNS서버에 등록되어 있어야 함)



## URI? URL? URN?
- URI (Uniform Resource Identifier)
- URL (Uniform Resource Locator)
  - scheme://[userinfo@]host[:port][/path][?query][#fragment]
  - https://www.google.com:443/search?q=hello&hi=ko
- URN (Uniform Resource Name)
- 간단하게 이야기하자면 URI안에 URL과 URN이 포함되어 있고, 우리가 흔히 웹브라우져에서 사용하는 주소가 URL이다
  - URL: foo://example.com:8080/over/there?name=ferret#nose
  - URN: urn:example:animal:ferret:nose
  - URN 이름만으론 실제 리소스를 찾을 수 있는 방법이 보편화되어 있지 않아 거의 사용하지 않는다



## HTTP (HyperText Transfer Protocol)
- 데이터를 주고 받을 때 사용 (거의 모든 형태의 데이터 전송 가능)
![HTTP구조](https://user-images.githubusercontent.com/52727315/166106722-356218d9-f1a1-4019-b0d2-a8f06edd7b36.png)
- HTTP 메세지 구조
  - 시작라인: HTTP 메서드, 요청 대상, HTTP 버전
  - 헤더: HTTP 전송에 필요한 모든 부가 정보, 메세지 바디 크기, 압축, 인증, 브라우저 정보 등등..
  - 바디: 실제 전송할 데이터. HTML, 이미지, 영상, JSON 등등 byte로 표현 가능한 모든 데이터 전송 가능
- ✨무상태 프로토콜(Stateless)✨
  - 서버가 클라이언트의 상태를 보존하지 않는다 (서버 확장성이 높음_스케일아웃)
  - 클라이언트의 요청을 처리하는 서버가 중간에 변경되더라도 응답이 가능하다
  - 무한한 서버 증설이 가능하다
  - 반대 의미로 상태유지(Stateful)가 있다. 상태유지의 경우 처리하는 서버가 변경되면 안된다.
- 비연결성
  - 클라이언트와 서버간의 연결 유지를 하지 않아 최소한의 자원을 사용한다
  - 초단위 이하의 빠른 속도로 응답한다
  - 서버 자원을 효율적으로 사용할 수 있다
  - 초창기엔 모든 요청마다 연결의 끊고 맺음이 이뤄져서 TCP/IP 연결을 새로 맺는 방식이였으나  
현재는 지속 연결(Persistent Connections)로 문제를 해결하였다
    - 한번의 맺음안에 여러 요청과 응답을 처리하고 맺음을 끊는 방식



## 좋은 URI 설계🧐
- ✨URI설계에서 제일 중요한건 리소스 식별이다
- ✨URI는 리소스와 행위를 분리하여 리소스만 식별한다
  - 리소스 : 회원
  - 행위: 조회, 등록, 삭제, 변경
  - 주로 리소스는 명사, 행위는 동사
- ✨API URI설계는 리소스를 식별하고 계층적 구조로 설계한다
  - ✔계층 구조상 상위를 컬렉션으로 보고 복수단어 사용 권장(member -> members)
  - 회원 목록 조회 /members
  - 회원 조회 /members/{id}
  - 회원 등록 /members/{id}
  - 회원 수정 /members/{id}
  - 회원 삭제 /members/{id}
- 행위는 Http 메서드를 사용하여 구분짓도록 한다


## HTTP 주요 메서드🧐
- GET: 리소스 조회
  - Query(쿼리 파라미터, 쿼리 스트링)을 통하여 서버에 데이터를 전달
  - 메세지 바디를 사용해서 전달은 가능하지만 지원하는 한정적이라 권장하지 않는다
- ✨POST: 요청 데이터 처리
  - 메세지 바디를 통해 서버에 데이터 전달
  - 주로 신규 리소스 등록 또는 프로세스 처리에 사용한다
    - 프로세스 처리에서 사용한다는 의미는 예를들어 결제가 완료되었을 때 사장이 배달시작 버튼을 눌러 프로세스의 상태가 변경되야 하는 경우를 말한다  
    EX) POST /orders/{orderId}/start-delivery  
    (URI설계시 리소스로 식별하는게 베스트지만 그렇지 못할 경우 위와 같이 컨트롤URI 라는 방식으로 설계를 한다)
    - POST의 결과로 새로운 리소스가 생성되지 않을 수 도 있다
  - ✔추가적으로 다른 메서드로 처리하기 애매한 경우에도 사용한다
    - 메세지 바디에 데이터를 담아서 GET메서드를 사용해야하는데 어려울 경우
    - HTTP 메서드 선택이 애매할 경우  
- PUT: 리소스 대체
  - 리소스가 있으면 대체, 없으면 생성(덮어씌우는 개념)
- PATCH: 리소스 부분 변경
- DELETE: 리소스 삭제
- 그 외 기타 메서드
  - HEAD: GET과 동일하지만 상태줄과 헤더만 반환
  - OPTIONS: 대상 리소스에 대한 통신 가능 옵션을 설명(주로 CORS에서 사용)
  - CONNECT: 대상 자원으로 식별되는 서버에 대한 터널을 설정
  - TRACE: 대상 리소스에 대한 경로를 따라 메세지 루프백 테스트 수행




## HTTP 메서드 속성
![HTTP메서드속성](https://user-images.githubusercontent.com/52727315/166140493-5b20715c-919e-4120-8156-4345c8786f0c.png)
- 안전(Safe Methods)
  - 지속적인 호출을 하여도 리소스가 변경되지 않는다
- 멱등(Idempotent Methods)
  - f(f(x)) == f(x)
  - 한번호출하든 여러번 호출하든 결과가 똑같다
    - POST: 결제같은 프로세스를 여러번 호출하면 중복현상이 발생할 수 있다
    - PATCH: 리소스의 일부를 변경하는 부분이 중요한데, count = 1 이라는 데이터를 보냈을 때 count를 1로 변경할 수도 있고 count+=1로 변경할 수 있어서 결과가 다를 수 있다
- 캐시가능(Cacheable Methods)
  - 응답 결과 리소스를 캐시해서 사용해도 되는가
  - POST, PATCH는 본문 내용까지 캐시 키로 고려해야 하는데, 구현이 쉽지 않다




## HTTP API 활용
- HTTP API 
  - 컬렉션
    - POST 기반 등록
    - 서버가 리소스 URI를 결정 EX) POST /files
  - 스토어
    - PUT 기반 등록
    - 클라이언트가 리소스 URI를 결정 EX) PUT /files/star.jpg
  - HTML FORM
    - 순수 HTML + HTML FORM을 사용
    - GET,POST 메서드만 지원




## 참고하면 좋은 URI 설계 개념
- 문서(document)
  - 단일 개념
  - EX) /members/100, /files/star.jpg
- 컬렉션(Collection)
  - 서버가 관리하는 리소스 디렉토리
  - 서버가 리소스의 URI를 생성하고 관리
  - EX) POST /members
- 스토어(store)
  - 클라이언트가 관리하는 자원 저장소
  - 클라이언트가 리소스의 URI를 알고 관리
  - EX) PUT /files/star.jpg
- 컨트롤 URI
  - 문서, 컬렉션, 스토어로 해결하기 어려운 추가 프로세스 실행 
  - 동사를 직접 사용
  - EX) DELETE /members/100/delete




## HTTP 상태 코드
- 1xx(Informational): 요청이 수신되어 처리되는 중
- 2xx(Successful): 요청이 정상 처리 됨
  - 200: OK. 요청 성공
  - 201: Created. 요청을 성공하였고 새로운 리소스가 생성됨. 생성된 리소스는 Response의 Location헤더 필드로 식별
  - 202: Accepted. 요청은 접수되었으나 처리가 완료되지 않았을때. 특정 시간 뒤에 완료되는 경우
  - 204: No Content. 요청을 정상 수행하였지만 보낼 데이터가 없을 경우
- 3xx(Redirection): 요청을 완료하려면 추가 행동이 필요
  - 300: Multiple Choices.
  - 301: Moved Permanently. 리다이렉트시 요청 메서드가 GET으로 변하고, 본문이 제거될 수 있음
  - 302: Found. 리다이렉트시 요청 메서드가 GET으로 변하고, 본문이 제거될 수 있음
  - 303: See Other. 리다이렉트시 요청 메서드가 GET으로 변경
  - 304: Not Modified. 클라이언트에게 리소스가 수정되지 않았음을 알려준다. 따라서 클라이언트는 로컬PC에 저장된 캐시를 재사용한다
  - 307: Temporary Redirect. 리다이렉트시 요청 메서드와 본문 유지
  - 308: Permanent Redirect. 리다이렉트시 요청 메서드와 본문 유지
  - ✔PS. 자동 리다이렉션시 GET으로 변해도 되면 보통 302를 사용한다. 이미 많은 어플리케이션 라이브러리에서 302를 기본값으로 사용
- 4xx(Client Error): 클라이언트 오류. 잘못된 요청으로 서버가 수행할 수 없음
  - 400: Bad Request. 클라이언트가 잘못된 요청을 하였을 경우
  - 401: Unauthorized. 해당 리소스에 대한 인증이 필요할 경우
  - 403: Forbidden. 접근 권한이 불충분할 경우
  - 404: Not Found. 요청 리소스가 서버에 없을 경우
- 5xx(Server Error): 서버오류. 정상적인 요청을 서버가 처리하지 못함
  - 500: Internal Server Error. 서버 내부 문제
    - ✔클라이언트가 약속된 정상적인 요청을 하였는데도 불구하고 발생한 오류일경우 500을 사용해야 한다. 무분별하게 사용하면 클라이언트에게 혼란만 주기 때문이다  
    만약 비즈니스로직은 정상 수행되었으나 결과가 예상과 상이할 경우 200+비즈니스코드(봉투패턴), API 스펙을 만족하지 못하였을경우 400을 반환하도록 한다
  - 503: Service Unavailable. 서버가 과부화나 작업으로 인해 요청을 처리할 수 없는 경우






## 리다이렉션 
- 웹브라우저는 3xx 응답의 결과에 Location 헤더가 있으면 해당 위치로 자동 리다이렉트
- 영구 리다이렉션
  - 특정 리소스의 URI가 영구적으로 이동
  - EX) /members -> /users
  - 상태코드론 301, 308이 있다
    - 301: 리다이렉트시 요청 메서드가 GET으로 변경됨. 본문이 제거될 수 있음
    - 308: 리다이렉트시 요처 메서드와 본문이 유지됨
- 일시 리다이렉션
  - 일시적인 변경
  - EX) 주문 완료 후 주문 내역 화면으로 이동
  - PRG
    - Post/Redirect/Get의 약자
    - POST 메서드가 호출되고난뒤에 새로고침을하면 다시 POST 메서드가 호출되어 중복처리될 가능성이 있는 문제를 피하고자  
    중요 로직에서 POST 메서드 호출이후엔 GET 메서드로 리다이렉트 시켜 방지한다
  - 상태코드론 302, 303, 307이 있다
    -  302: 리다이렉트시 요청 메서드가 GET으로 변하고 본문이 제거될 수 있음
    -  303: 리다이렉트시 요청 메서드와 본문이 유지됨
    -  307: 리다이렉트시 요청 메서드가 GET으로 변경
- 특수 리다이렉션
  - 결과 대신 캐시를 사용





## Http-Header🧐
![HTTP HEADER](https://user-images.githubusercontent.com/52727315/166403007-8e3c70a1-2182-4775-a620-a3af138d21f4.png)
- RFC7230(최신 스펙)
- 메세지 Body를 통해 표현 데이터를 전달하며 메세지 Body == 페이로드(payload)와 동일하다
- 표현은 요청이나 응답에서 전달할 실제 데이터이다
  - 표현(Representation) = 표현 메타데이터 + 표현 데이터.
  - 이전 스펙에선 엔티티(Entity)라 불렸었음
- 표현 헤더는 표현 데이터를 해석할 수 있는 정보를 제공한다



## 표현의 구성
- Content-Type: 표현 데이터의 형식
  - 미디어타입, 문자 인코딩
  - EX) text/html; charset=utf-8, application/json, image/png...
- Content-Encoding: 표현 데이터의 압축 방식
  - 표현 데이터를 압축하기 위하여 사용
  - 데이터를 읽는 쪽에서 인코딩 헤더의 정보로 압축 해제
  - EX) gzip, deflate, identity
- Content-Language: 표현 데이터의 자연 언어
  - 표현 데이터의 자연 언어를 표현
  - EX) ko, en, en-US
- Content-Length: 표현 데이터의 길이
  - 바이트 단위
  - Transfer-Encoding(전송코딩)을 사용하면 Content-Lencth를 사용하면 안됨



## 협상(콘텐츠 네고시에이션)
- 클라이언크가 서버에 요청할 때 응답줄땐 이렇게 주세요! 주라는 개념
- Accept: 클라이언트가 선호하는 미디어 타입 전달
  - Accept: text/*, text/plain, text/plain;format=flowed, */*
  - 위와 같이 q값없이 있을경우 구체적인것이 우선순위를 갖는다
- Accept-Charset: 클라이언트가 선호하는 문자 인코딩
- Accept-Encoding: 클라이언트가 선호하는 압축 인코딩
- Accept-Language: 클라이언트가 선호하는 자연 언어
  - Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
  - 위 와 같이 우선순위를 줄 수 있고 숫자가 q(Quality Values) 값이 생략되었으면 1이다
  - 0~1 사이로 표현하며 숫자가 높을수록 우선순위를 갖는다



## 전송방식
- 단순 전송
  - Content-Length
  - Http Header의 Content-Length만큼 메시지Body에 데이터를 담아 보내는 방식
- 압축 전송
  - Content-Encoding
  - 메세지 Body 데이터를 특정 압축방식으로 압축하여 요청을 보내는 방식
- 분할 전송
  - Http Header에 Transfer-Encoding: chunked 라는 설정을 통하여 메세지를 쪼개어 전달하는 방식
- 범위 전송
  - Http Header에  Content-Range: bytes 1001-2000/2000 와같이 범위를 지정하여 요청을 보내는 방식











