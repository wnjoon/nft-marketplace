cp makeDatabase.sql ./data/
cp initTableData.sql ./data/
docker exec -it --user postgres pgsql psql -f /var/lib/postgresql/data/makeDatabase.sql
docker exec -it --user postgres pgsql psql -U marketplace -d marketplacedb -a -f /var/lib/postgresql/data/initTableData.sql
