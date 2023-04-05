In order to have persistence you must run this command in docker.
docker run --name postgres-db -e POSTGRES_PASSWORD=docker -p 5432:5432 -d postgres

