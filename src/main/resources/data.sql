insert into user_details(birth_date, id, name) values(current_date(), 10001, 'Ayaan');
insert into user_details(birth_date, id, name) values(current_date(), 10002, 'Tia');
insert into user_details(birth_date, id, name) values(current_date(), 10003, 'Reyansh');

insert into post(id, description, user_id) values(20001, 'I want to learn AWS', 10001);
insert into post(id, description, user_id) values(20002, 'I want to learn CI/CD pipelines', 10002);
insert into post(id, description, user_id) values(20003, 'I want to get AWS Certification', 10001);
insert into post(id, description, user_id) values(20004, 'I want to build Microservices project', 10002);