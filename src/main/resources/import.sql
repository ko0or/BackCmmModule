-- 로그인 ID: admin, PW: admin
-- 로그인 ID: user, PW: user
insert into "user" (username, password, nickname, activated) values ('admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 1);
insert into "user" (username, password, nickname, activated) values ('user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 1);

-- 권한: 사용자, 관리자, 운영자
insert into authority (authority_name) values ('ROLE_USER');
insert into authority (authority_name) values ('ROLE_MANAGER');
insert into authority (authority_name) values ('ROLE_ADMIN');

-- 권한 부여
insert into user_authority (user_id, authority_name) values (1, 'ROLE_USER');
insert into user_authority (user_id, authority_name) values (1, 'ROLE_ADMIN');
insert into user_authority (user_id, authority_name) values (2, 'ROLE_USER');