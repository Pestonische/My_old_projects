CREATE TABLE IF NOT EXISTS serviceman (
    id serial primary key,
    department_id int not null,
    first_name varchar(20) not null,
    position varchar(20) default 'unknown',
    salary int default 0
);

insert into serviceman (id, department_id, first_name, position, salary)
            values (1, 1, 'vladOS', 'grand_master_beat', 999999),
                   (2, 1, 'alexis', 'aaaaa', 1),
                   (3, 2, 'noname', 'noposition', 10000000);