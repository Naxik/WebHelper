CREATE SEQUENCE act_id_seq;
CREATE SEQUENCE hours_in_week_id_seq;
CREATE SEQUENCE work_calendar_id_seq;

CREATE TABLE acts (
  id               BIGINT        NOT NULL PRIMARY KEY,
  title            VARCHAR(1000) NOT NULL DEFAULT '',
  work_calendar_id BIGINT        NULL
);

CREATE TABLE hours_in_week (
  id        BIGINT       NOT NULL PRIMARY KEY,
  week_type VARCHAR(100) NULL,
  hours     INT          NULL
);

CREATE TABLE work_calendar (
  id               BIGINT NOT NULL PRIMARY KEY,
  year             INT    NULL,
  month            INT    NULL,
  hours_in_week_id BIGINT NULL
);

ALTER TABLE acts
  ADD CONSTRAINT work_calendar_id_fk FOREIGN KEY (work_calendar_id) REFERENCES work_calendar (id);
ALTER TABLE work_calendar
  ADD CONSTRAINT hours_in_week_id_fk FOREIGN KEY (hours_in_week_id) REFERENCES hours_in_week (id);
