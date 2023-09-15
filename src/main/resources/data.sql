insert into roles values ('USER') ON CONFLICT (name) DO NOTHING;
insert into roles values ('ADMIN') ON CONFLICT (name) DO NOTHING;

insert into users(username, email, password, account_non_expired, account_non_locked, credentials_non_expired, enabled)
select 'user','user@gmail.com','$2a$10$vWKraQPCNIZm.5u1L0THkut0RyjK3YT4Ndw0ZuBC5NVHOQawj8oCy', true, true, true, true
WHERE NOT EXISTS (SELECT id FROM users WHERE id = 1);

insert into users(username, email, password, account_non_expired, account_non_locked, credentials_non_expired, enabled)
select 'admin','admin@gmail.com','$2a$10$Qg1OnHFaWQgMzCCqZZRQJOBkkJsQRzS4gfxnb1.H7Iq/B.TtV1Gzm', true, true, true, true
WHERE NOT EXISTS (SELECT id FROM users WHERE id = 2);

-- ON CONFLICT (username) DO NOTHING;

insert into user_roles values (1, 'USER') ON CONFLICT (user_id, role_name) DO NOTHING;
insert into user_roles values (2, 'ADMIN') ON CONFLICT (user_id, role_name) DO NOTHING;