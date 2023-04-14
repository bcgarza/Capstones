Rollback;
Begin Transaction;

Drop Table If Exists members Cascade;
Drop Table If Exists intergroups Cascade;
Drop Table If Exists events Cascade;
Drop Table If Exists membergroup Cascade;
Drop Table If Exists memberevent Cascade;

Create Table members(
	member_id serial,
	last_name varchar(50) Not Null,
	first_name varchar(50) Not Null,
	email varchar(75) Not Null,
	phone int,
	D_O_B date Not Null,
	email_reminder boolean Not Null, 
	Primary Key (member_id)
);

Create Table intergroups(
	group_id serial,
	group_name varchar(100) Not Null,
	Primary key (group_id)
);

Create Table events(
	events_id serial,
	event_name varchar(100) Not Null,
	discription varchar(1000) Not Null,
	start_date_time timestamp Not Null,
	duration int Not Null,
	group_id int,
	Primary key(events_id)
);

Create Table membergroup(
	primary key member_id int Not Null,
	primary key group_id int Not Null
);

Create Table memberevent(
	primary key member_id int Not Null,
	primary key events_id int Not Null
);

 Alter Table membergroup
Add Foreign Key (member_id) References members(member_id);

Alter Table membergroup
Add Foreign Key (group_id) References intergroups(group_id);

Alter Table memberevent
Add Foreign Key (member_id) References members(member_id);

Alter Table memberevent
Add Foreign Key (events_id) References events(events_id);

Alter Table events
Add Foreign Key (group_id) References intergroups(group_id);

commit;

Insert Into members (last_name, first_name, email, phone, d_o_b, email_reminder)
Values ('Garza', 'Brian', 'bcgarza@mail.com', 123-456-7899, '1991-08-23', 'true'),
('Steiner', 'Grant', 'grants@mail.com', 123-456-7898, '1991-08-24', 'true'),
('Huynh', 'Quang', 'quang@mail.com', 123-456-7897, '1991-08-25', 'true'),
('Little', 'Kevin', 'lilK@mail.com', 123-456-7896, '1991-08-26', 'true'),
('Stone', 'Alex', 'astone@mail.com', 123-456-7895, '1991-08-27', 'false'),
('Muhjob', 'Took', 'turka@mail.com', 123-456-7894, '1991-08-28', 'false'),
('Janess', 'Hugh', 'play@mail.com', 123-456-7893, '1991-08-29', 'true'),
('Bass', 'Bubble', 'bb@mail.com', 123-456-7892, '1991-08-30', 'false');


Insert Into intergroups (group_name)
Values ('Group 1'),
('Group 2'),
('Group 3');

Insert Into events (event_name, discription, start_date_time, duration, group_id) 
Values ('The Big Show', 'Don''t miss this amazing show!', '2023-05-05 15:00:00', 120,1),
('Discovering You', 'Learn all about you!', '2023-05-06 15:00:00', 120, 2),
('Find Peace', 'Control your emotions!', '2023-05-07 15:00:00', 120, 3),
('Its All Over', 'Prepare yourselves!', '2023-05-08 15:00:00', 120,1);


Insert Into membergroup (member_id, group_id)
Values (1,1),
(2,1),
(3,2),
(4,2),
(5,3),
(6,3);

Insert Into memberevent (member_id, events_id)
Values (1,1),
(2,2),
(3,3),
(4,4);



