# 1. JDK 17을 사용하는 베이스 이미지를 선택 (버전에 맞게 변경 가능)
FROM openjdk:17-jdk-alpine

# 2. 애플리케이션을 위한 작업 디렉토리 생성
WORKDIR /app

# 3. 로컬에서 빌드한 jar 파일을 컨테이너에 복사 (Gradle 빌드 경로)
COPY build/libs/studyJwt2-0.0.1-SNAPSHOT.jar /app/application.jar

# 4. 애플리케이션을 실행하는 명령어
ENTRYPOINT ["java", "-jar", "/app/application.jar"]
