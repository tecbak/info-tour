CREATE TABLE person
(
  id   UUID
    CONSTRAINT person_pkey PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE hotel
(
  id   UUID
    CONSTRAINT hotel_pkey PRIMARY KEY,
  name VARCHAR(255)
);

-- Tour

CREATE TABLE tour
(
  id   UUID
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

CREATE TABLE event (
  id          UUID
    CONSTRAINT event_pkey PRIMARY KEY,
  tour_id     UUID
    CONSTRAINT event_tour_id_fk REFERENCES tour (id),
  date_time   TIMESTAMP,
  information VARCHAR(255)
);


CREATE TABLE hotel_revision
(
  id        UUID
    CONSTRAINT tour_info_pkey PRIMARY KEY,
  tour_id   UUID
    CONSTRAINT hotel_revision_tour_id_fk REFERENCES tour (id),
  date_time TIMESTAMP

);

CREATE TABLE questionnaire
(
  id                UUID
    CONSTRAINT questionnaire_pkey PRIMARY KEY,
  hotel_revision_id UUID NOT NULL
    CONSTRAINT questionnaire_hotel_revision_id_fk REFERENCES hotel_revision (id),
  person_id         UUID NOT NULL
    CONSTRAINT questionnaire_person_id_fk REFERENCES person (id),
  notes             VARCHAR(255)
);
