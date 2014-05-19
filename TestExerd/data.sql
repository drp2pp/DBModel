DROP SEQUENCE TOUR_LOCAL;

DROP SEQUENCE TOUR_REGION;

DROP SEQUENCE TOUR_DATA;

CREATE SEQUENCE TOUR_LOCAL INCREMENT BY 1 START WITH 1;

CREATE SEQUENCE TOUR_REGION INCREMENT BY 1 START WITH 1;

CREATE SEQUENCE TOUR_DATA INCREMENT BY 1 START WITH 1;


INSERT INTO local_info (local_no, manager_id, local_name, gps_x, gps_y)
VALUES (TOUR_LOCAL.nextval, 'manager1', '광화문', '37.576037','126.9769');

INSERT INTO local_info (local_no, manager_id, local_name, gps_x, gps_y)
VALUES (TOUR_LOCAL.nextval, 'manager2', '흥례문', '37.576955','126.976884');

INSERT INTO local_info (local_no, manager_id, local_name, gps_x, gps_y)
VALUES (TOUR_LOCAL.nextval, 'manager3', '근정전', '37.578566','126.976954');

INSERT INTO local_info (local_no, manager_id, local_name, gps_x, gps_y)
VALUES (TOUR_LOCAL.nextval, 'manager4', '사정전', '37.579102','126.977008');

INSERT INTO local_info (local_no, manager_id, local_name, gps_x, gps_y)
VALUES (TOUR_LOCAL.nextval, 'manager5', '침전', '37.579561','126.97704');

INSERT INTO local_info (local_no, manager_id, local_name, gps_x, gps_y)
VALUES (TOUR_LOCAL.nextval, 'manager6', '향원전', '37.582337','126.977008');

INSERT INTO local_info (local_no, manager_id, local_name, gps_x, gps_y)
VALUES (TOUR_LOCAL.nextval, 'manager7', '경회루', '37.579736','126.975956');

INSERT INTO local_info (local_no, manager_id, local_name, gps_x, gps_y)
VALUES (TOUR_LOCAL.nextval, 'manager7', '동궁', '37.578911','126.978172');

/* data_type 1 text , 2 image, 3 voice, 4 vod*/
INSERT INTO data_info (data_no, data_file_add, data_type, local_no)
VALUES (TOUR_DATA.nextval, 'D:/workspace/ProjectDB/WebContent/upfolder/', '1', '1');
INSERT INTO data_info (data_no, data_file_add, data_type, local_no)
VALUES (TOUR_DATA.nextval, 'Path2', '2', '1');
INSERT INTO data_info (data_no, data_file_add, data_type, local_no)
VALUES (TOUR_DATA.nextval, 'Path3', '3', '1');
INSERT INTO data_info (data_no, data_file_add, data_type, local_no)
VALUES (TOUR_DATA.nextval, 'Path4', '1', '2');
INSERT INTO data_info (data_no, data_file_add, data_type, local_no)
VALUES (TOUR_DATA.nextval, 'Path5', '3', '2');

/*INSERT INTO region_info (region_no, region_name, uuid, major, minor, local_no)
VALUES (TOUR_REGION.nextval, );
*/