DROP TABLE comment;
drop table video_like;
drop table video;
drop table subscribe;
drop table channel;
drop table member;

-- 회원
CREATE TABLE member(
	id VARCHAR(20) PRIMARY KEY,
    password VARCHAR(20),
    email VARCHAR(50),
    phone VARCHAR(13)
);

-- 채널
CREATE TABLE channel(
	channel_code INT PRIMARY KEY AUTO_INCREMENT,
    channel_img VARCHAR(100),
    channel_name VARCHAR(50),
    id VARCHAR(20),
    FOREIGN KEY (id) REFERENCES member(id)
);

-- 동영상
CREATE TABLE video(
	video_code INT PRIMARY KEY AUTO_INCREMENT,
    video_url VARCHAR(100),
    video_img VARCHAR(100),
    video_title VARCHAR(80),
    video_count INT default(0),
    video_date datetime DEFAULT (current_timestamp),
    video_desc TEXT,
    channel_code INT,
    FOREIGN KEY (channel_code) REFERENCES channel(channel_code)
);

-- 댓글  
CREATE TABLE comment(
	comment_code INT PRIMARY KEY AUTO_INCREMENT,
    comment_text TEXT,
    comment_date datetime DEFAULT (current_timestamp),
    id VARCHAR(20),
    video_code INT,
    parent_code INT,
    FOREIGN KEY (id) REFERENCES member(id),
    FOREIGN KEY (video_code) REFERENCES video(video_code)
);

-- 구독 
CREATE TABLE subscribe(
	sub_code INT PRIMARY KEY AUTO_INCREMENT,
    id VARCHAR(20),
    channel_code INT,
    FOREIGN KEY (id) REFERENCES member(id),
    FOREIGN KEY (channel_code) REFERENCES channel(channel_code)
);

-- 좋아요
CREATE TABLE video_like(
	like_code INT PRIMARY KEY AUTO_INCREMENT,
    id VARCHAR(20),
    video_code INT,
    FOREIGN KEY (id) REFERENCES member(id),
    FOREIGN KEY (video_code) REFERENCES video(video_code)
);
insert into member(id, password, email, phone)
values('ackmu', '1234', 'akmu@gmail.com', 010-0000-0000);
select * from video
join channel using (channel_code);
insert into channel(channel_img, channel_name, id)
values('http://192.168.10.51:8082/channel/akmu.jpg', 'AKMU', 'akmu');

insert into channel(channel_img, channel_name, id)
values('http://192.168.10.51:8082/channel/dingo.jpg', '딩고 뮤직', 'Dingo');

insert into video(video_url, video_img, video_title, video_desc, channel_code)
values('http://192.168.10.51:8082/video/AKMU1.mp4', 
		'http://192.168.10.51:8082/thumbnail/akmu.webp',
        'AKMU - 후라이의 꿈 LIVE CLIP (FESTIVAL ver.)',
        'More about AKMU',
        1);
        
insert into video(video_url, video_img, video_title, video_desc, channel_code)
values('http://192.168.10.51:8082/video/day6.mp4', 
		'http://192.168.10.51:8082/thumbnail/day6.webp',
        'DAY6(데이식스)의 킬링보이스를 라이브로!',
        '데이식스의 쇼에 오신 걸 환영합니다',
        1);
        
SELECT * FROM channel;