CREATE TABLE public.car
(
  eancode character varying(13) NOT NULL,
  amount integer,
  description character varying(255),
  CONSTRAINT car_pkey PRIMARY KEY (eancode)
)
WITH (
  OIDS=FALSE
);