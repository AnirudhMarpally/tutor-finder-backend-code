DROP TABLE IF EXISTS notifications;
DROP TABLE IF EXISTS tutors;
DROP TABLE IF EXISTS users;

CREATE TABLE users(
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(20) NOT NULL, -- STUDENT or TUTOR
  name VARCHAR(200),
  email VARCHAR(200) UNIQUE
);

CREATE TABLE tutors(
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL UNIQUE,
  subject VARCHAR(200) NOT NULL,
  location VARCHAR(200) NOT NULL,
  fees DECIMAL(10,2) NOT NULL,
  CONSTRAINT fk_tutor_user FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE notifications(
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  student_id BIGINT NOT NULL,
  tutor_id BIGINT NOT NULL,
  message VARCHAR(1000) NOT NULL,
  status VARCHAR(20) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_notification_student FOREIGN KEY (student_id) REFERENCES users(id),
  CONSTRAINT fk_notification_tutor FOREIGN KEY (tutor_id) REFERENCES tutors(id)
);

-- store "password" plain text now since there's no auth
INSERT INTO users(id, username, password, role, name, email) VALUES
(1, 'alice', 'password', 'STUDENT', 'Alice Student', 'alice@example.com'),
(2, 'bob',   'password', 'TUTOR',   'Bob Tutor',   'bob@example.com'),
(3, 'carol', 'password', 'TUTOR',   'Carol Tutor', 'carol@example.com');

INSERT INTO tutors(id, user_id, subject, location, fees) VALUES
(1, 2, 'Math',    'Mumbai', 500.00),
(2, 3, 'Physics', 'Pune',   700.00);

INSERT INTO notifications(student_id, tutor_id, message, status) VALUES
(1, 1, 'Need help with algebra', 'PENDING');
