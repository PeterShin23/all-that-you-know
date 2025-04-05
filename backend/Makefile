# Load .env file into shell
include .env
export $(shell sed 's/=.*//' .env)

# Start the database container
db:
	docker compose up -d

# Start the Spring Boot backend
run:
	@echo "Running Spring Boot with DB: $(DB_NAME)" 
	mvnw.cmd spring-boot:run

# Run backend with Flyway enabled
flyway:
	@echo "Running Spring Boot with Flyway profile..."
	mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=flyway

# Run both DB and backend
start:
	make db && make run

# Stop the backend app and shut down the DB
stop:
	docker compose down

# Delete db data and volume (LOSE ALL DATA)
danger-delete:
	docker compose down -v