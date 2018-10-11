CREATE TABLE app_user (
    id int8 NOT NULL,
    created_by varchar(255),
    created_date timestamp,
    last_modified_date timestamp,
    modified_by varchar(255),
    version int8,
    email varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    PASSWORD varchar(255) NOT NULL,
    PRIMARY KEY (id)
)