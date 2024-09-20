use burger_db;

-- //////// 테이블 생성 START ////////

-- 버거
CREATE TABLE burger (
   burger_pk   INTEGER NOT NULL AUTO_INCREMENT, -- 버거pk
   ingr_pk     INTEGER NULL,                   -- 재료pk
   burger_name VARCHAR(30) NOT NULL,           -- 버거이름
   PRIMARY KEY (burger_pk)                     -- 버거 기본키
);

-- 재료
CREATE TABLE ingredient (
   ingr_pk   INTEGER NOT NULL AUTO_INCREMENT, -- 재료pk
   ingr_name VARCHAR(30) NULL,               -- 재료이름
   ingr_url  TEXT NULL,                      -- 재료URL
   PRIMARY KEY (ingr_pk)                     -- 재료 기본키
);

-- 회원
CREATE TABLE user (
   user_pk      INTEGER NOT NULL AUTO_INCREMENT, -- 회원pk
   test_type_pk INTEGER NULL,                    -- 테스트유형pk
   user_id      VARCHAR(30) NOT NULL,            -- 회원아이디
   user_pw      VARCHAR(30) NOT NULL,            -- 회원비밀번호
   user_name    VARCHAR(30) NULL,                -- 회원이름
   user_birth   VARCHAR(10) NULL,                -- 회원생년월일
   user_mobile  VARCHAR(30) NULL,                -- 회원전화번호
   user_email   VARCHAR(40) NULL,                -- 회원이메일
   PRIMARY KEY (user_pk)                         -- 회원 기본키
);

-- 게임로그
CREATE TABLE game_log (
   log_pk              INTEGER NOT NULL AUTO_INCREMENT, -- 게임로그pk
   game_pk             INTEGER NULL,                    -- 게임pk
   ingr_pk             INTEGER NULL,                    -- 재료pk
   burger_pk           INTEGER NULL,                    -- 버거pk
   ingr_usage_quantity INTEGER NULL,                    -- 재료사용수량
   PRIMARY KEY (log_pk)                                 -- 게임로그 기본키
);

-- 게임
CREATE TABLE game (
   game_pk    INTEGER NOT NULL AUTO_INCREMENT, -- 게임pk
   user_pk    INTEGER NULL,                    -- 회원pk
   burger_pk  INTEGER NULL,                    -- 버거pk
   game_score INTEGER NULL,                    -- 게임총점수
   PRIMARY KEY (game_pk)                       -- 게임 기본키
);

-- 테스트유형
CREATE TABLE test_type (
   test_type_pk     INTEGER NOT NULL AUTO_INCREMENT, -- 테스트유형pk
   test_type1       CHAR(1) NULL,                    -- 테스트유형1
   test_type2       CHAR(1) NULL,                    -- 테스트유형2
   test_type3       CHAR(1) NULL,                    -- 테스트유형3
   test_type4       CHAR(1) NULL,                    -- 테스트유형4
   test_type_result VARCHAR(100) NULL,                -- 테스트유형결과
   test_type_details VARCHAR(300) NULL,              -- 테스트유형상세내용
   PRIMARY KEY (test_type_pk)                        -- 테스트유형 기본키
);

-- 버거재료
CREATE TABLE burger_recipe (
   ingr_pk                   INTEGER NOT NULL,  -- 재료pk
   burger_pk                 INTEGER NOT NULL,  -- 버거pk
   score_per_burger_ingr     INTEGER NULL,      -- 버거재료당점수
   max_usage_per_burger_ingr INTEGER NULL,      -- 버거재료당최대사용량
   PRIMARY KEY (ingr_pk, burger_pk)             -- 버거재료 기본키
);

-- 게시판
CREATE TABLE board (
   board_pk         INTEGER NOT NULL AUTO_INCREMENT, -- 게시판pk
   user_pk          INTEGER NULL,                    -- 회원pk
   board_title      VARCHAR(100) NULL,               -- 게시판글제목
   board_body       TEXT NULL,                       -- 게시판글
   board_reg_date   DATE NULL,                       -- 게시판작성일자
   board_view_count INTEGER NULL,                    -- 게시판조회수
   PRIMARY KEY (board_pk)                            -- 게시판 기본키
);

