begin;

DROP TABLE IF EXISTS "public"."tb_user";
CREATE TABLE "public"."tb_user" (
    "user_id" bigint NOT NULL,
    "username" varchar(50) NOT NULL,
    "password" varchar(50) NOT NULL,
    "address" varchar(50) NOT NULL,
    "privatekey" varchar(100) NOT NULL,    
    PRIMARY KEY ("user_id")
);

INSERT INTO "public"."tb_user" ("user_id", "username", "password", "address", "privatekey") VALUES
('0', 'marketplace', '1111', '0xf70e0e6ba284481deb1d53765fce4a49df5e1624', '0x35c8bfc9b62d9613bb9abc56a6015c7470b0dcaa38d2c32bb461e660e67fa431'),
('1', 'user1', '1111', '0xfe3b557e8fb62b89f4916b721be55ceb828dbd73', '0x8f2a55949038a9610f50fb23b5883af3b4ecb3c3bb792cbcefbd1542c692be63'),
('2', 'user2', '1111', '0x627306090abaB3A6e1400e9345bC60c78a8BEf57', '0xc87509a1c067bbde78beb793e6fa76530b6382a4c0241e5e4a9ec0a0f44dc0d3'),
('3', 'user3', '1111', '0xf17f52151EbEF6C7334FAD080c5704D77216b732', '0xae6ae8e5ccbfb04590405997ee2d52d2b330726137b875053c36d94e974d162f'),
('4', 'user4', '1111', '0x90d48232C2873a76f2547CDa324b3C8bc761374c', '0xa53e056ee968e2abe96d0ee178488606d9e3f140e1fe9d577a1a544cfa638a6d');

commit;
