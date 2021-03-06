DROP TABLE A;
CREATE TABLE A (a TEXT);
INSERT INTO A (a) VALUES ("1"), ("2"), ("3");
DROP TABLE B;
CREATE TABLE B (b TEXT);
INSERT INTO B (b) VALUES ("3"), ("4");
SELECT * FROM A;
SELECT * FROM B;

SELECT A.a, B.b FROM A CROSS JOIN B;
SELECT A.a, B.b FROM A INNER JOIN B ON A.a = B.b;
SELECT A.a, B.b FROM A LEFT JOIN B ON A.a = B.b;


PRAGMA foreign_keys=ON;

DROP TABLE priorities;
DROP TABLE notes;
DROP TABLE tags;
DROP TABLE notes_tags;

DROP VIEW view_all_notes;


CREATE TABLE priorities (
	_id INTEGER PRIMARY KEY,
	title TEXT UNIQUE NOT NULL
);

SELECT * FROM priorities;

INSERT INTO
	priorities (_id, title)
VALUES
	(0, "низкий"),
	(1, "нормальный"),
	(2, "высокий"), 
	(3, "кретичный");
	
SELECT * FROM priorities;

UPDATE priorities SET title = "критичный" WHERE _id = 3;

SELECT * FROM priorities;




CREATE TABLE notes (
	_id INTEGER PRIMARY KEY,
	subject TEXT NOT NULL,
	priority_id INTEGER DEFAULT NULL,
	FOREIGN KEY(priority_id) REFERENCES priorities(_id)
);

INSERT INTO
	notes (subject)
VALUES
	("заметка без приоритета");
	
INSERT INTO
	notes (subject, priority_id)
VALUES
	("невозможная заметка", 99);

INSERT INTO
	notes (subject, priority_id)
VALUES
	("первая неважная заметка", 0),
	("вторая неважная заметка", 0),
	("третья неважная заметка", 0),
	("первая нормальная заметка", 1),
	("вторая нормальная заметка", 1),
	("очень важная заметка", 2);

SELECT * FROM notes;

SELECT COUNT(notes._id), priorities.title
FROM notes
LEFT JOIN priorities ON priorities._id = notes.priority_id
GROUP BY notes.priority_id;
	
SELECT COUNT(notes._id), priorities.title
FROM notes
CROSS JOIN priorities ON priorities._id = notes.priority_id
GROUP BY notes.priority_id;
	

CREATE TABLE tags (
	_id INTEGER PRIMARY KEY,
	tag TEXT
);

INSERT INTO
	tags(_id, tag)
VALUES
	(1, "тег 1"),
	(2, "тэг 2"),
	(3, "тэг 3");
	

CREATE TABLE notes_tags (
	_id INTEGER PRIMARY KEY,
	note_id INTEGER NOT NULL,
	tag_id INTEGER NOT NULL,
	FOREIGN KEY(note_id) REFERENCES notes(_id),
	FOREIGN KEY(tag_id) REFERENCES tags(_id),
	UNIQUE (note_id, tag_id) ON CONFLICT REPLACE
);
	
	
INSERT INTO
	notes_tags (note_id, tag_id)
VALUES
	(0, 0),
	(0, 1),
	(1, 1);
	

SELECT notes._id, notes.subject, GROUP_CONCAT(tags.tag)
FROM notes
LEFT JOIN notes_tags ON notes_tags.note_id = notes._id
LEFT JOIN tags ON tags._id = notes_tags.tag_id
GROUP BY notes._id;

SELECT notes._id, notes.subject, tags.tag
FROM notes
LEFT JOIN notes_tags ON notes_tags.note_id = notes._id
LEFT JOIN tags ON tags._id = notes_tags.tag_id;

SELECT notes._id, notes.subject, priorities.title FROM notes LEFT JOIN priorities ON notes.priority_id = priorities._id;

CREATE VIEW view_all_notes AS SELECT notes._id, notes.subject, priorities.title FROM notes LEFT JOIN priorities ON notes.priority_id = priorities._id ORDER BY notes.subject;

SELECT * FROM view_all_notes;

INSERT INTO notes_tags (note_id, tag_id) VALUES (1,1), (1,2), (2,3)