-- 게시판댓글
CREATE TABLE board_comment (
   comment_pk       INTEGER NOT NULL AUTO_INCREMENT, -- 댓글pk
   board_pk         INTEGER NULL,                    -- 게시판pk
   user_pk          INTEGER NULL,                    -- 회원pk
   comment_body     TEXT NULL,                       -- 댓글내용
   comment_reg_date DATE NULL,                       -- 댓글작성일자
   PRIMARY KEY (comment_pk)                          -- 게시판댓글 기본키
);

-- //////// 테이블 생성 END ////////





-- //////// 외래키 설정 START ////////

-- 버거 -> 재료
ALTER TABLE burger
   ADD CONSTRAINT FK_ingredient_TO_burger
   FOREIGN KEY (ingr_pk)
   REFERENCES ingredient (ingr_pk);

-- 회원 -> 테스트유형
ALTER TABLE user
   ADD CONSTRAINT FK_test_type_TO_user
   FOREIGN KEY (test_type_pk)
   REFERENCES test_type (test_type_pk);

-- 게임로그 -> 게임
ALTER TABLE game_log
   ADD CONSTRAINT FK_game_TO_game_log
   FOREIGN KEY (game_pk)
   REFERENCES game (game_pk);

-- 게임로그 -> 버거재료
ALTER TABLE game_log
   ADD CONSTRAINT FK_burger_recipe_TO_game_log
   FOREIGN KEY (ingr_pk, burger_pk)
   REFERENCES burger_recipe (ingr_pk, burger_pk);

-- 게임 -> 버거
ALTER TABLE game
   ADD CONSTRAINT FK_burger_TO_game
   FOREIGN KEY (burger_pk)
   REFERENCES burger (burger_pk);

-- 게임 -> 회원
ALTER TABLE game
   ADD CONSTRAINT FK_user_TO_game
   FOREIGN KEY (user_pk)
   REFERENCES user (user_pk);

-- 버거재료 -> 재료
ALTER TABLE burger_recipe
   ADD CONSTRAINT FK_ingredient_TO_burger_recipe
   FOREIGN KEY (ingr_pk)
   REFERENCES ingredient (ingr_pk);

-- 버거재료 -> 버거
ALTER TABLE burger_recipe
   ADD CONSTRAINT FK_burger_TO_burger_recipe
   FOREIGN KEY (burger_pk)
   REFERENCES burger (burger_pk);

-- 게시판 -> 회원
ALTER TABLE board
   ADD CONSTRAINT FK_user_TO_board
   FOREIGN KEY (user_pk)
   REFERENCES user (user_pk);

-- 게시판댓글 -> 게시판
ALTER TABLE board_comment
   ADD CONSTRAINT FK_board_TO_board_comment
   FOREIGN KEY (board_pk)
   REFERENCES board (board_pk);

-- 게시판댓글 -> 회원
ALTER TABLE board_comment
   ADD CONSTRAINT FK_user_TO_board_comment
   FOREIGN KEY (user_pk)
   REFERENCES user (user_pk);
   
-- //////// 외래키 설정 END ////////





-- //////// 더미 데이터 START ////////

-- 재료
INSERT INTO ingredient (ingr_name, ingr_url)
VALUES
('돼지고기', '/images/pork.png'),
('소고기', '/images/beef.png'),
('닭고기', '/images/chicken.png'),
('상추', '/images/lettuce.png'),
('토마토', '/images/tomato.png'),
('치즈', '/images/cheese.png'),
('베이컨', '/images/bacon.png'),
('새우', '/images/shrimp.png'),
('계란후라이', '/images/friedeggs.png'),
('양파', '/images/onion.png'),
('피클', '/images/pickle.png'),
('민트초코', '/images/mintchoco.png'),
('김치', '/images/kimchi.png'),
('딸기', '/images/strawberry.png');

-- 버거
INSERT INTO burger (burger_name)
VALUES
('BURGUNDY'),
('김숙자 버거'),
('존버.거');

