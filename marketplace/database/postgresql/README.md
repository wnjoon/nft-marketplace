# Database for application (marketplace)
 
마켓플레이스 응용의 사용자 정보를 관리하는 데이터베이스를 구동한다.  
postgresql 기반으로 구성되어 있다.

## 환경구성
1. ./database/postgresql 경로의 data 디렉토리 삭제(존재한다면)
2. ./database/postgresql 경로의 ./startPg.sh 실행(도커 이미지 다운로드 가능)
3. ./database/postgresql 경로의 ./makeDatabase.sql 실행

> makeDatabase.sql을 컨테이너 내부에서 실행하는 방법
> - docker exec -it pgsql bash
> - psql -U postgres
> - makeDatabase.sql 내부의 모든 내용을 복사+붙여넣기

4. ./database/postgresql 경로의 ./initTableData.sql 실행 
