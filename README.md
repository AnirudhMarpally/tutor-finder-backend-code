# Tutor Finder Backend (No Auth)

- Java 21, Spring Boot 3.5.5
- **No authentication/authorization** — all endpoints are public.
- H2 (default) with a single `script.sql` for tables + seed data.
- Optional MySQL profile included.

## Run
```bash
mvn spring-boot:run
# or MySQL:
# mvn spring-boot:run -Dspring-boot.run.profiles=mysql
```

## Endpoints (all public)
- `GET /` -> health check
- `GET /api/users` -> list all users from `script.sql`
- `GET /api/tutors?location=&subject=&maxFees=` -> filter
- `POST /api/notifications` -> {studentId, tutorId, message}
- `GET /api/notifications/received/{tutorId}`
- `POST /api/notifications/{id}/approve`
- `POST /api/notifications/{id}/reject`

Use the seeded data:
- Students: user 1 (alice)
- Tutors: tutorId 1 (bob), tutorId 2 (carol)