-- 테스트유형
INSERT INTO test_type (test_type1, test_type2, test_type3, test_type4, test_type_result, test_type_details)
VALUES
('1', '1', '1', '1', '버거도, 쪼랭이도, 코딩도, 이희만 강사님도 완벽히 사랑하는 당신!', '버거를 좋아하고, 쪼랭이도 알고, 코딩까지 잘하며 이희만 강사님을 존경하는 당신은 완벽한 학생입니다. 이 모든 요소가 합쳐져 당신은 미식과 코딩의 세계에서 최고가 될 준비가 되어 있군요!'),
('1', '1', '1', '0', '버거 마니아이자 쪼랭이와 코딩을 사랑하는 당신', '버거와 쪼랭이를 좋아하고, 코딩도 잘하는 당신은 이희만 강사님에 대해서는 아직 잘 모르지만, 앞으로의 시간이 기대됩니다. 이희만 강사님과 함께하는 코딩 모험을 시작해보세요!'),
('1', '1', '0', '1', '버거와 쪼랭이 마니아, 이희만 강사님의 팬!', '버거도 좋아하고 쪼랭이도 알고, 이희만 강사님을 존경하지만, 코딩 실력에 대해선 자신이 부족하다고 느끼는 당신. 강사님과 함께라면 코딩 실력도 늘어날 거예요!'),
('1', '1', '0', '0', '버거와 쪼랭이는 알지만 코딩은 아직, 이희만 강사님도 낯선 당신', '버거와 쪼랭이는 좋아하지만 코딩 실력에 대해선 아직 부족함을 느끼는 당신. 이희만 강사님과 함께라면 코딩 실력도 성장할 기회가 있을 거예요!'),
('1', '0', '1', '1', '버거 마니아이자 코딩 천재, 이희만 강사님까지 좋아하는 당신', '버거를 좋아하고 코딩도 잘하며, 이희만 강사님을 존경하는 당신. 비록 쪼랭이에 대해서는 잘 모를 수 있지만, 이 세 가지 요소만으로도 이미 충분히 강력한 학생입니다!'),
('1', '0', '1', '0', '버거를 좋아하고 코딩도 잘하지만 이희만 강사님은 모르는 당신', '버거와 코딩에 대한 열정이 넘치지만, 쪼랭이와 이희만 강사님에 대한 정보는 아직 부족한 당신. 이희만 강사님과 함께라면 미식과 코딩 모두 즐길 수 있는 기회가 될 거예요.'),
('1', '0', '0', '1', '버거를 좋아하고 이희만 강사님을 존경하는 당신', '버거에 대한 열정이 넘치고, 이희만 강사님을 좋아하지만 쪼랭이에 대해서는 아직 모르는 당신. 코딩 실력도 부족하다 느끼지만, 강사님과 함께라면 모든 것이 해결될 수 있을 거예요!'),
('1', '0', '0', '0', '버거 마니아지만 쪼랭이와 코딩, 이희만 강사님에 대해선 모르는 당신', '버거를 사랑하지만 코딩과 쪼랭이, 이희만 강사님에 대한 정보는 부족한 당신. 새로운 경험을 통해 이 모든 것을 알게 될 준비가 되어 있습니다!'),
('0', '1', '1', '1', '쪼랭이와 코딩에 대한 열정이 넘치고 이희만 강사님까지 좋아하는 당신', '버거는 좋아하지 않지만 쪼랭이를 알고 코딩도 잘하는 당신. 이희만 강사님과 함께라면 버거까지 좋아하게 될지도 모릅니다. 모든 것이 가능해요!'),
('0', '1', '1', '0', '쪼랭이와 코딩을 사랑하지만 이희만 강사님은 낯선 당신', '쪼랭이도 알고 코딩도 잘하지만, 이희만 강사님에 대해선 아직 잘 모르는 당신. 강사님과 함께라면 더 나은 코딩 실력을 쌓아나갈 수 있을 거예요!'),
('0', '1', '0', '1', '쪼랭이를 사랑하며 이희만 강사님까지 존경하는 당신', '쪼랭이에 대한 애정이 깊고, 이희만 강사님을 좋아하지만, 코딩에 대한 자신감은 아직 부족한 당신. 강사님의 지도 아래 코딩 실력을 키워나갈 준비가 되어 있습니다!'),
('0', '1', '0', '0', '쪼랭이는 알지만 코딩도, 이희만 강사님도 모르는 당신', '쪼랭이에 대해서는 잘 알고 있지만 코딩 실력에 대한 자신이 없고, 이희만 강사님도 아직 낯선 당신. 새로운 경험을 통해 코딩 실력도 늘리고, 강사님과의 유대도 쌓아나가 보세요.'),
('0', '0', '1', '1', '코딩 천재, 이희만 강사님도 존경하는 당신', '버거와 쪼랭이는 모르지만 코딩에 자신 있는 당신. 이희만 강사님을 좋아하고 존경하는 당신은 강사님의 도움을 받아 더욱 높은 코딩 능력을 발휘할 수 있을 겁니다!'),
('0', '0', '1', '0', '코딩 천재지만 이희만 강사님은 아직 모르는 당신', '코딩 실력에 자신 있는 당신은 버거와 쪼랭이에 대해선 잘 모르지만, 강사님과의 인연을 통해 더 많은 것을 배울 기회를 갖게 될 거예요.'),
('0', '0', '0', '1', '이희만 강사님을 존경하는 코딩 초심자', '버거, 쪼랭이, 코딩에 대해선 아직 경험이 부족하지만, 이희만 강사님을 존경하는 마음만큼은 확실한 당신. 강사님과 함께 코딩 실력을 쌓아나갈 수 있는 기회가 기다리고 있습니다.'),
('0', '0', '0', '0', '모든 것이 새로운 코딩 초심자', '버거, 쪼랭이, 코딩, 이희만 강사님 모두가 낯설지만 새로운 세계로의 모험을 준비하고 있는 당신. 강사님과 함께라면 그 모든 것이 흥미롭게 펼쳐질 거예요!');

