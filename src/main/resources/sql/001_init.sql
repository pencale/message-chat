BEGIN TRANSACTION;
DROP TABLE IF EXISTS "message" CASCADE;
DROP SEQUENCE IF EXISTS "message_seq" CASCADE;
CREATE SEQUENCE "message_seq" START 1;

CREATE TABLE "message" (
    "id"    BIGINT PRIMARY KEY DEFAULT "nextval"('"message_seq"'),
    "user_id"   BIGINT NOT NULL,
    "user_name" TEXT NOT NULL,
    "chat_id"   BIGINT NOT NULL,
    "text"  TEXT NOT NULL,
    "date"  TIMESTAMP NOT NULL
);

DROP TABLE IF EXISTS "chat_map" CASCADE;
DROP SEQUENCE IF EXISTS "chat_seq" CASCADE;
CREATE SEQUENCE "chat_seq" START 1;

CREATE TABLE "chat_map" (
    "id"    BIGINT PRIMARY KEY DEFAULT "nextval"('"chat_seq"'),
    "user_ids"   BIGINT[] NOT NULL
);

DROP TABLE IF EXISTS "user" CASCADE;
DROP SEQUENCE IF EXISTS "user_seq" CASCADE;
CREATE SEQUENCE "user_seq" START 1;

CREATE TABLE "user" (
    "id"    BIGINT PRIMARY KEY DEFAULT "nextval"('"user_seq"'),
    "name"   TEXT NOT NULL,
    "email" TEXT NOT NULL,
    "avatar" TEXT,
    "active"    BOOLEAN DEFAULT FALSE
);

END TRANSACTION;
