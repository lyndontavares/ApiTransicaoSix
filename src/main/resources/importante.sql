select 
t.table_name, t.comments , c.column_name, co.data_type, co.data_length, co.data_precision, c.comments
from 
user_col_comments c ,user_tab_comments t, USER_TAB_COLUMNS co  
where 
co.column_name = c.column_name and  
co.table_name = t.table_name and 
c.table_name = t.table_name 
order by 
t.table_name, c.column_name 



select
    tc.table_name, tc.comments, cc.column_name,  cc.comments 
from 
    user_tab_comments tc, user_col_comments cc 
where 
    tc.table_name = cc.table_name and 
    tc.table_name='CFGLOCA'

SELECT * FROM USER_TAB_COLUMNS where table_name='CFGLOCA' order by table_name
    
    
    
    
select
    tc.table_name, tc.comments, cc.column_name,  cc.comments 
from 
    user_tab_comments tc, user_col_comments cc ,  USER_TAB_COLUMNS co
where 
    tc.table_name = cc.table_name and 
    co.table_name = cc.table_name  and
    co.column_name = cc.column_name and
    co.table_name='CFGLOCA'

    
    
    
    
 

select * from user_tab_comments order by user_tab_comments.table_name
select * from user_col_comments order by user_col_comments.table_name

SELECT * FROM USER_OBJECTS where object_type='TABLE'
SELECT * FROM USER_TAB_COLUMNS order by table_name
SELECT * FROM USER_TABLES order by table_name
SELECT * FROM cols


SELECT *
FROM ALL_TABLES;

SELECT    
    COLUNAS.COLUMN_NAME AS COLUNA,   
    COLUNAS.DATA_TYPE AS TIPO,   
    DECODE(COLUNAS.DATA_PRECISION, NULL, COLUNAS.CHAR_COL_DECL_LENGTH, COLUNAS.DATA_PRECISION)  AS TAMANHO,   
    COLUNAS.NULLABLE AS EH_NULO   
    
FROM    
    USER_TABLES TABELAS,   
    USER_TAB_COLUMNS COLUNAS   
WHERE    
    -- JOINS    
    TABELA.TABLE_NAME = COLUNAS.TABLE_NAME   
    AND TABELA.TABLE_NAME = 'FATFATU'  

SELECT 
    COLUNAS.COLUMN_NAME AS COLUNA,
    COLUNAS.DATA_TYPE AS TIPO,
    DECODE(COLUNAS.DATA_PRECISION, NULL, 
    COLUNAS.CHAR_COL_DECL_LENGTH, COLUNAS.DATA_PRECISION)  AS TAMANHO,
    COLUNAS.NULLABLE AS EH_NULO
 
FROM 
    USER_TABLES TABELAS,
    USER_TAB_COLUMNS COLUNAS
WHERE 
    -- JOINS 
    TABELA.TABLE_NAME = COLUNAS.TABLE_NAME

    
-----------------------------------------------    


select * from cols
select * from USER_TABLES

select 

t.table_name, t.comments , c.column_name, co.data_type, co.data_length, co.data_precision, c.comments


from user_col_comments c ,user_tab_comments t, cols co  
where co.column_name = c.column_name and  c.table_name = t.table_name 
order by t.table_name, c.column_name 



SELECT *
  FROM ALL_OBJECTS
 WHERE OBJECT_TYPE IN ('FUNCTION',
                       'PROCEDURE',
                       'PACKAGE',
                       'VIEW',
                       'TABLE',
                       'TRIGGER',
                       'JOB',
                       'SEQUENCES',
                       'PACKAGE BODY')
   AND owner = 'ADR_ASSCSA'
 ORDER BY object_name
-- 
SELECT TEXT 
FROM USER_SOURCE 
WHERE TYPE IN('PROCEDURE','TRIGGER'); 
--
SELECT * 
FROM USER_SOURCE 
WHERE TYPE IN(  'TRIGGER'); 
--
SELECT TEXT 
FROM USER_SOURCE 
WHERE TYPE IN(  'PACKAGE BODY'); 
--
 SELECT    
    COLUNAS.COLUMN_NAME AS COLUNA,   
    COLUNAS.DATA_TYPE AS TIPO,   
    DECODE(COLUNAS.DATA_PRECISION, NULL, COLUNAS.CHAR_COL_DECL_LENGTH, COLUNAS.DATA_PRECISION)  AS TAMANHO,   
    COLUNAS.NULLABLE AS EH_NULO      
FROM    
    USER_TABLES TABELA,   
    USER_TAB_COLUMNS COLUNAS   
WHERE    
    TABELA.TABLE_NAME = COLUNAS.TABLE_NAME   
--
select distinct t.table_name, t.comments , c.column_name, co.data_type, co.data_length, co.data_precision, c.comments 
from user_col_comments c ,user_tab_comments t, cols co  
where co.column_name = c.column_name and  c.table_name = t.table_name 
order by t.table_name, c.column_name 


SELECT TABLE_NAME,
       column_name,
       DECODE(c.DATA_TYPE,
              'VARCHAR2',
              c.DATA_TYPE || '(' || c.DATA_LENGTH || ')',
              'NUMBER',
              DECODE(c.data_precision, 
                     NULL, 
                     c.DATA_TYPE, 
                     0, 
                               c.DATA_TYPE, 
                     c.DATA_TYPE || '(' || c.data_precision || DECODE(c.data_scale, 
                                                                      NULL, 
                                                                      ')', 
                                                                      0, 
                                                                      ')' , 
                                                                      ', ' || c.data_scale || ')')),
              c.DATA_TYPE) data_type
  FROM cols c, obj o
  WHERE c.TABLE_NAME = o.object_name
     AND o.object_type = 'VIEW'     
     AND c.table_name LIKE '%'
     ORDER BY c.table_name, c.column_id;
     
 --    
     select * from dba_tables where tablespace_name = 'USERS' and owner = 'ADR_ASSCSA'
     
 --
     
     


 
