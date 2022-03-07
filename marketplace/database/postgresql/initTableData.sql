begin;

DROP TABLE IF EXISTS "public"."tb_user";
CREATE TABLE "public"."tb_user" (
    "user_id" varchar(30) NOT NULL,
    "username" varchar(50) NOT NULL,
    "password" varchar(50) NOT NULL,
    "address" varchar(50) NOT NULL,
    "privatekey" varchar(100) NOT NULL,    
    PRIMARY KEY ("user_id")
);

INSERT INTO "public"."tb_user" ("user_id", "username", "password", "address", "privatekey") VALUES
('marketplace', 'marketplace관리자', '1111', '0xfe3b557e8fb62b89f4916b721be55ceb828dbd73', '0x8f2a55949038a9610f50fb23b5883af3b4ecb3c3bb792cbcefbd1542c692be63'),
('user1', '사용자1', '1111', '0x627306090abaB3A6e1400e9345bC60c78a8BEf57', '0xc87509a1c067bbde78beb793e6fa76530b6382a4c0241e5e4a9ec0a0f44dc0d3'),
('user2', '사용자2', '1111', '0xf17f52151EbEF6C7334FAD080c5704D77216b732', '0xae6ae8e5ccbfb04590405997ee2d52d2b330726137b875053c36d94e974d162f'),
('user3', '사용자3', '1111', '0x90d48232C2873a76f2547CDa324b3C8bc761374c', '0xa53e056ee968e2abe96d0ee178488606d9e3f140e1fe9d577a1a544cfa638a6d');

commit;
