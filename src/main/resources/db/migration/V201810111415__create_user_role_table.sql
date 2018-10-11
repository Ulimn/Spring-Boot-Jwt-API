CREATE TABLE user_role (
    user_id int8 NOT NULL,
    role_id int8 NOT NULL
);

ALTER TABLE user_role
    ADD CONSTRAINT fk__user_role__role FOREIGN KEY (role_id) REFERENCES ROLE;

ALTER TABLE user_role
    ADD CONSTRAINT fk__user_role__app_user FOREIGN KEY (user_id) REFERENCES app_user;