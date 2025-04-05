# all-that-you-know

A Local Search Engine to explore and reference what you already know

## Run Steps

### Spin up the DB and Service

`cd backend && make dev`

### Switching Devices

You don't want to lose all that you know ;)
**1. Dump your database**
`docker exec -t mind-db pg_dump -U postgres minddb > backup.sql`
**2. Restore on your new device**
`docker cp backup.sql mind-db:/backup.sql`
`docker exec -it mind-db psql -U postgres -d minddb -f /backup.sql`
