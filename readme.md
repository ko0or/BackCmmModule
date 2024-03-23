# 백엔드 공통 모듈
`Swagger-UI`
```
http://localhost:8080/swagger-ui/index.html#/
```
<br>

`기본 정보`
```
SpringBoot : 3.2.2
JDK : 17
Profile List : local
DB Set : H2 , PostgreSQL
Dependency : JPA, JWT, QueryDSL , SwaggerUI, Lombok, MapperUtil ...
```
<br>


`주요 패키지`
```
패키지 경로 : src/main/java/back/cmm/module/cmm
패키지 분류
  1. base
    다음과 같이 모든 패키지에서 사용할 수 있는 유용한 기능이 포함되어있습니다.
    - 각종 설정(cors, swagger, jpa auditor)
    - 상속용 공통 도메인(등록일시, 수정일시 및 유저명)
    - 로깅 설정
    - 스케줄러
    - 유틸(모델 매퍼 및 파일 관련)
    
  2. code
    - 재귀형식의 코드 구조 or 단일 코드를 사용할 수 있습니다
    
  3. file
    - 파일 다중 업로드 및 단일 다운로드 기능
    - 이미지 표시 기능
    
  4. security
    - jwt 기반의 인가, 인증을 처리합니다
    - 보안 설정(SecurityConfig)을 관리합니다
```