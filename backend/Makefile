# Load .env file into shell
include .env
export $(shell sed 's/=.*//' .env)

MVNW=mvnw
ifeq ($(OS),Windows_NT)
	MVNW=mvnw.cmd
endif

# Start the database container
db:
	docker compose up -d

# Start the Spring Boot backend
run:
	@echo "Running Spring Boot with DB: $(DB_NAME)" 
	$(MVNW) spring-boot:run

flyway-cli:
	docker run --rm \
	  -v $(PWD)/backend/src/main/resources/db/migration:/flyway/sql \
	  -e FLYWAY_URL=jdbc:postgresql://host.docker.internal:5433/$(DB_NAME) \
	  -e FLYWAY_USER=$(DB_USER) \
	  -e FLYWAY_PASSWORD=$(DB_PASS) \
	  flyway/flyway migrate

# Run backend with Flyway enabled
flyway:
	@echo "Running Spring Boot with Flyway profile..."
	$(MVNW) spring-boot:run -Dspring-boot.run.profiles=flyway

# Run both DB and backend
start:
	make db && make run

# Stop the backend app and shut down the DB
stop:
	docker compose down

# Delete db data and volume (LOSE ALL DATA)
danger-delete:
	docker compose down -v