-- 회원
INSERT INTO user (test_type_pk, user_id, user_pw, user_name, user_birth, user_mobile, user_email)
VALUES
(1, 'jjoa123', 'jjoa123', '김아름', '2003-04-29', '010-4032-4496', 'jjoa@burger.com'),
(2, 'jiyou123', 'jiyou123', '정지유', '1999-08-04', '010-9571-5911', 'jiyou@burger.com'),
(3, 'amin123', 'amin123', '이아민', '2000-09-28', '010-7277-6130', 'amin@burger.com'),
(4, 'j123', 'j123', '이정현', '2001-09-19', '010-9606-4111', 'j@burger.com');

-- 버거재료
INSERT INTO burger_recipe (ingr_pk, burger_pk, score_per_burger_ingr, max_usage_per_burger_ingr)
VALUES
(2, 2, 16, 1),                  -- 소고기, 김숙자버거에서 사용되는 재료 : 16점, 최대 1장
(4, 2, 14, 2),                   -- 상추, 김숙자버거에서 사용되는 재료 : 14점, 최대 2장
(6, 2, 23, 1),                  -- 치즈, 김숙자버거에서 사용되는 재료 : 23점, 최대 1장
(10, 2, 11, 3);                 -- 양파, 김숙자버거에서 사용되는 재료 : 11점, 최대 3장

-- 게임
INSERT INTO game (user_pk, burger_pk, game_score)
VALUES
(1, 2, 50);    -- 김아름이 김숙자 버거로 얻은 점수

-- 게임로그
INSERT INTO game_log (game_pk, ingr_pk, burger_pk, ingr_usage_quantity)
VALUES
(1, 2, 2, 1),  -- 김아름이 김숙자버거에서 소고기를 1개 사용
(1, 4, 2, 1),  -- 김아름이 김숙자버거에서 치즈를 1개 사용
(1, 6, 2, 1);  -- 김아름이 김숙자버거에서 양파를 1개 사용

-- 게시판
INSERT INTO board (user_pk, board_title, board_body, board_reg_date, board_view_count)
VALUES
(3, '존버.거 레시피 공유함', '직감대로 찍으면 100점 나옴', '2024-09-14', 10),
(2, '안녕하세요 아이유 입니다', '어그로임. 버건디버거 어케 만듦?', '2024-09-13', 5);


-- 게시판 댓글
INSERT INTO board_comment (board_pk, user_pk, comment_body, comment_reg_date)
VALUES
(1, 1, 'ㅈㄹ ㄴ', '2024-09-13'),
(1, 4, '정지 먹여야 함 이런 계정은', '2024-09-14'),
(2, 4, 'ㅈㄹ ㄴ', '2024-09-13'),
(2, 3, '정지 먹여야 함 이런 계정은', '2024-09-13');

-- //////// 더미 데이터 END ////////

SET SQL_SAFE_UPDATES = 0;
SET SQL_SAFE_UPDATES = 1;

ALTER TABLE board_comment MODIFY COLUMN comment_reg_date DATETIME NULL;

