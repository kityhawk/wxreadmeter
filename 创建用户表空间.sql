select * from dba_data_files;
select username,default_tablespace from dba_users;
create tablespace whgas_tbspace datafile '/u01/app/oracle/oradata/orcl/orclpdb/whgas_data_01.dbf' SIZE 512M AUTOEXTEND on next 32M MAXSIZE UNLIMITED;
create user whgas identified by whgas258369;
alter user whgas default tablespace whgas_tbspace; 
grant create session,create table,create view,create sequence,unlimited tablespace to whgas;