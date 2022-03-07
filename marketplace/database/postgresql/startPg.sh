docker run -d -v $PWD/data:/var/lib/postgresql/data -p 7070:5432 --name pgsql -e TZ=Asia/Seoul -e POSTGRES_PASSWORD=cbdcpoc postgres:12