INSERT INTO burger_recipe (ingr_pk, burger_pk, score_per_burger_ingr, max_usage_per_burger_ingr)
VALUES
(2, 3, 35, 1),   -- 돼지고기, 35점, 최대 1장
(4, 3, 14, 2),   -- 상추, 14점, 최대 2장
(8, 3, 20, 2),   -- 토마토, 20점, 최대 1장
(10, 3, 11, 2),  -- 양파, 11점, 최대 2장
(6, 3, 20, 1),   -- 치즈, 20점, 최대 1장

(13, 1, 30, 2),   -- 닭고기, 30점, 최대 1장
(4, 1, 14, 2),   -- 상추, 14점, 최대 2장
(6, 1, 23, 1),   -- 치즈, 23점, 최대 1장
(12, 1, 20, 2),   -- 토마토, 20점, 최대 1장
(10, 1, 13, 1);  -- 양파, 13점, 최대 1장


UPDATE test_type SET test_type_result = 'JORENGI' WHERE test_type_pk = 1;
UPDATE test_type SET test_type_result = '피자헐크' WHERE test_type_pk = 2;
UPDATE test_type SET test_type_result = '밥도둑킹' WHERE test_type_pk = 3;
UPDATE test_type SET test_type_result = '버거왕자' WHERE test_type_pk = 4;
UPDATE test_type SET test_type_result = '치킨지니' WHERE test_type_pk = 5;
UPDATE test_type SET test_type_result = '탕후루닌자' WHERE test_type_pk = 6;
UPDATE test_type SET test_type_result = '감튀요괴' WHERE test_type_pk = 7;
UPDATE test_type SET test_type_result = '김밥스파이' WHERE test_type_pk = 8;
UPDATE test_type SET test_type_result = '만두마법사' WHERE test_type_pk = 9;
UPDATE test_type SET test_type_result = '우유괴물' WHERE test_type_pk = 10;
UPDATE test_type SET test_type_result = '떡볶이베이비' WHERE test_type_pk = 11;
UPDATE test_type SET test_type_result = '피자마왕' WHERE test_type_pk = 12;
UPDATE test_type SET test_type_result = '토스트마스터' WHERE test_type_pk = 13;
UPDATE test_type SET test_type_result = '쿠키몬스터' WHERE test_type_pk = 14;
UPDATE test_type SET test_type_result = '초밥천재' WHERE test_type_pk = 15;
UPDATE test_type SET test_type_result = '우유괴물' WHERE test_type_pk = 16;

ALTER TABLE ingredient
ADD COLUMN ingr_side_url text;

UPDATE ingredient SET ingr_side_url = '/images/pork_side.png' WHERE ingr_pk = 1;
UPDATE ingredient SET ingr_side_url = '/images/beef_side.png' WHERE ingr_pk = 2;
UPDATE ingredient SET ingr_side_url = '/images/chicken_side.png' WHERE ingr_pk = 3;
UPDATE ingredient SET ingr_side_url = '/images/lettuce_side.png' WHERE ingr_pk = 4;
UPDATE ingredient SET ingr_side_url = '/images/tomato_side.png' WHERE ingr_pk = 5;
UPDATE ingredient SET ingr_side_url = '/images/cheese_side.png' WHERE ingr_pk = 6;
UPDATE ingredient SET ingr_side_url = '/images/bacon_side.png' WHERE ingr_pk = 7;
UPDATE ingredient SET ingr_side_url = '/images/shrimp_side.png' WHERE ingr_pk = 8;
UPDATE ingredient SET ingr_side_url = '/images/friedegg_side.png' WHERE ingr_pk = 9;
UPDATE ingredient SET ingr_side_url = '/images/onion_side.png' WHERE ingr_pk = 10;
UPDATE ingredient SET ingr_side_url = '/images/pickle_side.png' WHERE ingr_pk = 11;
UPDATE ingredient SET ingr_side_url = '/images/mintchoco_side.png' WHERE ingr_pk = 12;
UPDATE ingredient SET ingr_side_url = '/images/kimchi_side.png' WHERE ingr_pk = 13;
UPDATE ingredient SET ingr_side_url = '/images/strawberry_side.png' WHERE ingr_pk = 14;

ALTER TABLE game_log
DROP FOREIGN KEY FK_burger_recipe_TO_game_log;