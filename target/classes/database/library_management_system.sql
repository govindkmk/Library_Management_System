create database library_management_system;

use library_management_system;

create table user(
	id int(11) primary key auto_increment,
    name varchar(30),
    password varchar(30),
    email varchar(30),
    phone_number bigint,
    status enum('Active','Inactive'),
    registration_date date,
	updation_date date
    
);

create table category(
	id int(11) primary key auto_increment,
    name varchar(30),
    status enum('Active','Inactive'),
	creation_date date,
	updation_date date

);

create table author(
	id int(11) primary key auto_increment,
    name varchar(30),
	creation_date date,
	updation_date date

);

create table book(
	id int(11) primary key auto_increment,
    name varchar(30),
    category_id int(11),
    author_id int(11),
    isbn_number int(30),
    price decimal,
	creation_date date,
	updation_date date,
    foreign key(category_id) references category(id),
    foreign key(author_id) references author(id)

);

create table issue_book(
	id int(11) primary key auto_increment,
	user_id int(11),
    book_id int(11),
    issue_date date,
    return_date date,
    fine decimal,
    foreign key(user_id) references user(id),
    foreign key(book_id) references book(id)

);

ALTER TABLE book
ADD CONSTRAINT fk_category
FOREIGN KEY (category_id)
REFERENCES category(id)
ON DELETE CASCADE;

ALTER TABLE book
ADD CONSTRAINT fk_author
FOREIGN KEY (author_id)
REFERENCES author(id)
ON DELETE CASCADE;

ALTER TABLE book
ADD COLUMN issue_book_id INT;

ALTER TABLE book
ADD CONSTRAINT fk_issue_book_id
FOREIGN KEY (issue_book_id) REFERENCES Issue_book(id);

ALTER TABLE book
DROP FOREIGN KEY fk_issue_book_id;

ALTER TABLE book
DROP COLUMN issue_book_id;

UPDATE USER set email='govindkk152@gmail.com', password='Gkmk2002' WHERE id = 1;
UPDATE USER set email='amirjan@gmail.com', password='Amir' WHERE id = 2;

ALTER TABLE user
MODIFY COLUMN phone_number VARCHAR(50);
