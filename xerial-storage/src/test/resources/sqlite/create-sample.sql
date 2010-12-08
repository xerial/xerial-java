drop table student;

create table student
(
  id integer primary key autoincrement not null,
  name string,
  class string,
  year integer
);


insert into student(name, class, year) values("leo", "A", 2007);
insert into student(name, class, year) values("lucy", "B", 2007);
insert into student(name, class, year) values("mary", "A", 2006);
insert into student(name, class, year) values("tom", "C", 2006);
insert into student(name, class, year) values("toby", "C", 2007);
insert into student(name, class, year) values("alex", "A", 2007);
insert into student(name, class, year) values("rio", "B", 2006);
insert into student(name, class, year) values("fox", "B", 2006);
