INSERT INTO client (ID, Name) VALUES (01, 'SupSap');
INSERT INTO client (ID, Name) VALUES (02, 'Bim-Bom');
INSERT INTO client (ID, Name) VALUES (03, 'Garden');
INSERT INTO client (ID, Name) VALUES (04, 'GreenOver');
INSERT INTO client (ID, Name) VALUES (05, 'Krupsi');

INSERT INTO worker (ID, Name, Birthday, Level, Salary) VALUES (01, 'Bob Strange', '1990-02-01', 'Junior', 800);
INSERT INTO worker (ID, Name, Birthday, Level, Salary) VALUES (02, 'Kim Korty', '1985-05-15', 'Senior', 3000);
INSERT INTO worker (ID, Name, Birthday, Level, Salary) VALUES (03, 'Stan Frozen', '1983-06-11', 'Senior', 3100);
INSERT INTO worker (ID, Name, Birthday, Level, Salary) VALUES (04, 'Alfred Montery', '1994-09-21', 'Senior', 2900);
INSERT INTO worker (ID, Name, Birthday, Level, Salary) VALUES (05, 'Bill Spaw', '1981-02-28', 'Middle', 1200);
INSERT INTO worker (ID, Name, Birthday, Level, Salary) VALUES (06, 'Gregor McBoo', '1985-03-10', 'Middle', 1500);
INSERT INTO worker (ID, Name, Birthday, Level, Salary) VALUES (07, 'Suren Vasardyan', '1991-11-03', 'Junior', 900);
INSERT INTO worker (ID, Name, Birthday, Level, Salary) VALUES (08, 'Li Mo', '1995-07-19', 'Trainee', 700);
INSERT INTO worker (ID, Name, Birthday, Level, Salary) VALUES (09, 'Dunkan Bread', '1989-07-17', 'Junior', 850);
INSERT INTO worker (ID, Name, Birthday, Level, Salary) VALUES (10, 'Amirah Al-Farsi', '1992-09-11', 'Trainee', 650);

INSERT INTO project (ID, CLIENT_ID, START_DATE, FINISH_DATE) VALUES (01, 01, '2023-01-01', '2023-12-30');
INSERT INTO project (ID, CLIENT_ID, START_DATE, FINISH_DATE) VALUES (02, 02, '2023-02-01', '2023-11-30');
INSERT INTO project (ID, CLIENT_ID, START_DATE, FINISH_DATE) VALUES (03, 03, '2023-01-01', '2023-10-31');
INSERT INTO project (ID, CLIENT_ID, START_DATE, FINISH_DATE) VALUES (04, 04, '2023-03-01', '2023-11-30');
INSERT INTO project (ID, CLIENT_ID, START_DATE, FINISH_DATE) VALUES (05, 05, '2023-02-01', '2023-09-30');
INSERT INTO project (ID, CLIENT_ID, START_DATE, FINISH_DATE) VALUES (06, 02, '2023-04-01', '2023-11-30');
INSERT INTO project (ID, CLIENT_ID, START_DATE, FINISH_DATE) VALUES (07, 01, '2023-06-01', '2023-09-30');
INSERT INTO project (ID, CLIENT_ID, START_DATE, FINISH_DATE) VALUES (08, 05, '2023-03-01', '2023-11-30');
INSERT INTO project (ID, CLIENT_ID, START_DATE, FINISH_DATE) VALUES (09, 03, '2023-06-01', '2023-11-30');
INSERT INTO project (ID, CLIENT_ID, START_DATE, FINISH_DATE) VALUES (10, 04, '2023-05-01', '2023-10-31');

INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (01, 01);
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (02, 03);
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (03, 04);
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (04, 05);
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (05, 06);
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (06, 02);
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (07, 03);
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (08, 02);
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (09, 03);
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (10, 05);
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (01, 02);
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (02, 07);
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (03, 04);
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (04, 01);
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (05, 05);
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (06, 08);
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (07, 10);
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (01, 10);
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (02, 08);
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (03, 07);
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (04, 07);
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES (05, 09);