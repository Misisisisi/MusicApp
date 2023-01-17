CREATE DATABASE musicApp CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE album (
    album_id int NOT NULL AUTO_INCREMENT,
    performer varchar(255) NOT NULL,
    albumTitle varchar(255) NOT NULL,
    releaseDate date NOT NULL,
    version varchar(255) NOT NULL,
    PRIMARY KEY (album_id)
);

CREATE TABLE track (
    track_id int NOT NULL AUTO_INCREMENT,
    album_id int NOT NULL,
    trackTitle varchar(255) NOT NULL,
    durationTime TIME NOT NULL ,
    PRIMARY KEY (track_id),
    FOREIGN KEY (album_id) REFERENCES album(album_id)
);


INSERT INTO album (performer, albumTitle, releaseDate, version) VALUES ('Kimbra', 'Vows', '2011-08-29', 'original: Australian - New Zealand');
INSERT INTO album (performer, albumTitle, releaseDate, version) VALUES ('Kimbra', 'Vows', '2012-08-07', 'longer: North American - European');


INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (1, 'Settle Down', '00:04:17');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (1, 'Cameo Lover', '00:04:02');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (1, 'Two Way Street', '00:04:28');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (1, 'Old Flame', '00:04:27');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (1, 'Good Intent', '00:03:32');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (1, 'Plain Gold Ring', '00:04:02');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (1, 'Call me', '00:04:32');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (1, 'Limbo', '00:03:51');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (1, 'Wandering Limbs', '00:05:26');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (1, 'Withdraw', '00:04:06');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (1, 'The Build Up', '00:05:02');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (1, 'Somebody Please', '00:02:20');

INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (2, 'Settle Down', '00:04:02');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (2, 'Something in the Way You Are', '00:04:23');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (2, 'Cameo Lover', '00:04:03');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (2, 'Two Way Street', '00:04:20');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (2, 'Old Flame', '00:04:30');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (2, 'Good Intent', '00:03:32');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (2, 'Plain Gold Ring', '00:04:32');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (2, 'Come into My Head', '00:04:39');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (2, 'Sally I Can See You', '00:03:58');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (2, 'Posse', '00:05:07');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (2, 'Home', '00:03:04');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (2, 'The Build Up', '00:05:06');
INSERT INTO track (album_id,  trackTitle, durationTime) VALUES (2, 'Warrior', '00:04:16');
