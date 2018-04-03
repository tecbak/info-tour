-- CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE person
(
  id   UUID --NOT NULL DEFAULT uuid_generate_v1()
    CONSTRAINT person_pkey PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE hotel
(
  id   UUID --NOT NULL DEFAULT uuid_generate_v1()
    CONSTRAINT hotel_pkey PRIMARY KEY,
  name VARCHAR(255)
);

-- Tour

CREATE TABLE tour
(
  id   UUID --NOT NULL DEFAULT uuid_generate_v1()
    CONSTRAINT tour_pkey PRIMARY KEY,
  date TIMESTAMP
);

CREATE TABLE tour_person
(
  tour_id   UUID NOT NULL
    CONSTRAINT tour_person_tour_id_fk REFERENCES tour (id),
  person_id UUID NOT NULL
    CONSTRAINT tour_person_person_id_fk REFERENCES person (id),
  PRIMARY KEY (tour_id, person_id)
);

CREATE TABLE schedule (
  id        UUID --NOT NULL DEFAULT uuid_generate_v1()
    CONSTRAINT schedule_pkey PRIMARY KEY,
  tour_id   UUID
    CONSTRAINT schedule_tour_id_fk REFERENCES tour (id),
  date_time TIMESTAMP
);


CREATE TABLE event (
  id          UUID --NOT NULL DEFAULT uuid_generate_v1()
    CONSTRAINT event_pkey PRIMARY KEY,
  tour_id     UUID
    CONSTRAINT event_tour_id_fk REFERENCES tour (id),
  date_time   TIMESTAMP,
  information VARCHAR(255)
);


CREATE TABLE revision
(
  id        UUID --NOT NULL DEFAULT uuid_generate_v1()
    CONSTRAINT revision_pkey PRIMARY KEY,
  tour_id   UUID
    CONSTRAINT revision_tour_id_fk REFERENCES tour (id),
  hotel_id  UUID
    CONSTRAINT revision_hotel_id_fk REFERENCES hotel (id),
  date_time TIMESTAMP

);

CREATE TABLE questionnaire
(
  id          UUID --NOT NULL DEFAULT uuid_generate_v1()
    CONSTRAINT questionnaire_pkey PRIMARY KEY,
  revision_id UUID NOT NULL
    CONSTRAINT questionnaire_revision_id_fk REFERENCES revision (id),
  person_id   UUID NOT NULL
    CONSTRAINT questionnaire_person_id_fk REFERENCES person (id),
  notes       VARCHAR(255)
);
