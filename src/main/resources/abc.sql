\c postgres;
drop database gayratjon_aka;
create database gayratjon_aka;
\c gayratjon_aka;


INSERT INTO abc(name)
SELECT 'Setasdasddh'
    WHERE
NOT EXISTS (
SELECT id FROM abc WHERE id = 2
);