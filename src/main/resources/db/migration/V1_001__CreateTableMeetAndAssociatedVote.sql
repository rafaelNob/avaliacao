CREATE TABLE meeting
(
    id SERIAL NOT NULL,
    description varchar(255) NOT NULL,
    created_date timestamp not null,
    expiration_date timestamp not null,
    CONSTRAINT meeting_id PRIMARY KEY (id)
);

CREATE TABLE associated_vote
(
    id SERIAL NOT NULL,
    cpf varchar(255) NOT NULL,
    vote boolean NOT NULL,
    meeting_id BIGINT NOT NULL,
    CONSTRAINT associated_vote_id PRIMARY KEY (id),
    CONSTRAINT associated_vote_fkey_meeting_id FOREIGN KEY (meeting_id) REFERENCES meeting(id)
);


