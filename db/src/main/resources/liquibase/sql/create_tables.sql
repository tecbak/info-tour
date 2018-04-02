CREATE TABLE agent
(
  id   BIGSERIAL
    CONSTRAINT agent_pkey PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE hotel
(
  id   BIGSERIAL
    CONSTRAINT hotel_pkey PRIMARY KEY,
  name VARCHAR(255)
);

-- Tour

CREATE TABLE tour
(
  id   BIGSERIAL
    CONSTRAINT tour_pkey PRIMARY KEY,
  date TIMESTAMP
);

CREATE TABLE common_event (
  id          BIGSERIAL
    CONSTRAINT common_event_pkey PRIMARY KEY,
  tour_id     BIGINT NOT NULL
    CONSTRAINT hotel_revision_tour_id_fk REFERENCES tour (id),
  date_time   TIMESTAMP,
  information VARCHAR(255)
);


CREATE TABLE hotel_revision
(
  id      BIGSERIAL
    CONSTRAINT tour_info_pkey PRIMARY KEY,
  tour_id BIGINT NOT NULL
    CONSTRAINT hotel_revision_tour_id_fk REFERENCES tour (id)
  --   hotel_id BIGINT NOT NULL
  --     CONSTRAINT hotel_revision_hotel_id_fk REFERENCES hotel (id)
);

CREATE TABLE questionnaire
(
  id                BIGSERIAL
    CONSTRAINT questionnaire_pkey PRIMARY KEY,
  hotel_revision_id BIGINT NOT NULL
    CONSTRAINT questionnaire_hotel_revision_id_fk REFERENCES hotel_revision (id),
  agent_id          BIGINT NOT NULL
    CONSTRAINT questionnaire_agent_id_fk REFERENCES agent (id),
  notes             VARCHAR(255)
);

-- Draft Tour

-- CREATE TABLE draft_tour
-- (
--   id                BIGSERIAL
--     CONSTRAINT draft_tour_pkey PRIMARY KEY,
--   hotel_revision_id BIGINT NOT NULL
--     CONSTRAINT draft_tour_hotel_revision_id_fk REFERENCES hotel_revision (id),
--   agent_id          BIGINT NOT NULL
--     CONSTRAINT draft_tour_agent_id_fk REFERENCES agent (id),
--   notes             VARCHAR(255)
-- );
-- 
-- CREATE TABLE draft_tour_hotel
-- (
--   id            BIGSERIAL
--     CONSTRAINT draft_tour_hotel_pkey PRIMARY KEY,
--   draft_tour_id BIGINT NOT NULL
--     CONSTRAINT draft_tour_hotel_draft_tour_id_fk REFERENCES draft_tour (id),
--   hotel_id      BIGINT NOT NULL
--     CONSTRAINT draft_tour_hotel_agent_id_fk REFERENCES hotel (id)
-- );
-- 
-- CREATE TABLE draft_tour_agent
-- (
--   id            BIGSERIAL
--     CONSTRAINT draft_tour_agent_pkey PRIMARY KEY,
--   draft_tour_id BIGINT NOT NULL
--     CONSTRAINT draft_tour_agent_draft_tour_id_fk REFERENCES draft_tour (id),
--   agent_id      BIGINT NOT NULL
--     CONSTRAINT draft_tour_agent_agent_id_fk REFERENCES agent (id)
-- );