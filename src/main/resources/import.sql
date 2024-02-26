-- 로그인 ID: admin, PW: admin
-- 로그인 ID: user, PW: user
insert into "user" (username, password, nickname) values ('admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin');
insert into "user" (username, password, nickname) values ('user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user');

-- 권한: 사용자, 관리자, 운영자
insert into authority (authority_name) values ('ROLE_USER');
insert into authority (authority_name) values ('ROLE_MANAGER');
insert into authority (authority_name) values ('ROLE_ADMIN');

-- 권한 부여
insert into user_authority (user_id, authority_name) values (1, 'ROLE_USER');
insert into user_authority (user_id, authority_name) values (1, 'ROLE_ADMIN');
insert into user_authority (user_id, authority_name) values (2, 'ROLE_USER');

-- 더미 코드
-- INSERT INTO "code_list" (cd_id, cd_nm, cd_des, cd_ord, upr_cd_id) VALUES  ('CD00010001', '고기', '설명', 0, NULL);
-- INSERT INTO "code_list" (cd_id, cd_nm, cd_des, cd_ord, upr_cd_id) VALUES  ('CD00010002', '돼지고기', '설명', 1, 'CD00010001');
-- INSERT INTO "code_list" (cd_id, cd_nm, cd_des, cd_ord, upr_cd_id) VALUES  ('CD00010003', '소고기', '설명', 2, 'CD00010001');
-- INSERT INTO "code_list" (cd_id, cd_nm, cd_des, cd_ord, upr_cd_id) VALUES  ('CD00010004', '양고기', '설명', 3, 'CD00010001');
-- INSERT INTO "code_list" (cd_id, cd_nm, cd_des, cd_ord, upr_cd_id) VALUES  ('CD00020001', '코딩언어', '설명', 0, NULL);
-- INSERT INTO "code_list" (cd_id, cd_nm, cd_des, cd_ord, upr_cd_id) VALUES  ('CD00020002', 'C', '설명', 1, 'CD00020001');
-- INSERT INTO "code_list" (cd_id, cd_nm, cd_des, cd_ord, upr_cd_id) VALUES  ('CD00020003', 'C#', '설명', 2, 'CD00020001');
-- INSERT INTO "code_list" (cd_id, cd_nm, cd_des, cd_ord, upr_cd_id) VALUES  ('CD00020004', 'C++', '설명', 3, 'CD00020001');
-- INSERT INTO "code_list" (cd_id, cd_nm, cd_des, cd_ord, upr_cd_id) VALUES  ('CD00020005', 'Java', '설명', 4, 'CD00020001');
