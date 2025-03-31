

build: mvn clean package

Start services: docker-compose up -d

Access:

App: http://localhost:8080

PostgreSQL: localhost:5432 (use your favorite DB client)

Kafka: Available at localhost:9092 for producers/consumers