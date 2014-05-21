DROP SEQUENCE TOUR_LOCAL;

DROP SEQUENCE TOUR_REGION;

DROP SEQUENCE TOUR_DATA;

CREATE SEQUENCE TOUR_LOCAL INCREMENT BY 1 START WITH 1;

CREATE SEQUENCE TOUR_REGION INCREMENT BY 1 START WITH 1;

CREATE SEQUENCE TOUR_DATA INCREMENT BY 1 START WITH 1;


INSERT INTO local_info (local_no, manager_id, local_name, gps_x, gps_y)
VALUES (TOUR_LOCAL.nextval, 'manager1', '��ȭ��', '37.576037','126.9769');

INSERT INTO local_info (local_no, manager_id, local_name, gps_x, gps_y)
VALUES (TOUR_LOCAL.nextval, 'manager2', '��ʹ�', '37.576955','126.976884');

INSERT INTO local_info (local_no, manager_id, local_name, gps_x, gps_y)
VALUES (TOUR_LOCAL.nextval, 'manager3', '������', '37.578566','126.976954');

INSERT INTO local_info (local_no, manager_id, local_name, gps_x, gps_y)
VALUES (TOUR_LOCAL.nextval, 'manager4', '������', '37.579102','126.977008');

INSERT INTO local_info (local_no, manager_id, local_name, gps_x, gps_y)
VALUES (TOUR_LOCAL.nextval, 'manager5', 'ħ��', '37.579561','126.97704');

INSERT INTO local_info (local_no, manager_id, local_name, gps_x, gps_y)
VALUES (TOUR_LOCAL.nextval, 'manager6', '�����', '37.582337','126.977008');

INSERT INTO local_info (local_no, manager_id, local_name, gps_x, gps_y)
VALUES (TOUR_LOCAL.nextval, 'manager7', '��ȸ��', '37.579736','126.975956');

INSERT INTO local_info (local_no, manager_id, local_name, gps_x, gps_y)
VALUES (TOUR_LOCAL.nextval, 'manager7', '����', '37.578911','126.978172');

/* ��Ʈ��ī���� ���� ��ó ����*/
INSERT INTO local_info (local_no, manager_id, local_name, gps_x, gps_y)
VALUES (TOUR_LOCAL.nextval, 'manager8', '��Ʈ��ǻ��', '37.494618','127.027593');

INSERT INTO local_info (local_no, manager_id, local_name, gps_x, gps_y)
VALUES (TOUR_LOCAL.nextval, 'manager9', '������5���ⱸ', '37.495518','127.028496');

INSERT INTO local_info (local_no, manager_id, local_name, gps_x, gps_y)
VALUES (TOUR_LOCAL.nextval, 'manager10', '�Ｚ����', '37.496631','127.026948');

/* ������ ���� */
/* data_type 1 text , 2 image, 3 voice, 4 vod*/
INSERT INTO data_info (data_no, data_path, data_type, local_no, region_no)
VALUES (TOUR_DATA.nextval, '��ȭ��', '2', '1', '1');
INSERT INTO data_info (data_no, data_path, data_type, local_no, region_no)
VALUES (TOUR_DATA.nextval, 'Path2', '1', '1', '1');
INSERT INTO data_info (data_no, data_path, data_type, local_no, region_no)
VALUES (TOUR_DATA.nextval, 'Path3', '3', '1', '1');
INSERT INTO data_info (data_no, data_path, data_type, local_no)
VALUES (TOUR_DATA.nextval, 'Path4', '1', '2');
INSERT INTO data_info (data_no, data_path, data_type, local_no)
VALUES (TOUR_DATA.nextval, '��ʹ�.jpg', '2', '2');
INSERT INTO data_info (data_no, data_path, data_type, local_no, region_no)
VALUES (TOUR_DATA.nextval, '������.jpg', '2', '3', '3');

/*����(Beacon)����*/
INSERT INTO region_info (region_no, region_name, uuid, major, minor, local_no)
VALUES (TOUR_REGION.nextval, '��ȭ��', '8492e75f-4fd6-469d-b132-043-fe94921d8', '11305', '19481', '1');
